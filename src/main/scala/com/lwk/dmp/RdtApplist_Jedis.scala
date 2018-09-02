package com.lwk.dmp

import com.lwk.tools.JedisPoolss
import org.apache.commons.lang.StringUtils
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Row, SQLContext}

object RdtApplist_Jedis {

    def main(args: Array[String]): Unit = {
      val sparkConf = new SparkConf
      sparkConf.setMaster("local[*]")
        .setAppName("toParquetFile").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      val sparkContext = new SparkContext(sparkConf)
      val sqlContext = new SQLContext(sparkContext)
      var appdict = sparkContext.textFile("dict/app_dict.txt").map(line=>line.split("\t",-1)).filter(t=>t.length>=5).map(t=>(t(4),t(1)))
      var tobd = appdict.collect().toMap

      appdict.foreachPartition(list=>{
          val jedis = JedisPoolss.getJedis()
          list.foreach(
            value =>{
            jedis.hset("appdict",value._1,value._2)
                    }
          )
      })


      val bd: Broadcast[Map[String, String]] = sparkContext.broadcast(tobd)
      var bdvalue = bd.value
      val data: DataFrame = sqlContext.read.parquet("result")

      val result: RDD[(String, List[Double])] = data.mapPartitions(partition=>{
        val jedis = JedisPoolss.getJedis()
        partition.map(
          row => {
            val appId = row.getAs[String]("appid")
            var appName = row.getAs[String]("appname")
            if (StringUtils.isEmpty(appName)) {
              appName = jedis.hget("appdict",appId)
              if(StringUtils.isEmpty(appName)){
                appName = appId
              }
          }
            (appName, ProvinceCityAnalistCore.analist(row)._2)
          }
        )

      })



//        val result = data.map(row => {
//          val appId = row.getAs[String]("appid")
//          var appName = row.getAs[String]("appname")
//          if (StringUtils.isEmpty(appName)) {
//            appName = bdvalue.getOrElse(appId, appId)
//          }
//          (appName, ProvinceCityAnalistCore.analist(row)._2)
//        })

        val appMsg: RDD[(String, List[Double])] = result.reduceByKey(
          (list1, list2) => {
            val list3: List[(Double, Double)] = list1 zip list2
            val list4 = list3.map(t => {
              t._1 + t._2
            })
            list4
          }
        )

      appMsg.foreach(println)


    }

}

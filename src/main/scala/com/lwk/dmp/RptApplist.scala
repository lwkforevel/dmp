package com.lwk.dmp

import org.apache.commons.lang.StringUtils
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SQLContext}

object RptApplist {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf
    sparkConf.setMaster("local[*]")
      .setAppName("toParquetFile").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
    var appdict = sparkContext.textFile("dict/app_dict.txt").map(line=>line.split("\t",-1)).filter(t=>t.length>=5).map(t=>(t(4),t(1))).collect().toMap
    val bd: Broadcast[Map[String, String]] = sparkContext.broadcast(appdict)
    var bdvalue = bd.value
    val data: DataFrame = sqlContext.read.parquet("result")
    val result = data.map(f = row => {
      val appId = row.getAs[String]("appid")
      var appName = row.getAs[String]("appname")
      if(StringUtils.isEmpty(appName)){
        appName = bdvalue.getOrElse(appId,appId)
      }
      (appName,ProvinceCityAnalistCore.analist(row)._2)
    })

    val appMsg = result.reduceByKey(
      (list1,list2)=>{
        val list3: List[(Double, Double)] = list1 zip list2
        val list4 = list3.map(t=>{t._1+t._2})
        list4
      }
    )


  }

}

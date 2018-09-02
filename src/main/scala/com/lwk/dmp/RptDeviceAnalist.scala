package com.lwk.dmp

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object RptDeviceAnalist {


  def main(args: Array[String]): Unit = {

    // sparkcontext
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("终端设备")
    val sc = new SparkContext(sparkConf)

    // 读取数据 - parquet
    val sqlc = new SQLContext(sc)
    // 数据文件 - dataframe
    val parquet = sqlc.read.parquet("result1")
    val baseData = parquet.map(row => {
      val ispname = row.getAs[String]("ispname")
      val nwname = row.getAs[String]("networkmannername")
      val dtype = row.getAs[Int]("devicetype")
      val client = row.getAs[Int]("client")
      (ispname, nwname, dtype, client, ProvinceCityAnalistCore.analist(row)._2)
    }).cache()

    baseData.foreach(println)

    val ispMsg: RDD[(String, List[Double])] = baseData.map(t=>(t._1,t._5)).reduceByKey((list1, list2)=>{
      val list3 = list1 zip list2
      list3.map(t=>t._1+t._2)
    })

    ispMsg.foreach(println)

    val networkmannernameMsg: RDD[(String, List[Double])] = baseData.map(t=>(t._2,t._5)).reduceByKey((list1, list2)=>{
      val list3 = list1 zip list2
      list3.map(t=>t._1+t._2)
    })

    networkmannernameMsg.foreach(println)

    val devicetypeMsg: RDD[(Int, List[Double])] = baseData.map(t=>(t._3,t._5)).reduceByKey((list1, list2)=>{
      val list3 = list1 zip list2
      list3.map(t=>t._1+t._2)
    })

    devicetypeMsg.foreach(println)

    val clientMsg: RDD[(Int, List[Double])] = baseData.map(t=>(t._4,t._5)).reduceByKey((list1, list2)=>{
      val list3 = list1 zip list2
      list3.map(t=>t._1+t._2)
    })

    clientMsg.foreach(println)

  }

}

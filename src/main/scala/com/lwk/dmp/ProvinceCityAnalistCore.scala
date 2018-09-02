package com.lwk.dmp

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Row, SQLContext}

object ProvinceCityAnalistCore {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf
    sparkConf.setMaster("local[*]")
      .setAppName("toParquetFile").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
    val result: DataFrame = sqlContext.read.parquet("result/")

    val baseData: RDD[(String, String, Int, Int, List[Double])] = result.map(row => {
      val ispname = row.getAs[String]("ispname")
      val nwname = row.getAs[String]("networkmannername")
      val dtype = row.getAs[Int]("devicetype")
      val client = row.getAs[Int]("client")
      val data: ((String, String), List[Double]) = analist(row)
      (ispname, nwname, dtype, client,data._2)
    }).cache()

    val a = baseData.map(t=>(t._1,t._5)).reduceByKey(
      (list1,list2)=>{
          val list = list1 zip list2
          list.map(t=>t._1+t._2)
      })


   baseData.map(t=>(t._2,t._5)).reduceByKey(
     (list1,list2)=>{
       val list = list1 zip list2
       list.map(t=>t._1+t._2)
     })
   baseData.map(t=>(t._3,t._5)).reduceByKey(
     (list1,list2)=>{
       val list = list1 zip list2
       list.map(t=>t._1+t._2)
     })
    baseData.map(t=>(t._4,t._5)).reduceByKey(
      (list1,list2)=>{
        val list = list1 zip list2
        list.map(t=>t._1+t._2)
      })



  }


  def analist(row: Row) ={
    val pName = row.getAs[String]("provincename")
    val cName = row.getAs[String]("cityname")
    val rMode = row.getAs[Int]("requestmode")
    val pNode = row.getAs[Int]("processnode")
    val effect = row.getAs[Int]("iseffective")
    val bill = row.getAs[Int]("isbilling")
    val isbid = row.getAs[Int]("isbid")
    val iswin = row.getAs[Int]("iswin")
    val adorderid = row.getAs[Int]("adorderid")
    val winprice = row.getAs[Double]("winprice")
    val adpayment = row.getAs[Double]("adpayment")
    // 广告请求
    val adRequest = if (rMode == 1) {
      if (pNode == 1) {
        List[Double](1, 0, 0)
      } else if (pNode == 2) {
        List[Double](1, 1, 0)
      } else if (pNode == 3) {
        List[Double](1, 1, 1)
      } else List[Double](0, 0, 0)
    } else {
      List[Double](0, 0, 0) // 原始请求，有效请求，广告请求
    }

    // 广告参与竞价
    val adRtb = if (effect == 1 && bill == 1) {
      if (isbid == 1 && adorderid != 0) List[Double](1, 0) else List[Double](0,0)
      if (iswin == 1) List[Double](0, 1) else List[Double](0, 0)
    } else List[Double](0, 0) // 参与竞价，竞价成功

    // 展示点击
    val adShowClick = if (effect == 1) {
      if (rMode == 2) {
        List[Double](1, 0)
      } else if (rMode == 3) {
        List[Double](0, 1)
      } else List[Double](0, 0)
    } else List[Double](0, 0)

    // 消费成本
    val adCost = if (effect == 1 && bill == 1 && iswin == 1) {
      List[Double](winprice / 1000, adpayment / 1000)
    } else List[Double](0, 0)

    ((pName, cName), adRequest ++ adRtb ++ adShowClick ++ adCost)
  }


}

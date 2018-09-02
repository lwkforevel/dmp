package com.lwk.dmp

import com.lwk.bean.Adlog
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}

object ToParquetFile2 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf
    sparkConf.setMaster("local[*]")
      .setAppName("toParquetFile").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.sql.parquet.compression.codec", "snappy")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
    val textFile = sparkContext.textFile("dmp/2016-10-01_06_p1_invalid.1475274123982.log")
    val baseData: RDD[Array[String]] = textFile.map(_.split(",", -1)).filter(_.length >= 85)
    val adlog: RDD[Adlog] = baseData.map(t=>Adlog.applyBean(t))
    val dataframe = sqlContext.createDataFrame(adlog)
    dataframe.write.parquet("result1")
  }
}

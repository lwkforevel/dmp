package com.lwk.dmp

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SQLContext}

object ToReadPartion {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf
    sparkConf.setMaster("local[*]")
      .setAppName("toParquetFile").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
    val dataframe: DataFrame = sqlContext.read.parquet("result")

    dataframe.printSchema()

    dataframe.foreach(println)

  }
}

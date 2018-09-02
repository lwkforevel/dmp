package com.lwk.dmp

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SQLContext}

object ProviceCityAnalist {


  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf
    sparkConf.setMaster("local[*]")
      .setAppName("toParquetFile").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
    val dataFrame: DataFrame = sqlContext.read.parquet("result")
    dataFrame.printSchema()
    dataFrame.registerTempTable("adtable")
    sqlContext.sql("" +
      "select provincename,cityname,"+
      "sum(case when requestmode =1 and processnode >=1 then 1 else 0 end) as `orginalrs`," +
      "sum(case when requestmode =1 and processnode >=2 then 1 else 0 end)  as `validrs`, " +
      "sum(case when requestmode =1 and processnode =3 then 1 else 0 end)  as `adversizers`, " +
      "sum(case when iseffective ='1' and isbilling ='1' and isbid ='1' and adorderid!=0 then 1 else 0 end)   as `enternums`,"+
      "sum(case when iseffective ='1' and isbilling ='1' and iswin ='1' then 1 else 0 end)   as `biddingnums`," +
      "sum(case when requestmode =2 and iseffective ='1' then 1 else 0 end)   as `shownums`," +
      "sum(case when requestmode =3 and iseffective ='1' then 1 else 0 end)   as `clicknums`," +
      "sum(case when iseffective ='1' and isbilling ='1'  and iswin ='1' then winprice/1000 else 0 end) as `dspconsume`," +
      "sum(case when iseffective ='1' and isbilling ='1'  and iswin ='1' then adpayment/1000 else 0 end) as `cost`" +
      " from adtable group by provincename,cityname").show()
  //  sqlContext.sql("select * from adtable").show()
    dataFrame.printSchema()

  }


}

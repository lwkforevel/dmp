package com.lwk.dmp

import com.lwk.tools.Implicits
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{StructField, _}
import org.apache.spark.sql.{DataFrame, Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

object ToParquetFile {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf
    sparkConf.setMaster("local[*]")
      .setAppName("toParquetFile").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
    val textFile = sparkContext.textFile("dmp/2016-10-01_06_p1_invalid.1475274123982.log")
    val baseData: RDD[Array[String]] = textFile.map(_.split(",", -1)).filter(_.length >= 85)
    import com.lwk.tools.Implicits._
    val rowdata: RDD[Row] = baseData.map(arr => {
      Row(
        arr(0)   ,
        arr(1)  .toIntPlugs,
        arr(2)  .toIntPlugs,
        arr(3)  .toIntPlugs,
        arr(4)  .toIntPlugs,
        arr(5)  ,
        arr(6)  ,
        arr(7)  .toIntPlugs,
        arr(8)  .toIntPlugs,
        arr(9)  .toDoublePlugs,
        arr(10) .toDoublePlugs,
        arr(11) ,
        arr(12) ,
        arr(13) ,
        arr(14) ,
        arr(15) ,
        arr(16) ,
        arr(17) .toIntPlugs,
        arr(18) ,
        arr(19) ,
        arr(20) .toIntPlugs,
        arr(21) .toIntPlugs,
        arr(22) ,
        arr(23) ,
        arr(24) ,
        arr(25) ,
        arr(26) .toIntPlugs,
        arr(27) ,
        arr(28) .toIntPlugs,
        arr(29),
        arr(30) .toIntPlugs,
        arr(31) .toIntPlugs,
        arr(32) .toIntPlugs,
        arr(33) ,
        arr(34) .toIntPlugs,
        arr(35) .toIntPlugs,
        arr(36) .toIntPlugs,
        arr(37) ,
        arr(38) .toIntPlugs,
        arr(39) .toIntPlugs,
        arr(40) .toDoublePlugs,
        arr(41) .toDoublePlugs,
        arr(42) .toIntPlugs,
        arr(43) ,
        arr(44) .toDoublePlugs,
        arr(45) .toDoublePlugs,
        arr(46) ,
        arr(47) ,
        arr(48) ,
        arr(49) ,
        arr(50) ,
        arr(51) ,
        arr(52) ,
        arr(53) ,
        arr(54) ,
        arr(55) ,
        arr(56) ,
        arr(57) .toIntPlugs,
        arr(58) .toDoublePlugs,
        arr(59) .toIntPlugs,
        arr(60) .toIntPlugs,
        arr(61) ,
        arr(62) ,
        arr(63) ,
        arr(64) ,
        arr(65) ,
        arr(66) ,
        arr(67) ,
        arr(68) ,
        arr(69) ,
        arr(70) ,
        arr(71) ,
        arr(72) 	,
        arr(73) .toIntPlugs,
        arr(74) .toDoublePlugs,
        arr(75) .toDoublePlugs,
        arr(76) .toDoublePlugs,
        arr(77) .toDoublePlugs,
        arr(78) .toDoublePlugs,
        arr(79) ,
        arr(80) ,
        arr(81) ,
        arr(82) ,
        arr(83) ,
        arr(84) .toIntPlugs
      )
    })
    rowdata.foreach(t => {
      println("---------------"); println(t)
    })
    val schema = StructType(
      List(
        StructField("sessionid", StringType),
        StructField("advertisersid", IntegerType),
        StructField("adorderid", IntegerType),
        StructField("adcreativeid", IntegerType),
        StructField("adplatformproviderid", IntegerType),
        StructField("sdkversion", StringType),
        StructField("adplatformkey", StringType),
        StructField("putinmodeltype", IntegerType),
        StructField("requestmode", IntegerType),
        StructField("adprice", DoubleType),
        StructField("adppprice", DoubleType),
        StructField("requestdate", StringType),
        StructField("ip", StringType),
        StructField("appid", StringType),
        StructField("appname", StringType),
        StructField("uuid", StringType),
        StructField("device", StringType),
        StructField("client", IntegerType),
        StructField("osversion", StringType),
        StructField("density", StringType),
        StructField("pw", IntegerType),
        StructField("ph", IntegerType),
        StructField("long", StringType),
        StructField("lat", StringType),
        StructField("provincename", StringType),
        StructField("cityname", StringType),
        StructField("ispid", IntegerType),
        StructField("ispname", StringType),
        StructField("networkmannerid", IntegerType),
        StructField("networkmannername", StringType),
        StructField("iseffective", IntegerType),
        StructField("isbilling", IntegerType),
        StructField("adspacetype", IntegerType),
        StructField("adspacetypename", StringType),
        StructField("devicetype", IntegerType),
        StructField("processnode", IntegerType),
        StructField("apptype", IntegerType),
        StructField("district", StringType),
        StructField("paymode", IntegerType),
        StructField("isbid", IntegerType),
        StructField("bidprice", DoubleType),
        StructField("winprice", DoubleType),
        StructField("iswin", IntegerType),
        StructField("cur", StringType),
        StructField("rate", DoubleType),
        StructField("cnywinprice", DoubleType),
        StructField("imei", StringType),
        StructField("mac", StringType),
        StructField("idfa", StringType),
        StructField("openudid", StringType),
        StructField("androidid", StringType),
        StructField("rtbprovince", StringType),
        StructField("rtbcity", StringType),
        StructField("rtbdistrict", StringType),
        StructField("rtbstreet", StringType),
        StructField("storeurl", StringType),
        StructField("realip", StringType),
        StructField("isqualityapp", IntegerType),
        StructField("bidfloor", DoubleType),
        StructField("aw", IntegerType),
        StructField("ah", IntegerType),
        StructField("imeimd5", StringType),
        StructField("macmd5", StringType),
        StructField("idfamd5", StringType),
        StructField("openudidmd5", StringType),
        StructField("androididmd5", StringType),
        StructField("imeisha1", StringType),
        StructField("macsha1", StringType),
        StructField("idfasha1", StringType),
        StructField("openudidsha1", StringType),
        StructField("androididsha1", StringType),
        StructField("uuidunknow", StringType),
        StructField("userid", StringType),
        StructField("iptype", IntegerType),
        StructField("initbidprice", DoubleType),
        StructField("adpayment", DoubleType),
        StructField("agentrate", DoubleType),
        StructField("lomarkrate", DoubleType),
        StructField("adxrate", DoubleType),
        StructField("title", StringType),
        StructField("keywords", StringType),
        StructField("tagid", StringType),
        StructField("callbackdate", StringType),
        StructField("channelid", StringType),
        StructField("mediatype", IntegerType)
      )
    )

    sqlContext.setConf("spark.sql.parquet.compression.codec", "snappy")
    val dataframe: DataFrame = sqlContext.createDataFrame(rowdata, schema)
    dataframe.registerTempTable("a")
    sqlContext.sql("select * from a").show()

    dataframe.write.parquet("result")

    sparkContext.stop()

  }


}

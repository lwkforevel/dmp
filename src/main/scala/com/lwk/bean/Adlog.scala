package com.lwk.bean

class Adlog(
         var   sessionid: String,
         var   advertisersid: Int,
         var   adorderid: Int,
         var   adcreativeid: Int,
         var   adplatformproviderid: Int,
         var   sdkversion: String,
         var   adplatformkey: String,
         var   putinmodeltype: Int,
         var   requestmode: Int,
         var   adprice: Double,
         var   adppprice: Double,
         var   requestdate: String,
         var   ip: String,
         var   appid: String,
         var   appname: String,
         var   uuid: String,
         var   device: String,
         var   client: Int,
         var   osversion: String,
         var   density: String,
         var   pw: Int,
         var   ph: Int,
         var   long: String,
         var   lat: String,
         var   provincename: String,
         var   cityname: String,
         var   ispid: Int,
         var   ispname: String,
         var   networkmannerid: Int,
         var   networkmannername: String,
         var   iseffective: Int,
         var   isbilling: Int,
         var   adspacetype: Int,
         var   adspacetypename: String,
         var   devicetype: Int,
         var   processnode: Int,
         var   apptype: Int,
         var   district: String,
         var   paymode: Int,
         var   isbid: Int,
         var   bidprice: Double,
         var   winprice: Double,
         var   iswin: Int,
         var   cur: String,
         var   rate: Double,
         var   cnywinprice: Double,
         var   imei: String,
         var   mac: String,
         var   idfa: String,
         var   openudid: String,
         var   androidid: String,
         var   rtbprovince: String,
         var   rtbcity: String,
         var   rtbdistrict: String,
         var   rtbstreet: String,
         var   storeurl: String,
         var   realip: String,
         var   isqualityapp: Int,
         var   bidfloor: Double,
         var   aw: Int,
         var   ah: Int,
         var   imeimd5: String,
         var   macmd5: String,
         var   idfamd5: String,
         var   openudidmd5: String,
         var   androididmd5: String,
         var   imeisha1: String,
         var   macsha1: String,
         var   idfasha1: String,
         var   openudidsha1: String,
         var   androididsha1: String,
         var   uuidunknow: String,
         var   userid: String,
         var   iptype: Int,
         var   initbidprice: Double,
         var   adpayment: Double,
         var   agentrate: Double,
         var   lomarkrate: Double,
         var   adxrate: Double,
         var   title: String,
         var   keywords: String,
         var   tagid: String,
         var   callbackdate: String,
         var   channelid: String,
         var   mediatype: Int

           ) extends Product with  Serializable {

  import com.lwk.tools.Implicits._


//  def apply(
//      arr:Array[String]
//           ): Adlog = new Adlog(sessionid, advertisersid, adorderid, adcreativeid, adplatformproviderid, sdkversion, adplatformkey, putinmodeltype, requestmode, adprice, adppprice, requestdate, ip, appid, appname, uuid, device, client, osversion, density, pw, ph, long, lat, provincename, cityname, ispid, ispname, networkmannerid, networkmannername, iseffective, isbilling, adspacetype, adspacetypename, devicetype, processnode, apptype, district, paymode, isbid, bidprice, winprice, iswin, cur, rate, cnywinprice, imei, mac, idfa, openudid, androidid, rtbprovince, rtbcity, rtbdistrict, rtbstreet, storeurl, realip, isqualityapp, bidfloor, aw, ah, imeimd5, macmd5, idfamd5, openudidmd5, androididmd5, imeisha1, macsha1, idfasha1, openudidsha1, androididsha1, uuidunknow, userid, iptype, initbidprice, adpayment, agentrate, lomarkrate, adxrate, title, keywords, tagid, callbackdate, channelid, mediatype)
//  {
//    sessionid =  arr(0)
//    advertisersid =  arr(1)  .toIntPlugs
//    adorderid =  arr(2)  .toIntPlugs
//    adcreativeid =  arr(3)  .toIntPlugs
//    adplatformproviderid =  arr(4)  .toIntPlugs
//    sdkversion =  arr(5)
//    adplatformkey =  arr(6)
//    putinmodeltype =  arr(7)  .toIntPlugs
//    requestmode =  arr(8)  .toIntPlugs
//    adprice =  arr(9)  .toDoublePlugs
//    adppprice =  arr(10) .toDoublePlugs
//    requestdate =  arr(11)
//    ip =  arr(12)
//    appid =  arr(13)
//    appname =  arr(14)
//    uuid =  arr(15)
//    device =  arr(16)
//    client =  arr(17) .toIntPlugs
//    osversion =  arr(18)
//    density =  arr(19)
//    pw =  arr(20) .toIntPlugs
//    ph =  arr(21) .toIntPlugs
//    long =  arr(22)
//    lat =  arr(23)
//    provincename =  arr(24)
//    cityname =  arr(25)
//    ispid =  arr(26) .toIntPlugs
//    ispname =  arr(27)
//    networkmannerid =  arr(28) .toIntPlugs
//    networkmannername =  arr(29)
//    iseffective =  arr(30) .toIntPlugs
//    isbilling =  arr(31) .toIntPlugs
//    adspacetype =  arr(32) .toIntPlugs
//    adspacetypename =  arr(33)
//    devicetype =  arr(34) .toIntPlugs
//    processnode =  arr(35) .toIntPlugs
//    apptype =  arr(36) .toIntPlugs
//    district =  arr(37)
//    paymode =  arr(38) .toIntPlugs
//    isbid =  arr(39) .toIntPlugs
//    bidprice =  arr(40) .toDoublePlugs
//    winprice =  arr(41) .toDoublePlugs
//    iswin =  arr(42) .toIntPlugs
//    cur =  arr(43)
//    rate =  arr(44) .toDoublePlugs
//    cnywinprice =  arr(45) .toDoublePlugs
//    imei =  arr(46)
//    mac =  arr(47)
//    idfa =  arr(48)
//    openudid =  arr(49)
//    androidid =  arr(50)
//    rtbprovince =  arr(51)
//    rtbcity =  arr(52)
//    rtbdistrict =  arr(53)
//    rtbstreet =  arr(54)
//    storeurl =  arr(55)
//    realip =  arr(56)
//    isqualityapp =  arr(57) .toIntPlugs
//    bidfloor =  arr(58) .toDoublePlugs
//    aw =  arr(59) .toIntPlugs
//    ah =  arr(60) .toIntPlugs
//    imeimd5 =  arr(61)
//    macmd5 =  arr(62)
//    idfamd5 =  arr(63)
//    openudidmd5 =  arr(64)
//    androididmd5 =  arr(65)
//    imeisha1 =  arr(66)
//    macsha1 =  arr(67)
//    idfasha1 =  arr(68)
//    openudidsha1 =  arr(69)
//    androididsha1 =  arr(70)
//    uuidunknow =  arr(71)
//    userid =  arr(72)
//    iptype =  arr(73) .toIntPlugs
//    initbidprice =  arr(74) .toDoublePlugs
//    adpayment =  arr(75) .toDoublePlugs
//    agentrate =  arr(76) .toDoublePlugs
//    lomarkrate =  arr(77) .toDoublePlugs
//    adxrate =  arr(78) .toDoublePlugs
//    title =  arr(79)
//    keywords =  arr(80)
//    tagid =  arr(81)
//    callbackdate =  arr(82)
//    channelid =  arr(83)
//    mediatype =  arr(84) .toIntPlugs
//
//
//  }

  override def productElement(n: Int): Any = n match {
    case 0 => sessionid
    case 1 => advertisersid
    case 2 => adorderid
    case 3 => adcreativeid
    case 4 => adplatformproviderid
    case 5 => sdkversion
    case 6 => adplatformkey
    case 7 => putinmodeltype
    case 8 => requestmode
    case 9 => adprice
    case 10 => adppprice
    case 11 => requestdate
    case 12 => ip
    case 13 => appid
    case 14 => appname
    case 15 => uuid
    case 16 => device
    case 17 => client
    case 18 => osversion
    case 19 => density
    case 20 => pw
    case 21 => ph
    case 22 => long
    case 23 => lat
    case 24 => provincename
    case 25 => cityname
    case 26 => ispid
    case 27 => ispname
    case 28 => networkmannerid
    case 29 => networkmannername
    case 30 => iseffective
    case 31 => isbilling
    case 32 => adspacetype
    case 33 => adspacetypename
    case 34 => devicetype
    case 35 => processnode
    case 36 => apptype
    case 37 => district
    case 38 => paymode
    case 39 => isbid
    case 40 => bidprice
    case 41 => winprice
    case 42 => iswin
    case 43 => cur
    case 44 => rate
    case 45 => cnywinprice
    case 46 => imei
    case 47 => mac
    case 48 => idfa
    case 49 => openudid
    case 50 => androidid
    case 51 => rtbprovince
    case 52 => rtbcity
    case 53 => rtbdistrict
    case 54 => rtbstreet
    case 55 => storeurl
    case 56 => realip
    case 57 => isqualityapp
    case 58 => bidfloor
    case 59 => aw
    case 60 => ah
    case 61 => imeimd5
    case 62 => macmd5
    case 63 => idfamd5
    case 64 => openudidmd5
    case 65 => androididmd5
    case 66 => imeisha1
    case 67 => macsha1
    case 68 => idfasha1
    case 69 => openudidsha1
    case 70 => androididsha1
    case 71 => uuidunknow
    case 72 => userid
    case 73 => iptype
    case 74 => initbidprice
    case 75 => adpayment
    case 76 => agentrate
    case 77 => lomarkrate
    case 78 => adxrate
    case 79 => title
    case 80 => keywords
    case 81 => tagid
    case 82 => callbackdate
    case 83 => channelid
    case 84 => mediatype

  }

  override def productArity: Int = 85

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Adlog]


  override def toString = s"Adlog(sessionid=$sessionid, advertisersid=$advertisersid, adorderid=$adorderid, adcreativeid=$adcreativeid, adplatformkey=$adplatformkey, putinmodeltype=$putinmodeltype, requestmode=$requestmode, adprice=$adprice, adppprice=$adppprice, requestdate=$requestdate)"
}

object  Adlog{
  import com.lwk.tools.Implicits._
  var   sessionid: String= _
  var   advertisersid: Int= _
  var   adorderid: Int= _
  var   adcreativeid: Int= _
  var   adplatformproviderid: Int= _
  var   sdkversion: String= _
  var   adplatformkey: String= _
  var   putinmodeltype: Int= _
  var   requestmode: Int= _
  var   adprice: Double= _
  var   adppprice: Double= _
  var   requestdate: String= _
  var   ip: String= _
  var   appid: String= _
  var   appname: String= _
  var   uuid: String= _
  var   device: String= _
  var   client: Int= _
  var   osversion: String= _
  var   density: String= _
  var   pw: Int= _
  var   ph: Int= _
  var   long: String= _
  var   lat: String= _
  var   provincename: String = _
  var   cityname: String= _
  var   ispid: Int= _
  var   ispname: String= _
  var   networkmannerid: Int= _
  var   networkmannername: String= _
  var   iseffective: Int= _
  var   isbilling: Int= _
  var   adspacetype: Int= _
  var   adspacetypename: String= _
  var   devicetype: Int= _
  var   processnode: Int= _
  var   apptype: Int= _
  var   district: String= _
  var   paymode: Int= _
  var   isbid: Int= _
  var   bidprice: Double= _
  var   winprice: Double= _
  var   iswin: Int= _
  var   cur: String= _
  var   rate: Double= _
  var   cnywinprice: Double= _
  var   imei: String= _
  var   mac: String= _
  var   idfa: String= _
  var   openudid: String= _
  var   androidid: String= _
  var   rtbprovince: String= _
  var   rtbcity: String= _
  var   rtbdistrict: String= _
  var   rtbstreet: String= _
  var   storeurl: String= _
  var   realip: String= _
  var   isqualityapp: Int= _
  var   bidfloor: Double= _
  var   aw: Int= _
  var   ah: Int= _
  var   imeimd5: String= _
  var   macmd5: String= _
  var   idfamd5: String= _
  var   openudidmd5: String= _
  var   androididmd5: String= _
  var   imeisha1: String= _
  var   macsha1: String= _
  var   idfasha1: String= _
  var   openudidsha1: String= _
  var   androididsha1: String= _
  var   uuidunknow: String= _
  var   userid: String= _
  var   iptype: Int= _
  var   initbidprice: Double= _
  var   adpayment: Double= _
  var   agentrate: Double= _
  var   lomarkrate: Double= _
  var   adxrate: Double= _
  var   title: String= _
  var   keywords: String= _
  var   tagid: String= _
  var   callbackdate: String= _
  var   channelid: String= _
  var   mediatype: Int = _


  def applyBean(arr:Array[String]) :Adlog =
  {
    val adlog: Adlog = new Adlog(
    arr(0),
    arr(0).toIntPlugs,
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
    adlog
  }
  
}
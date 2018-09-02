package com.lwk.tools

class Implicits(value:String)  {


     def toIntPlugs: Int ={
       try
       {
         val myval = value.toInt
         myval
       }
       catch{
         case e:Exception =>  {0}
       }
    }

  def toDoublePlugs: Double ={
    try
    {
      val myval = value.toDouble
      myval
    }
    catch{
      case e:Exception => {0}
    }
  }

  def toLongPlugs: Long ={
    try
    {
      val myval = value.toLong
      myval
    }
    catch{
      case e:Exception =>  {0}
    }
  }


}

object Implicits{

  implicit def stringToInt(value:String): Implicits ={
    new Implicits(value)
  }


}
package DriverCode

object Main {
  def main(args: Array[String]): Unit = {
      try {
        val spark = SparkCommon.SparkSessionCreator.SparkSessionCreate("Vaccine")
      } catch {
        case sparkException:org.apache.spark.SparkException => println("Something went wrong with the initialization of spark")
      }
  }
}

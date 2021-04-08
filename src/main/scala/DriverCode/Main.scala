package DriverCode

import org.slf4j.LoggerFactory

object Main {
  val logger = LoggerFactory.getLogger(getClass.getName)
  def main(args: Array[String]): Unit = {
      try {


        ETL.vaccineETL.ETL()

      } catch {
        case sparkException:org.apache.spark.SparkException => logger.warn("Something went wrong with the initialization of spark")
      }
  }
}

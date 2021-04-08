package ETL

import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{StringType, StructType}
import org.slf4j.LoggerFactory

object vaccineETL {
   val logger = LoggerFactory.getLogger(getClass.getName)
    def ETL():Unit = {

      logger.info("Getting the schema for " + getClass.getName)
      val vaccine_schmea = SchemaClasses.SchemaSet.generateSchema("src/main/resources/schema/vaccine_schema.json").get match {
        case t:StructType => t
      }
      logger.info("Schema Recieved")

      logger.info("Getting the spark session with the appName "+ getClass.getName )
      val spark =  SparkCommon.SparkSessionCreator.SparkSessionCreate(getClass.getName)
      logger.info("Spark Session Created")
      print(vaccine_schmea)
      logger.info("Creating Vaccine DataFrame")
      val vaccineDF = spark.read.format("csv").option("header","true").schema(vaccine_schmea.add(
        "_corrupt_record",StringType,true
      )).load("data/country_vaccinations.csv")
      // File not found needs to be handled.
      vaccineDF.filter(col("_corrupt_record").isNull).show(false)
      logger.info("saving data- needs the format to be specifiend in JSON config")
      logger.info("Need the partition columns to be specified in the config")
      logger.info("Need the save path to be configured")
      vaccineDF.write.format("csv").partitionBy("country").mode(SaveMode.Overwrite).save("testDirectoryLoad")
      logger.info("Saved")
    }
}

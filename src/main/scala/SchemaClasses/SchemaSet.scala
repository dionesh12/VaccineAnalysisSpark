package SchemaClasses

import org.apache.spark.sql.types.DataType
import org.slf4j.LoggerFactory

import scala.io.Source
object SchemaSet {
  val logger = LoggerFactory.getLogger(getClass.getName)
      def generateSchema(jsonFile:String):Option[DataType] = {
        logger.info("Schema Being Parsed")
        try {
          logger.info("Sending Schema")
          val schemaFile = Source.fromFile(jsonFile).getLines().mkString("")
          val structSchema = DataType.fromJson(schemaFile)
          Some(structSchema) // must be removed
        } catch {
         case fileNotFound:java.io.FileNotFoundException => {
            logger.error("File does not exist")
            System.exit(1)
            None

          }
         case wrongFormat:java.lang.IllegalArgumentException => {
           logger.error("JSON file format is incorrect")
           System.exit(1)
           None
         }
        }


      }

  }

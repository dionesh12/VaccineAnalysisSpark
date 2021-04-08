package SparkCommon
import org.apache.spark.sql.SparkSession
import org.slf4j.LoggerFactory

object SparkSessionCreator {
   val logger = LoggerFactory.getLogger(getClass.getName)
    def SparkSessionCreate(appName:String):SparkSession = {
      logger.info("Initiating a spark Session")
            return SparkSession.builder().master("local[*]").appName(appName).getOrCreate()
    }
}

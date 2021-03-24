package SparkCommon
import org.apache.spark.sql.SparkSession

object SparkSessionCreator {
    def SparkSessionCreate(appName:String):SparkSession = {
            return SparkSession.builder().master("local[*]").appName(appName).getOrCreate()
    }
}

package SchemaClasses

import org.slf4j.LoggerFactory

object SchemaSet {
  val logger = LoggerFactory.getLogger(getClass.getName)
      def VaccineSchema():String = {
        logger.info("Currently a string is being called ,need to replace with JSON Parser.")
        val schema =
          """
            country	STRING,
            iso_code	VARCHAR(3),
            date	DATE,
            total_vaccinations	LONG,
            people_vaccinated	  LONG,
            people_fully_vaccinated	LONG,
            daily_vaccinations_raw	LONG	,
            daily_vaccinations	LONG	,
            total_vaccinations_per_hundred	DOUBLE	,
            people_vaccinated_per_hundred	DOUBLE	,
            people_fully_vaccinated_per_hundred	DOUBLE	,
            daily_vaccinations_per_million	DOUBLE	,
            vaccines	STRING	,
            source_name	STRING	,
            source_website	STRING
            """
        logger.info("Sending Schema")
          schema
      }
}

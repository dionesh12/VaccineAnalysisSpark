name := "VaacineSparkAnalysis"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
   "org.apache.spark" %% "spark-core" % "2.4.5",
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "org.apache.spark" %% "spark-hive" % "2.4.5" % "compile",
  "org.apache.hadoop" % "hadoop-client" % "2.9.2",
)

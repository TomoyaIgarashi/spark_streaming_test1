name := "Simple Project"

version := "1.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-Xlint", "-deprecation", "-unchecked", "-feature", "-Xelide-below", "ALL")

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.0.0"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.3.0"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.0.0"

libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "3.0.3"


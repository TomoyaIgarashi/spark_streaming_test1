/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._

import sample.spark.Helper

object SimpleApp {
  def main(args: Array[String]) {

    Helper.configureTwitterCredentials()

    val checkpointDir = "./hdfs/checkpoint/"

    val sparkUrl = "local[4]"

    val stream = new StreamingContext(sparkUrl, "Simple App", Seconds(1))

    val tweets= TwitterUtils.createStream(stream,None)
    tweets.print()

    val statuses = tweets.map(status => status.getText())
    statuses.print()

    val words = statuses.flatMap(status => status.split(" "))
    val hashtags = words.filter(word => word.startsWith("#"))
    hashtags.print()

    val counts = hashtags.map(tag => (tag, 1))
    .reduceByKeyAndWindow(_ + _, _ - _, Seconds(60 * 5), Seconds(1))

    val sortedCounts = counts.map { case(tag, count) => (count, tag) }
    .transform(rdd => rdd.sortByKey(false))
    sortedCounts.foreach(rdd =>
      println("\nTop 10 hashtags:\n" + rdd.take(10).mkString("\n")))

    stream.checkpoint(checkpointDir)

    stream.start()

    println("+++++++++++++++++++++++++++++");

    stream.awaitTermination()
  }
}


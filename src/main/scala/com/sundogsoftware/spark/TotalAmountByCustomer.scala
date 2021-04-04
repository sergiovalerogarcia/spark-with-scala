package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.log4j._

/** Count up how many of each word appears in a book as simply as possible. */
object TotalAmountByCustomer {
  def parseLine(line: String): (Int, Float) = {
      val fields = line.split(",")
      val userId = fields(0).toInt
      val amount = fields(2).toFloat
      // Create a tuple that is our result.
      (userId, amount)
  }
 
  /** Our main function where the action happens */
  def main(args: Array[String]) {
   
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    
     // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "WordCount")   
    
    // Read each line of my book into an RDD
    val lines = sc.textFile("data/customer-orders.csv")
    
    val rdd = lines.map(parseLine)
    
    val totalsCustomer = rdd.reduceByKey((x, y) => (x + y))

    val totalsCustomerSorted = totalsCustomer.map( x => (x._2, x._1) ).sortByKey()
  
    for (result <- totalsCustomerSorted) {
      val count = result._1
      val word = result._2
      println(s"$word: $count")
    }
    
  }
    
}


package com.sundogsoftware.spark

import org.apache.spark.sql._
import org.apache.log4j._

object SparkSQLDatasetFrindByAge {

  case class Person(id:Int, name:String, age:Int, friends:Int)

  /** Our main function where the action happens */
  def main(args: Array[String]) {
    
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // Use SparkSession interface
    val spark = SparkSession
      .builder
      .appName("SparkSQL")
      .master("local[*]")
      .getOrCreate()

    // Load each line of the source data into an Dataset
    import spark.implicits._
    val schemaPeople = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("data/fakefriends.csv")
      .as[Person]

    schemaPeople.printSchema()
    
    schemaPeople.createOrReplaceTempView("people")

    val friendsByAge = spark.sql("""
      SELECT 
        age,
        round(avg(friends), 2) as avg_friends
      FROM people
      GROUP BY age
      ORDER BY age
    """)
    
    val results = friendsByAge.show()
    spark.stop()
  }
}
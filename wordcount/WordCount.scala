package pers.yanxuanshaozhu.spark.wordcount

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    //Create a SparkConf object
    val conf: SparkConf = new SparkConf().setMaster("yarn").setAppName("wordcount")
    //Create a SparkContext object
    val sc: SparkContext = new SparkContext(conf)
    //Load outside files, create RDD, execute operators
    sc.textFile(args(0)).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).saveAsTextFile(args(1))
    sc.stop()
  }
}

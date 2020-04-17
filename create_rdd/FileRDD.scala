package pers.yanxuanshaozhu.spark.create_rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object FileRDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc: SparkContext = new SparkContext(conf)
    //From local file system
    val rdd: RDD[String] = sc.textFile("D:\\MyWork\\Java\\bigData-191122\\spark191122\\src\\main\\scala\\pers\\yanxuanshaozhu\\spark\\create_rdd\\1.txt")
    rdd.collect().foreach(println)
    //From HDFS
    val rdd2: RDD[String] = sc.textFile("hdfs://hadoop102:9000/input")
    rdd2.collect().foreach(println)
    sc.stop()
  }
}

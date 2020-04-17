package pers.yanxuanshaozhu.spark.partition

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object FileRDDPartition {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDDPartition")
    val sc: SparkContext = new SparkContext(conf)
    val rdd: RDD[String] = sc.textFile("D:\\MyWork\\Java\\bigData-191122\\spark191122\\src\\main\\scala\\pers\\yanxuanshaozhu\\spark\\partition\\1.txt")
    rdd.saveAsTextFile("D:\\MyWork\\Java\\bigData-191122\\spark191122\\src\\main\\scala\\pers\\yanxuanshaozhu\\spark\\partition\\output")
    sc.stop()
  }
}

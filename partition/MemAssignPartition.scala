package pers.yanxuanshaozhu.spark.partition

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object MemAssignPartition {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("MemAssignPartition")
    val sc: SparkContext = new SparkContext(conf)
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),3)
    rdd.saveAsTextFile("D:\\MyWork\\Java\\bigData-191122\\spark191122\\src\\main\\scala\\pers\\yanxuanshaozhu\\spark\\partition\\output")
    sc.stop()
  }
}

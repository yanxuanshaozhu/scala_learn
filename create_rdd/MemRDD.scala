package pers.yanxuanshaozhu.spark.create_rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object MemRDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("MemRDD")
    val sc: SparkContext = new SparkContext(conf)
    val list: List[Int] = List(1, 2, 3, 4)
    val rdd: RDD[Int] = sc.parallelize(list)
    rdd.collect().foreach(print)
    sc.stop()
  }
}

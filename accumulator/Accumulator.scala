package pers.yanxuanshaozhu.spark.accumulator


import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.util.AccumulatorV2
import scala.collection.mutable

object Accumulator {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("MyAccumulator")
    val sc: SparkContext = new SparkContext(conf)

    val accumulator: MyAccumulator = new MyAccumulator
    sc.register(accumulator)

    val list: List[String] = List("Hello", "Hello", "Hello", "Hello", "Hello", "Spark", "Spark")
    val rdd: RDD[String] = sc.makeRDD(list)

    rdd.foreach(word => accumulator.add(word))
    println(accumulator.value)

    sc.stop()
  }
}


class MyAccumulator extends AccumulatorV2[String, mutable.Map[String, Int]] {

  var map: mutable.Map[String, Int] = mutable.Map[String, Int]()

  override def isZero: Boolean = map.isEmpty

  override def copy(): AccumulatorV2[String, mutable.Map[String, Int]] = {
    val newAccumulator: MyAccumulator = new MyAccumulator
    newAccumulator.map = this.map
    newAccumulator
  }

  override def reset(): Unit = map.clear()

  override def add(input: String): Unit = {
    if (input.startsWith("H")) {
      map(input) = map.getOrElse(input, 0) + 1
    }
  }

  override def merge(other: AccumulatorV2[String, mutable.Map[String, Int]]): Unit = {
    val map1 = map
    val map2 = other.value
    map = map1.foldLeft(map2) {
      (mm2, kv) => {
        var word = kv._1
        var count = kv._2
        mm2(word) = mm2.getOrElse(word, 0) + count
        mm2
      }
    }
  }

  override def value: mutable.Map[String, Int] = map
}
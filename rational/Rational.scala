package pers.yanxuanshaozhu.functional_objects.rational

object Rational {
  def main(args: Array[String]): Unit = {
    val r1 = new Rational(2, 9)
    val r2 = new Rational(3, 5)
    println(r1 + r2)
    println(r1 - r2)
    println(r1 * r2)
    println(r1 / r2)
    println(r1 + 1)

    implicit def int2rational(x: Int) = new Rational(x)

    println(99 + r1)
  }
}


 class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational = {
    new Rational(numer * that.denom + denom * that.numer, denom * that.denom)
  }

  def +(i: Int): Rational = {
    new Rational(numer + i * denom, denom)
  }

  def -(that: Rational): Rational = {
    new Rational(numer * that.denom - denom * that.numer, denom * that.denom)
  }

  def -(i: Int): Rational = {
    new Rational(numer - i * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(numer * that.numer, denom * that.denom)
  }

  def *(i: Int): Rational = {
    new Rational(numer * i, denom)
  }

  def /(that: Rational): Rational = {
    new Rational(numer * that.denom, denom * that.numer)
  }

  def /(i: Int): Rational = {
    new Rational(numer, denom * i)
  }

  override def toString: String = n + "/" + d

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
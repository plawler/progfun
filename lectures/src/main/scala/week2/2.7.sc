class Rational(x: Int, y: Int) {

  require (y != 0, "denominator must not be zero")

  def this(x: Int) = this(x, 1)

  private val g = gcd(x, y)

  def numer = x
  def denom = y

  def + (that: Rational) = {
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)
  }

  def - (that: Rational) = this + -that

  def multiply(that: Rational) = {
    new Rational(numer * that.numer, denom * that.denom)
  }

  def unary_- = new Rational(-numer, denom) // used to be "neg"

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = numer / g + "/" + denom / g

}

new Rational(1,2).numer
new Rational(1,2) < new Rational(2, 3)

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
val sub = x - y - z
x < y
x max y
y + y

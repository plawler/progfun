class Rational(x: Int, y: Int) {
  require (y != 0, "denominator must not be zero")

  def this(x: Int) = this(x, 1)

  private val g = gcd(x, y)

  def numer = x
  def denom = y

  def add(that: Rational) = {
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)
  }

  def subtract(that: Rational) = add(that.neg)

  def multiply(that: Rational) = {
    new Rational(numer * that.numer, denom * that.denom)
  }

  def neg = new Rational(-numer, denom)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = numer / g + "/" + denom / g
}
val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
val sub = x.subtract(y).subtract(z)
y.add(y)
x.less(y)
x.max(y)
new Rational(2)
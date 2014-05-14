class Rational(x: Int, y: Int) {
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

    override def toString = numer + "/" + denom
}

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
val sub = x.subtract(y).subtract(z)


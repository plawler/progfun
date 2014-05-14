def sqrt(x: Double): Double = {

  def isGoodEnough(guess: Double): Boolean =
    Math.abs(guess * guess - x) / x < 0.001

  def improve(guess: Double): Double =
    (guess + x / guess) / 2

  def sqrtIter(guess: Double): Double = {
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))
  }

  sqrtIter(1.0)

}

sqrt(2)
sqrt(4)
sqrt(9)
sqrt(64)
sqrt(1e-6)
sqrt(1e60)
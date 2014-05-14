def sqrt(x: Double): Double = sqrtIter(1.0, x)

def isGoodEnough(guess: Double, x: Double): Boolean =
  Math.abs(guess * guess - x) / x < 0.001

def improve(guess: Double, x: Double): Double =
  (guess + x / guess) / 2

def sqrtIter(guess: Double, x: Double): Double = {
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)
}
sqrt(2)
sqrt(4)
sqrt(9)
sqrt(64)
sqrt(1e-6)
sqrt(1e60)

println(1e60)

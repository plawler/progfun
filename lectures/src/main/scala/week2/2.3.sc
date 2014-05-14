val tolerance = 0.0001

def isCloseEnough(x: Double, y: Double): Boolean = math.abs((x - y) / x) / x < tolerance

def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
//    println("guess = " + guess)
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

fixedPoint(x => 1 + x/2)(1)

def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)

sqrt(2)

def averageDamp(f: Double => Double)(x: Double) =
  (x + f(x)) / 2

// sqrt written with generalized stabilizing function averageDamp
def sqrtFunc(x: Double) = fixedPoint(averageDamp(y => x / y))(1)
sqrtFunc(2)


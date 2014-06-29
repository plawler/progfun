val xs = Array(1, 2, 3, 44)
xs map (x => x * 2)

val s = "Hello World"
s filter (c => c.isUpper)
s exists (c => c.isUpper)
s forall (c => c.isUpper)

val pairs = List(1,2,3) zip s
pairs.unzip

s flatMap (c => List('.', c))

val range = 1 to 10 by 2

xs.sum
xs.max

def isPrime(n: Int): Boolean = (2 until n).forall (x => n % x != 0)

isPrime(23)

val first = Vector(1d,2d,3d)
val second = Vector(1d,1d,1d)

first zip second

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum

scalarProduct(first, second)


val odds = Seq(1,3,5)
val evens = Seq(2,4,6)

val all = (odds zip evens).map((t) => List(t._1, t._2)).flatten
val all2 = (odds zip evens).flatMap((t) => List(t._1, t._2))







def isPrime(n: Int): Boolean = (2 until n).forall (x => n % x != 0)

val n = 7

(1 until n) map (i =>
  (1 until i) map (j => (i, j)))

// returns an indexedseq because ranges cannot contain pairs
// vector is a subtype of indexedseq

(1 until n) flatMap (i =>
  (1 until i) map (j => (i, j)))

(1 until n) flatMap (i =>
  (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))

// for expression
// for ( s ) yield e
// where 's' is some seq and e is an expression whose value
// is a result of an iteration

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
  (for ((x,y) <- xs zip ys) yield x * y).sum

scalarProduct(List(1,2,3), List(1,1,1))






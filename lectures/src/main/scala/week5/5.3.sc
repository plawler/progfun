import math.Ordering

def msort[T](xs: List[T])(implicit ordering: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys1) => ys1 // Nil syntactically instead of List()
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: ys1) =>
          if (ordering.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}
val nums = List(2, -4, 5, 7, 1)
msort(nums)
val fruits = List("apple", "pear", "orange", "banana")
msort(fruits)
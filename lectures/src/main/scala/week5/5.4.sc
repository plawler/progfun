def squareList(xs: List[Int]): List[Int] = xs map (x => x * x)

squareList(List(1,2,3))

def squareList2(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case y :: ys => y * y :: squareList2(ys)
}

squareList2(List(1, 2, 3))

val nums = List(2, -4, 5, 7, 1)
val fruits = List("apple", "pear", "orange", "banana")

nums filter (x => x > 0)
nums filterNot (x => x > 0)
nums partition (x => x > 0)
nums takeWhile (x => x > 0)
nums dropWhile (x => x > 0)
nums span (x => x > 0)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}

def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (list => (list.head, list.size))

pack(List("a", "a", "a", "b", "c", "c", "a"))

encode(List("a", "a", "a", "b", "c", "c", "a"))


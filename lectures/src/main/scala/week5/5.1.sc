def last[T](xs: List[T]): T = xs match {
  case List() => throw new Error("Empty list")
  case List(x) => x // list of a single element
  case y :: ys => last(ys) // equivalent to a non-empty list with y as head and ys as tail
}

// all elements in the list except for last
def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("Empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case z :: zs => z :: concat(zs, ys)
}

def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ++ List(y)
}

def remove[T](xs: List[T], n: Int): List[T] = xs match {
  case List() => xs
  case y :: ys =>
    if (n < 0 || n >= xs.length) xs
    else if (n == 0) ys
    else y :: remove(ys, n-1)
}

last(List(1,2,3))
init(List(1,2,3))

concat(List(1,2,3), List(4,5,6))

reverse(List(1,2,3))

remove(List(1, 2, 3, 4), 2)

/*** by the way the ":::" concatenates two lists ***/



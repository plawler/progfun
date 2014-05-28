// cons or "::" operator - x :: xs returns new list with the first element x followed by elements of xs

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys) // pattern matches list with head matching y and tail matching ys
}

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys)) // pattern matches list with head matching y and tail matching ys
}

isort(List(3, 7, 2, 9))

List(3, 7, 2, 9).sortWith((x, y) => x < y) // ascending
List(3, 7, 2, 9).sortWith(_ > _) // descending...sick, yo!
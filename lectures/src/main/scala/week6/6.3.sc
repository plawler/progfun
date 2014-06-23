

def safe(col: Int, queens: List[Int]): Boolean = {
//  println(s"col: ${col}   queens: ${queens}")
  val row = queens.length
  val queensWithRow = (row - 1 to 0 by -1) zip queens
  queensWithRow forall {
    case (r, c) => col != c && math.abs(col - c) != row - r
  }
}

def queens(n: Int): Set[List[Int]] = {
  def place(k: Int): Set[List[Int]] = {
    if (k == 0) Set(List())
    else
      for {
        q <- place(k - 1)
        col <- 0 until n
        if safe(col, q)
      } yield col :: q
  }
  place(n)
}

def show(queens: List[Int]) = {
  val lines =
    for (col <- queens.reverse)
    yield Vector.fill(queens.length)("* ").updated(col, "x ").mkString
    "\n" + (lines mkString "\n")
}

(queens(4) map show) mkString "\n"


//for (n <- Seq(1,2,3,4)) yield List.fill(4)(n) mkString "|" //+ (lines mkString "\n")
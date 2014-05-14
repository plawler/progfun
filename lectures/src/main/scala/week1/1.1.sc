val x = square(4)

def square(x: Int): Int = x * x

for (row <- 0 to 4) {
  val r = row + 1
  for (col <- 0 to row) {
    print(pascal(col, r) + " ")
  }
  println()
}

def pascal(column: Int, row: Int): Int = {
  def pascal(column: Int, row: Int, value: Int) = {
    if (column > 0) value * (row - column) / column
    else 1
  }
  pascal(column, row, 1)
}
package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1) // todo: step through solution
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = { // remember recursion acts like a stack
    def balance(chars: List[Char], stack: String): Boolean = { // functional languages can have functions EVERYWHERE!
      if (chars.isEmpty) stack.isEmpty // this is our base case as well as our evaluation of the list (which will eventually terminate the recursion)
      else if (chars.head == '(') balance(chars.tail, chars.head + stack)
      else if (chars.head == ')') !stack.isEmpty && balance(chars.tail, stack.tail) // the second we hit more ) than ( we know it's unbalanced thus the empty stack tail exception
      else balance(chars.tail, stack) // continue because we have other characters in the list
    }
    balance(chars, "")
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1 // we've worked our way all the way down with a specific coin
    else if (coins.isEmpty || money < 0) 0 // will go negative ad infinitum if no < check
    else {
      val firstCoin = countChange(money - coins.head, coins)
      val otherCoin = countChange(money, coins.tail)
      firstCoin + otherCoin
    }
  }
}

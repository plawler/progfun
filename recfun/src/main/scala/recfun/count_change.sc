countChange(2, List(1,2))

def countChange(money: Int, coins: List[Int]): Int = {
  if (money == 0) 1 // not sure why this
  else if (coins.isEmpty || money < 0) 0
  else {
    print(s"money: $money, coin: ${coins.head} ")
    println()
    val firstCoin = countChange(money - coins.head, coins)
    val otherCoin = countChange(money, coins.tail)
    println(s"first: $firstCoin, other: $otherCoin")
    firstCoin + otherCoin
  }
}
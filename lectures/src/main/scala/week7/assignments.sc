case class Assignment(week: Int, total: Double, score: Double)

val scores = List(
  Assignment(1, 10, 10),
  Assignment(2, 10, 10),
  Assignment(3, 10, 10),
  Assignment(4, 20, 16.13),
  Assignment(6, 10, 0),
  Assignment(7, 20, 20))

def getGrade(scores: List[Assignment]): Double = {
  scores.map(a => a.score).sum / scores.map(a => a.total).sum
}

getGrade(scores)





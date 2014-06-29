case class Book(title: String, authors: List[String])

val books: Set[Book] = Set(
  Book(title = "Othello", authors = List("Shakespeare, William")),
  Book(title = "Effective Java", List("Bloch, Josh")),
  Book(title = "Java Puzzlers", List("Bloch, Josh", "Gafter, Neal")),
  Book(title = "Programming in Scala", List("Odersky, Martin", "Venners, Bill")),
  Book(title = "Effective Java 2", List("Bloch, Josh"))
)

for {
  b <- books
  a <- b.authors if a startsWith "Bloch,"
} yield b.title

for (b <- books if b.title.indexOf("Program") >= 0) yield b.title

for {
  b1 <- books
  b2 <- books
  if b1.title < b2.title
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1
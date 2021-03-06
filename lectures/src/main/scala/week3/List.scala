package week3

/**
 * Created By: paullawler
 */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

// head/tail example
class Cons[T](val head: T, val tail: List[T]) extends List[T] { // field definitions using val are actually methods and thus provide default impl
  def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def tail: Nothing = throw new NoSuchElementException("Nil tail")
  def head: Nothing = throw new NoSuchElementException("Nil head")
}


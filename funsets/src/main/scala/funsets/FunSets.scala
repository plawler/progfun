package funsets

import common._

/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = x => elem == x // this enables all the other functions below, i.e. this is our "Set" implementation

  /**
   * Returns the set of even integers
   */
  def evens: Set = x => x % 2 == 0 // use this for testing

  def courseraSet: Set = x => Set(1,3,4,5,7,1000).contains(x)

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = x => contains(s, x) || contains(t, x)

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = x => contains(s, x) && contains(t, x)

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = x => contains(s, x) && !contains(t, x) // todo: unit test

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = x => contains(s, x) && p(x) // todo: understand and unit test

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether ALL bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true // stops the iteration and confirms that we have visited all elements and that forall holds true
      else if (contains(s, a) && !p(a)) false // if element in set AND does not hold for p, return false and that's it, all done
      else iter(a + 1)
    }
    iter(-bound) // -bound ?
  }

  /**
   * Returns whether there exists at least one bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))
  // since forall must hold for ALL elements and it returns false if just element does not hold...
  // we negate that logic by passing !p which will return false which we must negate again to indicate that the one element held true

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = x => exists(s, y => f(y) == x)

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}

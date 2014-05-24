//abstract class Boolean {
//  def ifThenElse[T](t: => Boolean, e: Boolean): T
//  def < (x: => Boolean): Boolean = ifThenElse(false, x)
//}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this) // because a successor is always going to be new Succ(predecessor) which is new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {

  override def isZero: Boolean = true

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = throw new Error("Can't go negative")

  override def predecessor: Nat = throw new Error("Can't go negative")

}

class Succ(n: Nat) extends Nat { // n is the predecessor of Succ, that's why i got confused
  override def isZero: Boolean = false

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat =
    if (that.isZero) this else n - that.predecessor

  override def predecessor: Nat = n // n is the predecessor!
}

new Succ(new Succ(Zero)).predecessor


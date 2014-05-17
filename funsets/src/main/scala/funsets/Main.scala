package funsets

import FunSets._

object Main extends App {

//  println(contains(singletonSet(1), 1))
//  println(contains(singletonSet(1), 2))
//
//  val f = (x: Int) => x % 2 == 0 // see the...
//  def f2: (Int) => Boolean = x => x % 2 == 0 // ...difference?
//
//  println(forall(singletonSet(4), f))
//  println(forall(singletonSet(-44), f2))
//
//  println(exists(singletonSet(3), x => x % 2 != 0))

//  exists(singletonSet(4), x => x % 2 != 0)
  val mapper = map(evens, x => x * 1)
  println(mapper(4))
//  println(mapper(6))
//  println(mapper(8))

}

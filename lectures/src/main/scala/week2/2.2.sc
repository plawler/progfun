/**************************************************/
def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sumF(a + 1, b)
  }
  sumF
}
/*
  sum now is a function that...
    accepts a function that...
      accepts an Int and returns an Int
    returns a function that...
      accepts two Int params and returns an Int
 */
def cube: (Int) => Int = x => x * x * x
/*
  cube is a function that...
    returns a function that...
      accepts an Int and returns an Int
 */
// the product of each int along the interval from 0-3
sum(cube)(0,3) // holy shit!

/**************************************************/
// equivalent to sum, but removes the need for the inner function
def sumSugar(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sumSugar(f)(a + 1, b) // this fucking line is equivalent to sumF above
sumSugar(cube)(0,3)
/**************************************************/
def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a + 1, b)
// just do the product of each int along the interval from 1-4
product(x => x)(1,5)
// odersky's test
product(x => x * x)(3,4)
/**************************************************/
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, z: Int)(a: Int, b: Int): Int = {
  if (a > b) z
  else combine(f(a), mapReduce(f, combine, z)(a + 1, b))
}
def productMR(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x,y) => x * y, 1)(a, b)
productMR(x => x * x)(3,4)
// factorial with our product function
def fact(n: Int):Int = productMR(x => x)(1, n)
fact(5)


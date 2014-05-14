def sum(f: Int => Int, a: Int, b: Int): Int = {
  if (a > b) 0 else f(a) + sum(f, a + 1, b)
}

def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)

//def sumInts(a: Int, b: Int) = sum(id, a, b)
//def sumCubes(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(fact, a, b)

// time for anonymous functions
def sumInts(a: Int, b: Int) = sum(x => x, a, b)
def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
// type can be inferred

// alternate signature - tailRecSum(f: Int => Int)(a: Int, b: Int): Int = ???
def tailRecSum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, accum: Int): Int = {
    if (a > b) accum
    else loop(a + 1, f(a) + accum)
  }
  loop(a, 0)
}

tailRecSum(x => x, 0, 3)


type Set = Int => Boolean

def singletonSet(element: Int): Set = {
  x => element == x
}

def contains(set: Set, element: Int): Boolean = set(element)

singletonSet(3)
contains(singletonSet(3), 3)

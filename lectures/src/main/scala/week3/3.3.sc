import week3._

def nth[T](elem: Int, theList: List[T]): T = {
  def select(theRest: List[T], acc: Int): T = {
    if (theRest.isEmpty) throw new IndexOutOfBoundsException
    else if (acc == elem) theRest.head
    else select(theRest.tail, acc + 1)
  }
  select(theList, 0)
}

def betterNth[T](index: Int, aList: List[T]): T =
  if (aList.isEmpty) throw new IndexOutOfBoundsException
  else if (index == 0) aList.head
  else betterNth(index - 1, aList.tail)

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

nth(1, list)
betterNth(1, list)
betterNth(4, list)

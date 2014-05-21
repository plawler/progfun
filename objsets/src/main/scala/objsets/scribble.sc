import objsets._

//val set1 = new Empty
//val set2 = set1.incl(new Tweet("a", "tweet from a", 20))
//val set3 = set2.incl(new Tweet("b", "tweet from b", 20))
//set3.toString

val x = new NonEmpty(new Tweet("b", "b", 0), new Empty, new Empty)
x.elem
val y = x.incl(new Tweet("f", "f", 0))
y.asInstanceOf[NonEmpty].elem
val z = y.incl(new Tweet("d", "d", 0))
z.asInstanceOf[NonEmpty].elem
val xx = z.incl(new Tweet("a", "a", 0))
//val c = new Tweet("c", "c body", 7)
//val d = new Tweet("d", "d body", 9)

trait Expr {

}

case class Num(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

def show(e: Expr): String = e match {
    case Num(n) => n.toString
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
  }

show(Sum(Num(1), Num(44)))

def loop: Boolean = loop

def and(x: Boolean, y: => Boolean) = if (x) y else false

and(true, true)
and(true, false)
and(false, true)
and(false, loop)

def or(x: Boolean, y: Boolean) = if (x) x else y

or(true, true)
or(true, false)
or(false, true)


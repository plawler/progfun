val note = "Cookies or the kid gets it"
val mag = "This is the string with cookies in it for kids"
val mag2 = "Cookies or the kid gets it"

def canBuildRansom(note: String, mag: String): Boolean = {
  def remove(n: String, c: Char): String = {
    if (n.contains(c)) n.replaceFirst(c.toString, "") else n
  }
  if (note.isEmpty) true
  else if (note.size > mag.size) false
  else canBuildRansom(remove(note, mag.head), mag.tail)
}

canBuildRansom(note, mag)
canBuildRansom(note, mag2)
canBuildRansom("abcde", "a")
canBuildRansom("", "")
canBuildRansom("abcd", "zzzzzzzzzzzzzzzz")

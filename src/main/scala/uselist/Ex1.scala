package uselist

object Ex1 {
  def showAll(l: List[String]): Unit = l match {
    case List() => ()
//    case List(h) => println(h)
    case h :: t => println(h); showAll(t)
  }

  def main(args: Array[String]): Unit = {
    val l: List[String] = List("Fred", "Jim", "Sheila", "Albert", "William")
    val l2 = "Oscar" :: l

    println(s"List l is $l")
    println(s"List l2 is $l2")

    println(s"Head of list l is ${l.head}")
    println(s"tail of list l is ${l.tail}")

    showAll(l2)

    l2.foreach(x => println(s"> $x"))

//    l2.map(x => x.toUpperCase()).foreach(println(_))
    l2.map(x => x.toUpperCase()).foreach(println)

    l2.filter(x => x.length > 5).foreach(x => println(s">> $x"))
  }
}

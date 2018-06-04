package typesetc

object Ex1 {
  val x = "oops!"
  def main(args: Array[String]): Unit = {
    var x : Double = math.Pi
    val txt = s"The value of x is ${Ex1.x}"
    val other = f"The value of pi is ${x}%9.3f"
    println(txt)
    val longerTxt = txt + " more comments..."
    println(other)

//    val names = Array.apply("Fred", "Jim", "Sheila")
    val names = Array("Fred", "Jim", "Sheila")
    println(s"First name is ${names(0)}")
    names(0) = "Frederick"
    println(s"First name is now ${names(0)}")

    names.update(0, "Mr. Frederick")
    println(s"First name is now ${names.apply(0)}")

    val days = new Array[Int](5)
    println(s"day sub zero is ${days(0)}")
    println(s"day sub four is ${days(4)}")
    println(s"days is an array of size ${days.length}")
//    println(s"day sub five is ${days(5)}")

    val a = 3
    val b = 4
    val c = a.+(b)
    println(s"value of c is $c")
  }
}

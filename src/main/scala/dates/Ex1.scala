package dates

object Ex1 {
  object DayNames extends Enumeration {
    val SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY = Value
  }
  //  def dayName(d: Int): String =
  //    if (d == 0) "Saturday"
  //    else if (d == 1) "Sunday"
  //    else if (d == 2) "Monday"
  //    else "oops!"

//  def dayName(d: Int): String =
//    d match {
//      case 0 => "Saturday"
//      case 1 => "Sunday"
//      case 2 => "Monday"
//      case _ => "oops!"
//    }

  def dayName(d: Int): String =
    DayNames(d).toString

  def dayOfWeek(day: Int, month: Int, year: Int): Int = {
    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 * (m + 1) / 5) + y + (y / 4) - (y / 100) + (y / 400)) % 7
  }

  def add(a: Int, b: Int): Int = {
    a + b
    //    if (a < b) a - b
    //    else a + b
  }

  def main(args: Array[String]): Unit = {
    val aTuple = (3, "Hello", 2.2)
    println(s"aTuple, item 0 is ${aTuple._1}")
    val (three, greeting, _) = aTuple

    val sum = add(3, 4)
    //    val sum = 3 + 4
    println(s"sum is $sum")
    println(s"Jan 1 2000 is a ${dayName(dayOfWeek(1, 1, 2000))}")
    println(s"Jan 1 1900 is a ${dayName(dayOfWeek(1, 1, 1900))}")
  }
}

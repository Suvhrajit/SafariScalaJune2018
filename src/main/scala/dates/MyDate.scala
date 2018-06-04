package dates

object MyDate {
  var timesUsed: Int = 0;

  def apply(d: Int, m: Int, y: Int): MyDate = {
    println("invocation of MyDate.apply...")
    new MyDate(d, m, y)
  }

  def dayName(d: Int): String = {
    timesUsed += 1
    d match {
      case 0 => "Saturday"
      case 1 => "Sunday"
      case 2 => "Monday"
      case 3 => "Tuesday"
      case 4 => "Wednesday"
      case 5 => "Thursday"
      case 6 => "Friday"
      case _ => throw new IllegalArgumentException("Bad day of week number!")
    }
  }

  def dayOfWeek(day: Int, month: Int, year: Int): Int = {
    timesUsed += 1
    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 * (m + 1) / 5) + y + (y / 4) - (y / 100) + (y / 400)) % 7
  }
}

class MyDate private(d: Int, m: Int, y: Int) {

  import MyDate._

  val day: Int = d
  val month: Int = m
  val year: Int = y
  println(s"I'm in the body of my class... this *is* the constructor")

  def dayName: String = dates.MyDate.dayName(dayOfWeek(day, month, year))

  def tomorrow: MyDate = new MyDate(day + 1, month, year)

  override def toString: String =
    s"MyDate of ${dayName(dayOfWeek(day, month, year))} day: $day month: $month year: $year"
}

object TryMyDate {
  def main(args: Array[String]): Unit = {
    val d = MyDate(4, 6, 2018)
    //    d.day = 7
    println(s"my date's day is ${d.day}")
    println(s"day is ${d}")

    val d1 = MyDate(5, 6, 2018)
    val d2 = MyDate(1, 1, 2000)

    println(s"Today is $d")
    println(s"Tomorrow is $d1")
    println(s"Beginning of 2000 is $d2")

    println(s"${d.dayName}")

    println(s"tomorrow tomorrow is ${d1.tomorrow}")
  }
}


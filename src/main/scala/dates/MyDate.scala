package dates

import scala.annotation.tailrec

object MyDate {
  var timesUsed: Int = 0;

  def apply(d: Int, m: Int, y: Int): MyDate = {
    println("invocation of MyDate.apply...")
    if (d < 1 || d > 31 || m < 1 || m > 12)
      throw new IllegalArgumentException("Bad date!");
    new MyDate(d, m, y)
  }

  def isLeap(y: Int): Boolean =
    y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)

  def daysInMonth(m: Int, y: Int): Int =
    if (m == 9 || m == 4 || m == 6 || m == 11) 30
    else if (m == 2) { if (isLeap(y)) 29 else 28 }
    else 31

  def nameOfDay(d: Int): String = {
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

//class MyDate private(d: Int, m: Int, y: Int) {
//
//  import MyDate._
//
//  private val day: Int = d
//  val month: Int = m
//  val year: Int = y
class MyDate private(val day: Int, private val month: Int, private val year: Int) {
  import MyDate._
  println(s"I'm in the body of my class... this *is* the constructor")

  def dayName: String = nameOfDay(dayOfWeek(day, month, year))
  def tomorrow: MyDate = addDays(1)

  def this(d: Int, m: Int) = {
    this(d, m, 2018)
    println("in auxiliary constructor")
  }

  @tailrec final def addDays(n: Int): MyDate =
    if (n + day < daysInMonth(month, year)) new MyDate(n + day, month, year)
    else {
      val m = month + 1 // what if we wrap to month 13...
      val daysLeft = n - (daysInMonth(month, year) - day)
      (new MyDate(1, m, year)).addDays(daysLeft)
    }

  override def toString: String =
    s"MyDate of ${nameOfDay(dayOfWeek(day, month, year))} day: $day month: $month year: $year"
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
    println(s"plus five days is ${d1.addDays(60)}")

    println(s"Using auxiliary constructor ${new MyDate(4, 6)}")
  }
}


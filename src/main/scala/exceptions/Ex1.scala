package exceptions

import java.sql.SQLException

object Ex1 {
  def main(args: Array[String]): Unit = {
    val names = Array("Fred", "Jim", "Sheila")
    try {
      if (math.random() > 0.5) {
        throw new SQLException("Bad DB lookup!")
      }
      val nameOne = names(1)
      println(s"nameOne is $nameOne")
      val nameFour = names(4)
      println(s"nameFour is $nameFour")
    } catch {
      case x: SQLException => println(s"SQL problem: ${x.getMessage}")
      case x: ArrayIndexOutOfBoundsException => println(s"An exception occurred, message: ${x.getMessage}")
    }
  }
}

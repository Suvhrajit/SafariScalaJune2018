package exceptions

import java.sql.SQLException

import scala.util.{Failure, Success, Try}

object Ex2 {

  def doubtful: Int = {
    val names = Array("Fred", "Jim", "Sheila")
    if (math.random() > 0.6) {
      throw new SQLException("Bad DB lookup!")
    }
    val nameOne = names(1)
    println(s"nameOne is $nameOne")
    if (math.random > 0.6) {
      val nameFour = names(4)
      println(s"nameFour is $nameFour")
      99
    } else 200
  }
//            Try<Integer>
  def better: Try[Int] = Try(doubtful)

  //               String[] or "Array<String>"
  def main(args: Array[String]): Unit = {
    better match {
      case Success(value) =>
        println(s"That worked, got a value $value")
      case Failure(problem) =>
        println(s"That broke, problem is ${problem.getMessage}")
    }
  }
}

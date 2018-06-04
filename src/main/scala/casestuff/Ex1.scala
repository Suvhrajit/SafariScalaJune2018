package casestuff

abstract class Fruit
case class Banana(length: Int) extends Fruit
case class Pear(color: String) extends Fruit

object Ex1 {
  def main(args: Array[String]): Unit = {
    val f: Fruit = if (math.random() > 0.5) Banana(7) else Pear("green")
    f match {
      case Banana(len) => println(s"This is a $len inch long banana")
      case Pear(col) => println(s"This is a $col pear")
      case _ => println("What's this???")
    }
  }
}

package lectures.part1basics

import scala.annotation.tailrec

object DefaultParameters extends App {

  /**
    * This simple function prints the name and age of your preferred
    * hero.
    *
    * The parameter applies a default value only if no value is passed in
    * the call
    *
    * @param name
    * @param age
    */
  def greet(name: String = "batman", age: Int = 20): Unit=
    println(s"My name is $name and I'm $age years old")

  greet("Superman",40)

  greet(age=40) //named call otherwise you can call the function using only the age value

  greet("Captain America")

  greet(name="Ironman") //just the name

  greet(age=30, name="Antman") // in any order you prefer

  /**
    * Revisited fibonacci function so that now uses the default values
    * in place of recursive function inside
    *
    * @param n - is the number for which you want to calculate the fibonacci
    * @param last - f(n-1) calculated value
    * @param previous - f(n-2) calculated value
    * @return
    */
  @tailrec
  def fib(n: Int, last: BigInt = 1, previous: BigInt = 1): BigInt = {
      if (n <= 2) last
      else fib(n - 1, last + previous, last)
  }

  println(s"Fibonacci ${fib(100)}")

}

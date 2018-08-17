package lectures.part3FP

import scala.annotation.tailrec

object HOFsCurries extends App {

  // example of complex function
  val superfunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // F(f(x,g(y,e(z))),k)

  // Mathematically speaking a function is a relationship b/w two domains called domain and codomain so that
  // applies to each element of the domain one and only one element of the codomain.
  // high oder functions are composed function, function of functions like g(f(x)) and so on.


  /**
    * Example of a simple function that takes as parameter another function.
    *
    * nTimes applies n times the function f to x
    *
    * @param f
    * @param n
    * @param x
    * @return
    */
  @tailrec
  def nTimes(f:Int => Int, n: Int, x: Int): Int=
    if (n<=0) x
    else nTimes(f,n-1,f(x))

  /**
    * Anonymous function to send to nTimes as parameter
    *
    */
  val plusOne:Int=>Int= _ + 1

  println(s"Apply 3 times the function plusOne to x: ${nTimes(plusOne, 3, 1)}")

  /**
    * Rethought of nTimes function so that the function sent as parameter is applied
    * only when required.
    * The technique used to code the function nTimesBetter is called "Curried"
    *
    * The nTimesBetter should be further improved because it is not tailrec
    *
    * @param f
    * @param n
    * @return
    */
  def nTimesBetter(f:Int => Int, n:Int): (Int => Int) =
    if (n<=0) (x:Int) => x
    else (x:Int) => nTimesBetter(f,n-1) (f(x))

  // create a function that adds 10 to x but it is not applied to x yet
  val plus10 = nTimesBetter(plusOne,10)

  // now the function plus10 is applied
  println(s"Increment 3 by 10 ${plus10(3)}")

  /**
    * Simple function with multiple parameter list that basically take one paramenter (string)
    * and delegate the second param (double) to be implemented later by an outside function
    *
    * @param c - format to be applied to the second parameter
    * @param x - double to format in string
    * @return
    */
  def curriedFormatter(c:String)(x:Double): String = c.format(x)

  /**
    * Declare a function that returns in turn a function that given a double returns a formatted string
    * @return
    */
  def standardFormat: (Double => String)= curriedFormatter("%4.2f")

  def preciseFormat: (Double => String)= curriedFormatter("%10.6f")

  println(s"Standard formatter ${standardFormat(Math.PI)}")
  println(s"Standard formatter ${preciseFormat(Math.PI)}")



}

package lectures.part1basics

object CallByValueAndByName extends App {

  def callByValue(x: Long): Unit = {
    println("Called by value: "+ x)
    println("Called by value: "+ x)
  }

  /**
    * This function is called by name because uses the arrow
    * => before the type of the parameter.
    * The function System.nanoTime() is passed through x param
    * literally as is. So the entire expression is send to the
    * function and not only the value as the previous function
    *
    * x => System.nanoTime() is replaced in the two println
    * calls
    *
    * The expression is evaluate twice and in two different
    * times.
    *
    * The expression passed to the function is evaluated only
    * when used. By contrast, if it is not used, it is never
    * executed.
    *
    * @param x
    */
  def callByName(x: => Long): Unit ={
    println(s"Called by name: $x")
    println(s"Called by name: $x")
  }


  callByValue(System.nanoTime())

  callByName(System.nanoTime())
}

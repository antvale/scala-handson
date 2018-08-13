package lectures.part3FP

object FunctionalProgramming extends App{

  /**
    * In oop world to create a function you would implement a class declaring basically
    * a method that takes one or more generic types and returns a generic type.
    * This allows to implement function that will take one or more input parameter.
    *
    * In scala you can code in functional way through either implementing a trait with the
    * apply method or using the built-in functions scala comes with. Below the trait to
    * to implement function using the standard object oriented approach and calling the class
    * as a method (this is possible thanks to the apply method)
    *
    * @tparam A - input parameter
    * @tparam B - output parameter
    */
  trait MyFunction1[A, B] {
    def apply(element: A): B
  }

  /**
    * As above but taking 2 generic params
    * @tparam A
    * @tparam B
    * @tparam C
    */
  trait MyFunction2[A, B, C] {
    def apply(element1: A, element2: B): C
  }

  class PlusOne extends MyFunction1[Int,Int]{
    override def apply(element: Int): Int = element + 1
  }

  // Anonymous class implementing the trait declared above
  val doubler = new MyFunction1[Int, Int]{
    override def apply(element:Int):Int = element * 2
  }

  //Anonymous cass implementing the trait MyFunction2 declared below
  val concater= new MyFunction2[String, String, String]{
    override def apply(element1: String, element2: String): String = element1 + element2
  }

  println(s"Doubler: ${doubler(2)}")

  val helloWorld:String=concater("Hello ", "world!")

  println(s"Concater: ${helloWorld}")

  // SCALA FUNCTIONS OUT OF THE BOX

  /**
    * This is a way to create a function using the out of the box set of function
    * provided by scala.
    */
  val stringToIntConverter= new Function1[String,Int] {
    override def apply(p1: String): Int = p1.toInt
  }

  println("Converter string -> int: " + (stringToIntConverter("4") + 3))

  // ALL FUNCTIONS IN SCALA ARE OBJECTS

  val adder: ((Int,Int)=>Int) = new Function2[Int,Int,Int] {
    override def apply(x: Int, y: Int): Int = x + y
  }

  println("Adder: "+ adder(3,4))

  // HIGH ORDER FUNCTIONS, THAT'S, FUNCTION OF FUNCTIONS or FUNCTIONS THAT RETURN FUNCTION/S

  val f_f:(Int => Function1[Int,Int])=new Function[Int,Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int,Int] = new Function1[Int,Int]{
      override def apply(y: Int): Int = x + y
    }
  }

  val f=f_f(4)

  println(s"Function of functions ${f(2)}")

  // NEW ADDER VERSION WITH SYNTACTIC SUGAR CALLED ANONYMOUS FUNCTION OR LAMBDA
  // (param1: Type1, param2:Type2,...paramN:TypeN) => expression based on parameters

  val adder1 = (x: Int, y:Int) => x + y

  println(s"Adder1 with lambda: ${adder1(3,4)}")

  // ALTERNATIVE FORM

  val adder2:((Int,Int) => Int) = (x, y) => x + y

  println(s"Adder2 with lambda: ${adder2(3,4)}")


  //ALTERNATIVE FORM - SHORT SYNTACTIC SUGAR

  val adder3: (Int, Int) => Int = _ + _

  println(s"Adder3 with lambda: ${adder3(3,4)}")


  // LAMBDA VERSION OF f_f
  val f_f1 = (x:Int) => (y:Int) => x + y

  val g=f_f1(4)(2)

  println(s"Function of functions ${g}")

}


package lectures.part2oo

object SyntacticSugar extends App {


  /**
    * Simple class to show how to create simple syntatic sugar expression. Syntatic sugear is a way to create
    * language expressions to make things easier to read and use.
    *
    * One of common syntatic sugar is the operator overloading that's rewrite the behavior of common operators
    * or design a new one
    *
    * Prefix, infix and postfix notations are another examples
    *
    * @param name - Person name
    * @param movie - Favorite movie
    */
  class Person(val name: String, val age: Int = 0, movie: String){

    /**
      * Overloads the + operator
      * @param nickname
      * @return
      */
    def +(nickname: String): Person = new Person(s"$name $nickname",age,movie)

    /**
      * create a unary prefix operator only applicable to (+, -, !, ~)
      * @return
      */
    def unary_+()=new Person(name,age+1,movie)

    /**
      * Create an infix notation
      * @param topic
      * @return
      */
    def learns(topic: String): String = s"$name learns $topic"

    /**
      * Create a postfix notation
      * @return
      */
    def learnsScala:String = learns("Scala")

    /**
      * Special method that allows to call the object as method
      *
      * @param n
      * @return
      */
    def apply(n: Int): String = s"$name watched the $movie $n times"

  }

  val john=new Person("John", 20, "Il Padrino")

  val john_nickname= john + "the master"

  println(john_nickname.name)

  println((+john).age)

  println(john learns "Scala")

  println(john learnsScala)

  print(john(2))
}

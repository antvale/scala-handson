package lectures.part2oo

object ClassAndObject extends App {

  /**
    * This is a class having the same meaning of oo programming so you can have many instance of the same
    * class and instance each one through new statement.
    *
    * Scala does not have class-level functionality or static method. If you need to create an equivalent
    * behavior you need to use the object in Scala.
    *
    * Instance-level functionality
    *
    */
  class Person (val name:String){
    val hands=2
    val feet=2

    // static final int howManyFeet=2 in Scala it isn't possible to define this constant
  }

  /**
    * This is an object and it is a singleton that's a single instance exists all the time. For the object you
    * don't need to use the new operator being similar to the static final method in java indeed.
    *
    * Obviously the object can't have the constructor.
    *
    * Class-level functionality
    *
    */
  object Person{

    val N_HANDS=2
    val N_FEET=2

    def howManyHands: Int = N_HANDS

    /**
      * This is a factory method that is a convenient way to create many instances of the same class
      * @return
      */
    def from(mother:Person, father: Person): Person = new Person("Bobbie")

    def isAHumanBeing(person:Person): Boolean = person.feet==N_FEET && person.hands==N_HANDS
  }

  // The objects does not have the necessity to be created through new operator like happens for the classes
  println(s"A human being has ${Person.howManyHands} hands")
  println(s"A human being has ${Person.N_HANDS} hands")

  val john=new Person("John")

  val mary=new Person("Mary")

  val bobbie=Person.from(mary, john)

  println(s"A human being has ${john.hands} feet")
  println(s"A human being has ${mary.feet} feet")

  println(s"${bobbie.name} is son of ${john.name} and ${mary.name}")

  println(s"is Mary a human being? ${Person.isAHumanBeing(mary)}")

  // john is different from mary for sure being two different instances of the same class
  println(s"Are ${john.name} and ${mary.name} equal? ${john==mary}")

}

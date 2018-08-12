package lectures.part2oo

object Inheritance extends App{

  class Animal{

    val species:String ="mammal"

    protected def eat:String=s"Eats to live"

    def fly:Boolean=species=="winged"

    //def this()=this(species)

  }

  class Cat extends Animal{
    override def eat: String = s"Eats crispy crunches"
  }

  class Bird extends Animal{
    override val species: String = "winged"
  }

  val cat:Animal=new Cat

  val bird:Animal=new Bird

  println(s"does the cat fly? ${cat.fly}")
  println(s"does the bird fly? ${bird.fly}")

}

package lectures.part2oo

object Inheritance extends App{

  abstract class Animal{

    val species:String ="mammal"

    protected def eat:String=s"Eats to live"

    def fly:Boolean=species=="winged"

    def run: Unit

    //def this()=this(species)

  }

  trait Carnivorous {
    def eat(animal:Animal):Unit=println(s"It eats the ${animal.species}")
  }

  class Cat extends Animal with Carnivorous{
    override def eat: String = s"Cats eat crispy crunches"
    override def run:Unit=println(s"The cat runs less faster than a panther")

    override def eat(animal: Animal): Unit = println(s"Cat eat ${animal.species}")
  }

  class Bird extends Animal{
    override val species: String = "winged"
    override def run:Unit=println(s"A bird does not run but fly")
  }

  class Mouse extends Animal {
    override val species: String = "rodent"
    override def run: Unit = println(s"Mouse runs less faster than cat")
  }

  val cat=new Cat

  val bird:Animal=new Bird

  val mouse:Animal=new Mouse

  println(s"does the cat fly? ${cat.fly}")
  println(s"does the bird fly? ${bird.fly}")

  bird.run
  cat.run
  mouse.run
  cat eat mouse

}

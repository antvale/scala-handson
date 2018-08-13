package lectures.part2oo

object NovelHandler extends App {

  /**
    * Class representing an author of one or more novels
    *
    * If you need to invoke the constructor params also as fields than you have to prefix the params
    * with 'val' for immutable fields and 'var' for those you need change
    *
    * @param firstName
    * @param surname
    * @param year - Year of birth
    */
  class Writer(val firstName: String, val surname: String, val year: Int) {

    def fullName: String=s"$firstName $surname"

  }

  /**
    * Class representing the a novel written by an author
    *
    * @param name - Title of the novel
    * @param releaseYear - Year when the novel has been published
    * @param author - Author of the novel, assuming just one author
    */
  class Novel(val name: String, val releaseYear: Int, author: Writer) {

    /**
      * returns the age of the author when it wrote the novel
      *
      * @return age of the author
      */
    def authorAge: Int = releaseYear - author.year

    def isWrittenBy: String = author.fullName

    def isWrittenBy(author: Writer): Boolean = author == this.author

    //     def this(releaseYear: Int) = this(this.name,releaseYear,author)

    def copy(newReleaseYear: Int): Novel = new Novel(name,newReleaseYear,author)
  }

  /**
    * Simple class counter developed with immutability principle in mind. This implies that
    * the counter field is never changed indeed it is actually a val. Instead for each increment
    * or decrement a new Counter object is created.
    *
    * @param counter - counter that will be increased and decreased starting from default value
    */
  class Counter(val counter: Int = 0) {

    def currentCount(): Int = counter

    def inc: Counter = new Counter(counter+1)

    def dec: Counter = new Counter(counter-1)

    def inc(amount: Int) = new Counter(counter+amount)

    def dec(amount: Int): Counter = new Counter(counter-amount)

  }

  // create a writer
  val dickens=new Writer("Charles", "Dickens", 1812)

  val impostor=new Writer("Charles", "Dickenson", 1812)


  println(dickens.fullName)

  val oliverTwist=new Novel("Oliver Twist", 1838, dickens)

  println(s"The novel ${oliverTwist.name} has been written by ${oliverTwist.isWrittenBy} in ${oliverTwist.releaseYear}")

  println(s"The novel ${oliverTwist.name} has been written by ${impostor.fullName} ${oliverTwist.isWrittenBy(impostor)}")

  println(s"The writer ${dickens.fullName} wrote the novel ${oliverTwist.name} when he was ${oliverTwist.authorAge}")



  val oliverTwistNewEdition = oliverTwist.copy(1840)

  println(s"The novel ${oliverTwistNewEdition.name} has been rewritten by ${oliverTwistNewEdition.isWrittenBy} in ${oliverTwistNewEdition.releaseYear}")

  var counter = new Counter()

  println(s"Current count: ${counter.currentCount}")

  counter=counter.inc

  println(s"Increase count by 1: ${counter.currentCount}")

  counter=counter.dec

  println(s"Decrease count by 1: ${counter.currentCount}")

  counter=counter.inc(20)

  println(s"Increase count by 10: ${counter.currentCount}")

  counter=counter.dec(10)

  println(s"Increase count by 10: ${counter.currentCount}")




}

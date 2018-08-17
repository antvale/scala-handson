package exercises

/**
  * Abstract class to handle a list. The list is a immutable list so
  * a new list is created every time is required.
  */
abstract class MyList {

  /*

    head = return the first element of the list
    tail = remainder part of the list
    isEmpty = boolean to say whether the list is empty
    add(int) => return a new list with the new element added
    toString => return the string representation of the list

    1. define the signature for each one above methods
    2. implement each method

   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(elem:Int): MyList //immutable principle
  def printElems: String
  override def toString: String = "[" + printElems + "]"

}

/**
  * An object that implement the empty list.
  * If you want to implement it later use the ??? like
  * for example:  def head: Int = ???
  * This technique is useful when for example you need to
  * generate scaffolding code to be implemented later by
  * other developers
  *
  */
object Empty extends MyList {

  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(elem:Int): MyList = new Cons(elem, Empty)
  def printElems: String = "[]"
}

/**
  * A non empty list so contains at least an element
  * @param h - the head of the list (that's the latest added element)
  * @param t - the tail of the list
  */
class Cons(h:Int,t: MyList) extends MyList {

  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(elem:Int): MyList = new Cons(elem,this)

  /**
    * This is recursive method. To print an entire list you
    * should print the head of the remaining tail recursively
    * and terminate when the tail is empty.
    * f(n) => f(n is empty) = print head of the list
    * f(n) => f(n is not empty) = print head of the tail + f(n-1)
    * @return
    */
  def printElems: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElems
}

object TestList extends App{
  val list= new Cons(1,Empty)

  println(s"The head element of the list is: ${list.head}")

  val newList= new Cons(1,new Cons(2,new Cons(3,Empty)))

  println(s"The first element of the tail is: ${newList.tail.head}")

  val listWith2=list.add(2)

  val listWith3=listWith2.add(3)

  println(s"The head of the list is: ${listWith3.head}")

  println(s"Is the list empty? ${listWith3.isEmpty}")

  println(s"list of elements: ${newList}")

}



package exercises

/**
  * Abstract class to handle a list. The list is a immutable list so
  * a new list is created every time is required.
  *
  * The list is a generic list
  *
  */
abstract class MyList [+A]{

  /*

    head = return the first element of the list
    tail = remainder part of the list
    isEmpty = boolean to say whether the list is empty
    add(int) => return a new list with the new element added
    toString => return the string representation of the list

    1. define the signature for each one above methods
    2. implement each method

    Add the generic type to mylist to manage any kind of
    type.

    Add the map, filter and flapMap to mylist to apply
    specific behavior to the list

   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](elem:B): MyList[B] //immutable principle
  def printElems: String
  override def toString: String = "[" + printElems + "]"

  /**
    * map transforms list of type A to a list of type B applying
    * the specific transformer
    *
    * @param transform - transform function
    * @tparam B - the new list type
    * @return - a new list
    */
  def map[B](transform:MyTransformer[A,B]): MyList[B]

  //def flatMap[B](transform:MyTransformer[A,MyList[B]]): MyList[B]

  def filter(predicate:MyPredicate[A]): MyList[A]

}

trait MyPredicate[-T] {
  def test(elem:T): Boolean
}

trait MyTransformer[-A, B]{
  def transform(elem:A):B
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
object Empty extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](elem:B): MyList[B] = new Cons(elem, Empty)
  def printElems: String = "[]"

  def map[B](transform: MyTransformer[Nothing, B]): MyList[B] = Empty

  //override def flatMap[B](transform: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
}


/**
  * A non empty list so contains at least an element
  * @param h - the head of the list (that's the latest added element)
  * @param t - the tail of the list
  */
class Cons[+A](h:A,t: MyList[A]) extends MyList[A] {

  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: Nothing](elem:B): MyList[B] = new Cons(elem, Empty)

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h,t.filter(predicate))
    else t.filter(predicate)
  }

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

object TestList {
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



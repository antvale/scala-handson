package lectures.part1basics

import scala.annotation.tailrec


object Recursion extends App {

  /*
    When a thread invokes a method the JVM suspends the current work, creates and pushes a new stack frame in the
    thread stack that becomes the current frame. While the method is executed it uses the current frame to store
    parameters, local variables, intermediate computations and other data
    (see  https://www.artima.com/insidejvm/ed2/jvm8.html).
    When the method completes the JVM pops and discards the method stack frame and the frame of the previous method
    becomes the current frame and execution is resumed by this method and so on going back through the stack of calls.
    That is what happens in general when a method is called in Java. Now applying this model to
    factorial function you can easily image how the this function is calculated.
    Basically for every recursion the JVM suspends the current work, creates and pushed a new frame in the stack
    and invokes the function again until the terminating condition is reached out.
    So in the event of factorial of 100! the JVM invokes 99 times the factorial function and creates and pushes 99
    frames in the stack until n==1 when factorial(1) == 1. When this condition is verified the JVM will calculate
    every pending value going back through the stack of calls.
    Because the stack is upper limited when this exceeds the max size the JVM will throw a StackOverflow runtime
    exception. This is what actually happens if you try to calculate 5000!
   */
  def factorial(n:Int): Int = {
    if (n<=1) 1 //terminating condition, when verified the JVM pops the pending work from call stack and executes it
    else {
      println("To calculate the factorial of " + n + " firstly I need the factorial of " + (n-1)) //actually print
      val result=n * factorial(n-1)           //stop current work, push the current work in call stack and call the function
      println("Computed factorial for " + n)  //pending work, waiting the above function call ends
      result                                  //pending work, as above
    }
  }

  //println(factorial(5000)) // if n=5000 => java.lang.StackOverflowError

  /*
    A way to avoid to over flow the call stack is to use a sort of accumulator to partially calculate the
    factorial so that the same stack frame can be used instead of creating a new one on each call.
    Below recursive call 'factHelper(m-1, m * accumulator)' uses the same frame many times without having the
    necessity to create a new one regardless of how many times the function is invoked.
    The factHelper is called TAIL RECURSION and you can use the tail annotation to enforce this fact.
    The scala compile will check if actually the function is a tail recursive function.
   */
  def factorialWithAccumulator(n: Int): BigInt = {
    @tailrec
    def factHelper(m: Int, accumulator: BigInt): BigInt =
      if (m <= 1) accumulator //when the terminating condition is verified the accumulator is actually the factorial
      else factHelper(m-1, m * accumulator) //this instruction allows to reuse the same stack frame in Scala

    factHelper(n,1)
  }

  println(factorialWithAccumulator(10))

  /*
    As said, take care to create a dependency between a local variable and recursive function invocation otherwise the
    program will complain with too many stack frames allocated in memory. The best approach in writing the recursion is
    to put all the variables as parameters of the recursive method and accumulate the value in intermediate variable.
    Even though this will complicate a little bit the algorithm and the clarity of the code but as benefit does not
    break the program execution achieving better performance for big number of recursions.

    f(1)=f(2)=1
    f(n)=f(n-1)+f(n-2)
    => f(3)=f(2)+f(1)=2
    => f(4)=f(3)+f(2)=3
    => f(5)=f(4)+f(3)=5
    => f(6)=f(5)+f(4)=8
    => f(7)=f(6)+f(5)=13
    => f(8)=f(7)+f(6)=21
    ...

    fib(1,1,1) n = 1 => m = 1 => fib = 1
    fib(2,1,1) n = 2 => m = 2 => fib = 1
    fib(3,1,1) n = 3
      1) m = 3, last=1, prev=1
      2) m = 2, last=2, prev=1  => fib = 2
    fib(4,1,1) n=4
      1) m = 4, last=1, prev=1
      2) m = 3, last=2, prev=1
      3) m = 2, last=3, prev=2 => fib=3
    fib(5,1,1) n=5
      1) m = 5, last=1, prev=1
      2) m = 4, last=2, prev=1
      3) m = 3, last=3, prev=2
      49 m = 2, last=5, prev=3

   */
  def fibonacci(n: Int): BigInt ={
    def fibHelper(m: Int, last: BigInt, previous: BigInt): BigInt = {
      if (m <= 2) last
      else fibHelper(m - 1, last + previous, last)
    }
    fibHelper(n,1,1)
  }

  println(fibonacci(1))   // => 1
  println(fibonacci(2))   // => 1
  println(fibonacci(100)) // => 354224848179261915075 look at http://www.readme.it/libri/M/M00101.shtml
  println(fibonacci(1000))// => 43...8875

  // see how to write test unit in scala can useful to verify the assertions for the method
}

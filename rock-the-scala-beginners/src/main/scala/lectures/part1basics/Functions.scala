package lectures.part1basics

object Functions extends App {

  def aFunction(name: String,surname: String): String = {

    "My name is " + name + " " + surname
  }


  println(aFunction("John","Smith"))


  def aParameterlessFunction(): Int= 42

  println(aParameterlessFunction())

  println(aParameterlessFunction)


  def printAString(aString: String): Unit = println(aString)

  printAString("a string")

  // REPEAT aString N TIMES
  def aRecursiveFunction (aString:String, n: Int): String = {
    if (n==1) aString
    else aString + aRecursiveFunction(aString,n-1)
  }

  println(aRecursiveFunction("Hello ", 10))


  // Factorial function => n!=1 * 2 * 3 * ... * n => n!=n*(n-1)!
  // e.g. 3! = 1 * 2 * 3
  def factorial(n:Int): Int = {
    if (n<=1) 1 // terminating condition
    else n * factorial(n-1) //recursive call
  }

  println(factorial(10))


  // Fibonacci series is a sequence of numbers so that:
  // f(1)=f(2)=1
  // f(n) = f(n-1)+f(n-2)
  // In scala the recommended way to solve problems is through recursive programming model rather
  // than imperative programming. Although it is very important to take care of the fact that the
  // recursion typically demands a lot of memory capacity and processor activity. For example the
  // below function needs a lot of memory and cpu processing as soon as n becomes relatively high.
  // See the Recursion scala object to rewrite the function so that we don't complain with those
  // issues.

  def fibonacci(n:Int): Int={
    if (n<=2) 1 else
      fibonacci(n-1) + fibonacci(n-2)
  }

  println(fibonacci(10))


  /*
     Function to check if a number is prime
     A number is a prime number if it is greater than 1 and
     can be divided by 1 and itself only
   */
  def isPrime(n: Int): Boolean = {
    // inner function to find at least a number that n can be divided by
    // and that is != 1 && n
    def isPrimeUntil(t: Int): Boolean = {
      println(t)
      if (t<=1) true
      else n % t != 0 && isPrimeUntil(t-1) //the function exits if the first condition is false
    }
    isPrimeUntil(n/2)
  }

  println(isPrime(2))   // => 2 is prime
  println(isPrime(5))   // => 5 is prime
  println(isPrime(9))   // => 9 is not prime
  println(isPrime(37))  // => 37 is prime
}

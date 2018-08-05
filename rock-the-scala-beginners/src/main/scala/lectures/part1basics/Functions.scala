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


  // Factorial function => f(n)=1 * 2 * 3 * ... * n
  // e.g. f(3) = 1 * 2 * 3
  def factorial(n:Int): Int = {
    if (n<=0) 1
    else n * factorial(n-1)
  }

  println(factorial(10))


  // Fibonacci series is a sequence of numbers so that:
  // f(1)=f(2)=1
  // f(n) = f(n-1)+f(n-2)
  // In scala the recommended way to solve problems is through recursive programming model rather
  // than imperative programming

  def fibonacci(n:Int): Int={
    if (n<=2) 1 else
      fibonacci(n-1) + fibonacci(n-2)
  }

  println(fibonacci(8))


  /*
     Function to check if a number is prime
     A number is a prime number if it is greater than 1 and
     can be divided by 1 and itself only
   */
  def isPrime(n: Int): Boolean = {
    // inner function to find at least a number for which n can be divided
    // that is different from 1 and itself
    def isPrimeUntil(t: Int): Boolean = {
      println(t)
      if (t<=1) true
      else n % t != 0 && isPrimeUntil(t-1) //the function exits if the first condition is false
    }
    isPrimeUntil(n/2)
  }

  println(isPrime(2))
  println(isPrime(5))
  println(isPrime(9))
  println(isPrime(37))
}

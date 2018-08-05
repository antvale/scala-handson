package lectures.part1basics

object ValuesVariablesTypes extends App {


  // VALUES - THE VALUES ARE IMMUTABLE
  val x:Int=10

  println(x)

  // val can't be reassigned
  // x=3

  // the types are optional in scala, the compile can infer the types
  // reading from right to left each instruction

  val y = 12

  println(y)

  // BUILT-IN TYPES

  val aString: String = "Hello"
  val aChar: Char = 'a'
  val aBoolean: Boolean = true
  val aShort: Short = 12334
  val aInt: Int = y
  val aLong: Long = 123444553L
  val aFloat: Float = 12.4f
  val aDouble: Double = 3.14

  // VARIABLES

  var aVariable: Int = 10

  aVariable = aVariable + 1

  println(aVariable)




}

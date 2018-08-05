package lectures.part1basics

object Expressions extends App {

  var x:Int = 3+ 2

  var y = x + 10

  var z = 2

  z += y

  // EVERYTHING IN SCALA IS AN EXPRESSION

  // IF STATEMENT IN SCALA IS AN EXPRESSION AND THE RESULT IS ASSIGNED TO LEFT SIDE VARIABLE

  x = if (2 < 3) 10 else 101

  println(x)

  // a block of code in Scala is an expression
  var aCodeBlock = {

    val i = 0

    val j = 1

    if (i<j) x else y

  }

  println(aCodeBlock)

  // BEING ANYTHING IN SCALA AN EXPRESSION ALSO THE LOOP IS BASICALLY HANDLED AT THE SAME WAY

  var i = 0
  var aWhile = while (i<=10){
                println(i)
                i+=1
              }

  // WHILE RETURNS A UNIT TYPE THAT IS REPRESENTED BY '()'

  println(aWhile)

}

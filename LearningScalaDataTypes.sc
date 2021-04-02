
// VALUES are immutable constants.
val hello: String = """|Hola!""".stripMargin

// VARIABLES are mutable
var helloThere: String = hello
helloThere = hello + " There!"
println(helloThere)

val immutableHelloThere = hello + " There"
println(immutableHelloThere)

// Data Types

val numberOne: Int = 1
val truth : Boolean = true
val letterA: Char = 'a'
val pi: Double = 3.141592
val piSinglePrecision: Float = 3.141592f
val bigNumber: Long = 123456789
val smallNumber: Byte = 127

println("here is a mess: " + numberOne + truth + letterA + pi + bigNumber)
println(f"Pi is about $piSinglePrecision%.3f")
println(f"Zero padding on the left: $numberOne%05d")
println(s"I can use profix s to use variables like $truth ${1 + 5}")

val theUltimateAnswer: String = "To life, the universe, and everyhing is 42"
val pattern = """.* ([\d]+).*""".r
val pattern(anwerString) = theUltimateAnswer
val answer = anwerString.toInt
println(answer)

// Booleans

val isGreather = 1 > 2
val isLesses = 1 < 2
val imposible = isGreather & isLesses
val anotherWay = isGreather && isLesses
val theOr = isGreather || isLesses

// Flow control

if (1>3) {
  println('a')
} else {
  println('b')
}

// Matching

val number = 3
number match {
  case 1 => println("One")
  case 2 => println("Two")
  case 3 => println("Three")
  case _ => println("Someting else")
}

for (x <- 1 to 4) {
  val squared = x * x
  println(squared)
}

var x = 10
while (x >= 0) {
  println(x)
  x -= 1
}

x = 10
do {
  println(x)
  x -= 1
} while (x >= 0)
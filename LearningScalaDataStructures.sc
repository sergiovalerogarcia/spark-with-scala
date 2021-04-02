// Data Structures

// Tuples
// Immutable list

val captainStuff = ("Picard", "Enterprise-D")
println(captainStuff)

// Refer to individual fields with ONE-BASED index
println(captainStuff._1)
println(captainStuff._2)

val picardsShip = "Picard" -> "Enterprise-D"
println(picardsShip._1)
println(picardsShip._2)

val aBunchOfStuff = ("Kirk", 12312, true)

// List
// Must be of some type

val shipList = List("Enterprise", "Defiant", "Voyager")

// zero-based
println(shipList(0))

println(shipList.head)
println(shipList.tail) // all but first

for (ship <- shipList) { println(ship) }

val backwardShips = shipList.map((ship: String) => { ship.reverse })

// reduce() to combine
val numberList = List(1, 2, 3, 4, 5)
val sum = numberList.reduce((x: Int, y: Int) => x + y)

val iHateFives = numberList.filter((x: Int) => x != 5)

val iHateThrees = numberList.filter(_ != 3)

// Concatenate list

val moreNNumbers = List(6, 7, 8, 9)
val lotsOfNumbers = numberList ++ moreNNumbers
val reversed = numberList.reverse
val sorted = reversed.sorted
val lostsDuplicates = numberList ++ numberList
val distinctValues = lostsDuplicates.distinct
val maxValue = numberList.max
val total = numberList.sum
val hasThree = iHateThrees.contains(3)

// MAPS

val shipMap = Map(
  "Kirk" -> "Enterprse",
  "Sisko" -> "Deep Space Nine",
)

println(shipMap("Kirk"))

shipMap.contains("Archer")

val archersShip = scala.util.Try(shipMap("Archer")) getOrElse "Unknown"

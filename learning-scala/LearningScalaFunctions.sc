// Expressions

{val x = 10; x + 20}

// Functions

def squeareIt (x: Int) : Int = { x*x }

squeareIt(5)

def transformInt (x: Int, f: Int => Int): Int = { f(x) }

transformInt(4, squeareIt)
transformInt(4, x => x + x)
transformInt(4, x => { val y = x + x; y * y } )



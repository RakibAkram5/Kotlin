fun main(){
    println("Hello, World!\n")
    val str:String="Rakib Akram"
    println("My name is ${str}.\n")
    val x: Float= 10.0F
    val y: Float= 20.0F
    val sum: Float=x+y
    val difference: Float=y-x
    val product: Float=x*y
    val division: Float=x/y
    println("$x and $y: $sum\n")
    println("$x and $y: $product\n")
    println("$x and $y: $division\n")
    println("$x and $y: $difference\n")
    var a=10
    a=29
    println("a:${a}\n")
    /*val b=10
    b=20
    println("b: ${b}")
     */
    val number=readln().toInt()
    println("Number: $number\n")
    println("Enter the Lenght: ")
    var length=readln().toInt()
    println("Enter the Width: ")
    var widht=readln().toInt()
    var area=length*widht
    println("Area of a Rectangular: $area\n")
    println("Enter the Principal: ")
    var principal=readln().toFloat()
    println("Enter the Rate: ")
    var rate=readln().toFloat()
    println("Enter The time: ")
    var time=readln().toFloat()
    var si=(principal*rate*time)/100
    println("Simple Interest: $si\n")
    println("Enter the Temperature in Celsius: ")
    var celsius=readln().toFloat()
    var farhrenheit=(celsius*9/5)+32
    println("Temperature in Farhrenheit: $farhrenheit")
    

}

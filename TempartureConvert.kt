fun celsiustoFahrenheit(celsius:Double):Double{
    return celsius*9/2+32
}
fun main(){
    val celsius=25.0
    val Farhrenheit=celsiustoFahrenheit(celsius)
    println("$celsius C is equal to $Farhrenheit F")
    
}
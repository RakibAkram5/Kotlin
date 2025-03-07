fun reverseString(str:String):String{
    var reversed=" "
    for(i in str.length-1 downto 0){
        reversed+=str[i]
    }
    return reversed
}
fun main(){
    val original="Kotlin"
    println("Original: &Original")
    println("Reversed: ${reverseString(Orignal)}")
}
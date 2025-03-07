fun isEven(num:Int):Boolean{
    return num%2==0
}
fun main(){
    val number=7;
    if(isEven(number)){
        println("$number is Even")
    }
    else{
        println("$number is Odd")
    }
}
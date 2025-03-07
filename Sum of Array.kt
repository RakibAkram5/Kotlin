fun sumArray(number:Array<Int>):Int{
    var sum=0;
    for(num in numbers){
        sum+=num
    }
    return sum
}
fun main(){
    val numbers=arrayof(1,2,3,4,5)
    println("Sum of Array: ${sumArray(numbers)}")
}
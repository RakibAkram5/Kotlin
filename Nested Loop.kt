fun main() {

    for (i in 1..10) {
        println("Numbers: $i")
    }

    for (i in 0..50 step 2) {
        println("Even Numbers: $i")
    }

    println("---------------------------------------")

    for (i in 1..50 step 2) {
        println("Odd Numbers: $i")
    }

    for (i in 20 downTo 1) {
        println("Reverse Number: $i")
    }

    for (i in 1..10) {
        val mul = 5 * i
        println("5 X $i = $mul")
    }

    print("Enter the Number: ")
    val number = readln().toInt()

    var sum = 0
    for (i in 1..number) {
        sum += i
    }

    println("Sum = $sum")
    var fact=1
    print("Enter the Number whoes Factorial do you want to print.")
    var num=readln().toInt()
    for(i in 1..num){
        fact*=i
    }
    print("$num!=$fact")
    println("Enter the Number: ")
    var number_1 = readln().toInt()

    var count = 0
    var temp = number_1

    if(temp == 0){
        count = 1
    }else{
        while(temp != 0){
            temp /= 10
            count++
        }
    }

    println("Total digits = $count")

}

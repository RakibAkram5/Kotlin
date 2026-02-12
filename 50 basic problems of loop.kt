fun main() {

    var sum = 0
    var mul=1
    var n=12345
    var count=0
    var s=0

    // Loop 1 — numbers and sum
    for (i in 1..10) {
        println("Numbers: $i")
        sum = sum + i
    }

    // Loop 2 — reverse numbers
    for (i in 10 downTo 1) {
        println(i)
    }

    // Loop 3 — even/odd
    for (i in 1..20) {
        if (i % 2 == 0) {
            println("Even: $i")
        } else {
            println("Odd: $i")
        }
    }
    for(i in 1..5){
        mul*=i
    }
    for(i in 1..10){
        println("7X$i=${7*i}")
    }
    while(n>0){
        count++
        n/=10
    }
    for(i in 50 downTo 0 step 5){
        println(i)
    }
    for(i in 1..10){
        println(i*i)
    }
    for(i in 1..n){
        s+=i
    }
    println(s)
    println("Multiplication: $sum")
    println("Sum: $sum")
    println("Number Count: $count")



}

fun main() {
    var numbers = IntArray(10)
    var max = Int.MIN_VALUE
    var maxSec = Int.MIN_VALUE
    var evencount=0
    var oddCount=0
    println("Enter the Numbers In the Array: ")
    for (i in 0 until 10) {        // ✅ 0..10 causes index out of bounds (11 elements)
        numbers[i] = readln().toInt()  // ✅ missing input reading
    }

    for (i in 0 until 10) {
        if (numbers[i] > max) {        // ✅ update max correctly
            maxSec = max
            max = numbers[i]
        } else if (numbers[i] > maxSec && numbers[i] != max) {  // ✅ update second max
            maxSec = numbers[i]
        }
    }
    for(i in 0 until 10){
        if(numbers[i]%2==0){
            evencount++
        }
        else{
            oddCount++
        }
    }

    print("Second Largest Number: $maxSec")
    print("\n Even Count in the Array: $evencount")
    print("\n Odd Count in the Array: $oddCount")
}
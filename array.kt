fun main() {

    val cars = arrayOf("Toyota", "Audi", "Honda", "Haval")
    for (i in cars) {
        print(" $i")
    }

    val number = arrayOf(1, 2, 3, 4, 5, 6)

    var evenCount = 0
    var oddCount = 0
    var sum = 0
    var max = number[0]
    var min = number[0]

    for (i in number) {

        if (i % 2 == 0) evenCount++ else oddCount++

        sum += i

        if (i > max) max = i
        if (i < min) min = i
    }

    val avg = sum.toFloat() / number.size

    print("\nArray in Reverse Order: ")
    for (i in number.size - 1 downTo 0) {
        print(" ${number[i]}")
    }

    println("\nLargest Element: $max")
    println("Smallest Element: $min")
    println("Sum of Array: $sum")
    println("Even Count: $evenCount")
    println("Odd Count: $oddCount")
    println("Average: $avg")

    val numbers = arrayOf(5, 10, 15, 20, 25)
    print("\nEnter number to search: ")
    val search = readln().toInt()

    var found = false
    for (i in numbers.indices) {
        if (numbers[i] == search) {
            println("Element found at index: $i")
            found = true
            break
        }
    }

    if (!found) {
        println("Not Found.")
    }
    val copy= Array(numbers.size){0}
    for(i in numbers.indices){
        copy[i]=numbers[i]
    }
    print("Copied Array: ")
    for(i in copy){
        print(" "+i)
    }
    val num = IntArray(5)

    println("Enter 5 Numbers:")
    for (i in num.indices) {
        print("Enter number ${i + 1}: ")
        num[i] = readln().toInt()   // ✅ correct array
    }

    println("\nNumbers in the Array:")
    for (i in num) {
        println(i)
    }

}

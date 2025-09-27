import java.util.Scanner

// 1. Print all elements
fun printArray(arr: IntArray, size: Int) {
    println("Array elements: ${arr.joinToString(" ")}")
}

// 2. Maximum
fun max(arr: IntArray, size: Int): Int {
    var max = arr[0]
    for (i in 1 until size) if (arr[i] > max) max = arr[i]
    return max
}

// 3. Minimum
fun min(arr: IntArray, size: Int): Int {
    var min = arr[0]
    for (i in 1 until size) if (arr[i] < min) min = arr[i]
    return min
}

// 4. Sum
fun sum(arr: IntArray, size: Int): Int {
    var sum = 0
    for (i in 0 until size) sum += arr[i]
    return sum
}

// 5. Average
fun average(arr: IntArray, size: Int): Float = sum(arr, size).toFloat() / size

// 6. Count even
fun even(arr: IntArray, size: Int): Int {
    var count = 0
    for (i in 0 until size) if (arr[i] % 2 == 0) count++
    return count
}

// 7. Count odd
fun odd(arr: IntArray, size: Int): Int {
    var count = 0
    for (i in 0 until size) if (arr[i] % 2 != 0) count++
    return count
}

// 8. Reverse array
fun reverse(arr: IntArray, size: Int) {
    println("Reversed: ${(size - 1 downTo 0).map { arr[it] }.joinToString(" ")}")
}

// 9. Copy array
fun copyArray(arr: IntArray, size: Int): IntArray {
    val arr2 = IntArray(size)
    for (i in 0 until size) arr2[i] = arr[i]
    return arr2
}

// 10. Frequency of each element
fun frequency(arr: IntArray, size: Int) {
    val freq = mutableMapOf<Int, Int>()
    for (i in 0 until size) freq[arr[i]] = freq.getOrDefault(arr[i], 0) + 1
    println("Frequencies: $freq")
}

// 11. Second largest
fun secondLargest(arr: IntArray, size: Int): Int {
    val sorted = arr.distinct().sortedDescending()
    return if (sorted.size >= 2) sorted[1] else sorted[0]
}

// 12. Second smallest
fun secondSmallest(arr: IntArray, size: Int): Int {
    val sorted = arr.distinct().sorted()
    return if (sorted.size >= 2) sorted[1] else sorted[0]
}

// 13. Sort ascending
fun sortAscending(arr: IntArray) {
    println("Ascending: ${arr.sorted().joinToString(" ")}")
}

// 14. Sort descending
fun sortDescending(arr: IntArray) {
    println("Descending: ${arr.sortedDescending().joinToString(" ")}")
}

// 15. Merge two arrays
fun merge(arr1: IntArray, arr2: IntArray): IntArray = arr1 + arr2

// 16. Linear search
fun search(arr: IntArray, size: Int, key: Int): Int {
    for (i in 0 until size) if (arr[i] == key) return i
    return -1
}

// 17. Binary search
fun binarySearch(arr: IntArray, key: Int): Int {
    val sorted = arr.sorted()
    var low = 0
    var high = sorted.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        if (sorted[mid] == key) return mid
        if (sorted[mid] < key) low = mid + 1 else high = mid - 1
    }
    return -1
}

// 18. Remove duplicates
fun removeDuplicates(arr: IntArray): IntArray = arr.distinct().toIntArray()

// 19. Insert element
fun insertElement(arr: IntArray, size: Int, pos: Int, value: Int): IntArray {
    val list = arr.toMutableList()
    if (pos in 0..size) list.add(pos, value)
    return list.toIntArray()
}

// 20. Delete element
fun deleteElement(arr: IntArray, value: Int): IntArray = arr.filter { it != value }.toIntArray()

// 21. Rotate left
fun rotateLeft(arr: IntArray): IntArray = arr.drop(1).toIntArray() + arr[0]

// 22. Rotate right
fun rotateRight(arr: IntArray): IntArray = intArrayOf(arr.last()) + arr.dropLast(1).toIntArray()

// 23. Difference max-min
fun difference(arr: IntArray, size: Int): Int = max(arr, size) - min(arr, size)

// 24. Product of all elements
fun product(arr: IntArray, size: Int): Long {
    var prod = 1L
    for (i in 0 until size) prod *= arr[i]
    return prod
}

// 25. Count occurrence of given element
fun countElement(arr: IntArray, size: Int, key: Int): Int = arr.count { it == key }

// 26. Check if sorted
fun isSorted(arr: IntArray): Boolean = arr.sorted() == arr.toList()

// 27. Largest three elements
fun largestThree(arr: IntArray): List<Int> = arr.sortedDescending().take(3)

// 28. Separate even & odd
fun separateEvenOdd(arr: IntArray): Pair<List<Int>, List<Int>> =
    arr.filter { it % 2 == 0 } to arr.filter { it % 2 != 0 }

// 29. Common elements in two arrays
fun commonElements(arr1: IntArray, arr2: IntArray): Set<Int> = arr1.toSet().intersect(arr2.toSet())

// 30. Check if arrays are equal
fun arraysEqual(arr1: IntArray, arr2: IntArray): Boolean = arr1.contentEquals(arr2)


// ----------------- MAIN MENU -----------------
fun main() {
    val sc = Scanner(System.`in`)
    val arr = intArrayOf(10, 25, 3, 45, 2, 99, 56, 25)
    val size = arr.size

    while (true) {
        println("\n=== Array Menu (30 Problems) ===")
        println("1. Print Array")
        println("2. Maximum")
        println("3. Minimum")
        println("4. Sum")
        println("5. Average")
        println("6. Count Even")
        println("7. Count Odd")
        println("8. Reverse")
        println("9. Copy Array")
        println("10. Frequency of Elements")
        println("11. Second Largest")
        println("12. Second Smallest")
        println("13. Sort Ascending")
        println("14. Sort Descending")
        println("15. Merge Two Arrays")
        println("16. Linear Search")
        println("17. Binary Search")
        println("18. Remove Duplicates")
        println("19. Insert Element")
        println("20. Delete Element")
        println("21. Rotate Left")
        println("22. Rotate Right")
        println("23. Difference Max-Min")
        println("24. Product of All Elements")
        println("25. Count Occurrence of Element")
        println("26. Check if Sorted")
        println("27. Largest Three Elements")
        println("28. Separate Even & Odd")
        println("29. Common Elements in Two Arrays")
        println("30. Check if Arrays are Equal")
        println("31. Exit")
        print("Enter choice: ")

        when (sc.nextInt()) {
            1 -> printArray(arr, size)
            2 -> println("Max = ${max(arr, size)}")
            3 -> println("Min = ${min(arr, size)}")
            4 -> println("Sum = ${sum(arr, size)}")
            5 -> println("Average = ${average(arr, size)}")
            6 -> println("Even count = ${even(arr, size)}")
            7 -> println("Odd count = ${odd(arr, size)}")
            8 -> reverse(arr, size)
            9 -> println("Copied = ${copyArray(arr, size).joinToString(" ")}")
            10 -> frequency(arr, size)
            11 -> println("Second Largest = ${secondLargest(arr, size)}")
            12 -> println("Second Smallest = ${secondSmallest(arr, size)}")
            13 -> sortAscending(arr)
            14 -> sortDescending(arr)
            15 -> {
                val arr2 = intArrayOf(7, 8, 9)
                println("Merged = ${merge(arr, arr2).joinToString(" ")}")
            }
            16 -> {
                print("Enter element: "); val k = sc.nextInt()
                val idx = search(arr, size, k)
                if (idx != -1) println("Found at $idx") else println("Not Found")
            }
            17 -> {
                print("Enter element: "); val k = sc.nextInt()
                val idx = binarySearch(arr, k)
                if (idx != -1) println("Found at index $idx (sorted array)") else println("Not Found")
            }
            18 -> println("Without Duplicates = ${removeDuplicates(arr).joinToString(" ")}")
            19 -> {
                print("Enter pos & value: ")
                val pos = sc.nextInt(); val v = sc.nextInt()
                println("After Insert = ${insertElement(arr, size, pos, v).joinToString(" ")}")
            }
            20 -> {
                print("Enter value to delete: ")
                val v = sc.nextInt()
                println("After Delete = ${deleteElement(arr, v).joinToString(" ")}")
            }
            21 -> println("Rotate Left = ${rotateLeft(arr).joinToString(" ")}")
            22 -> println("Rotate Right = ${rotateRight(arr).joinToString(" ")}")
            23 -> println("Difference = ${difference(arr, size)}")
            24 -> println("Product = ${product(arr, size)}")
            25 -> {
                print("Enter element: "); val k = sc.nextInt()
                println("Count = ${countElement(arr, size, k)}")
            }
            26 -> println("Is Sorted? ${isSorted(arr)}")
            27 -> println("Largest Three = ${largestThree(arr)}")
            28 -> {
                val (evens, odds) = separateEvenOdd(arr)
                println("Even = $evens, Odd = $odds")
            }
            29 -> {
                val arr2 = intArrayOf(25, 45, 99, 100)
                println("Common = ${commonElements(arr, arr2)}")
            }
            30 -> {
                val arr2 = intArrayOf(10, 25, 3, 45, 2, 99, 56, 25)
                println("Arrays Equal? ${arraysEqual(arr, arr2)}")
            }
            31 -> return
            else -> println("Invalid choice!")
        }
    }
}

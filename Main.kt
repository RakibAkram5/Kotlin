fun main() {

    println("===== Student Result & Statistics System =====")

    print("Enter number of students: ")
    val n = readln().toInt()

    val names = Array(n) { "" }
    val marks = IntArray(n)

    var total = 0
    var passCount = 0
    var failCount = 0

    // assume first marks will set high/low after input
    var highest = -1
    var lowest = 101

    // Input loop
    for (i in 0 until n) {
        print("Enter name of student ${i + 1}: ")
        names[i] = readln()

        print("Enter marks of ${names[i]}: ")
        marks[i] = readln().toInt()

        total += marks[i]

        // pass / fail
        if (marks[i] >= 50) {
            passCount++
        } else {
            failCount++
        }

        // highest
        if (marks[i] > highest) {
            highest = marks[i]
        }

        // lowest
        if (marks[i] < lowest) {
            lowest = marks[i]
        }
    }

    println("\n===== Student Report =====")

    // Output loop with grade
    for (i in 0 until n) {
        var grade: Char

        if (marks[i] >= 85) {
            grade = 'A'
        } else if (marks[i] >= 70) {
            grade = 'B'
        } else if (marks[i] >= 60) {
            grade = 'C'
        } else if (marks[i] >= 50) {
            grade = 'D'
        } else {
            grade = 'F'
        }

        val result = if (marks[i] >= 50) "Pass" else "Fail"

        println("${names[i]} -> Marks: ${marks[i]} | Result: $result | Grade: $grade")
    }

    val average = total.toDouble() / n

    println("\n===== Statistics =====")
    println("Average Marks: $average")
    println("Highest Marks: $highest")
    println("Lowest Marks: $lowest")
    println("Total Pass: $passCount")
    println("Total Fail: $failCount")

    // Search student
    print("\nEnter name to search: ")
    val searchName = readln()
    var found = false

    for (i in 0 until n) {
        if (names[i] == searchName) {
            println("Found: ${names[i]} has ${marks[i]} marks")
            found = true
        }
    }

    if (!found) {
        println("Student not found")
    }

    // Topper
    println("\nTopper(s):")
    for (i in 0 until n) {
        if (marks[i] == highest) {
            println(names[i])
        }
    }
}

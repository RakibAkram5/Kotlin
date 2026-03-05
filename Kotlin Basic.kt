fun StudentGrade(marks: DoubleArray) {
    for (i in 0..4) {                          // Fix 2: 0..4 matches array size
        if (marks[i] >= 90 && marks[i] <= 100) {   // Fix 1: correct range order
            println("A+")
        } else if (marks[i] >= 80 && marks[i] <= 89) {
            println("B")
        } else if (marks[i] >= 70 && marks[i] <= 79) {
            println("C")
        } else if (marks[i] >= 60 && marks[i] <= 69) {
            println("D")
        } else {
            println("F")
        }
    }
}

fun main() {
    var marks = DoubleArray(5)                 // 5 elements: indices 0–4
    print("Enter the Marks: ")
    for (i in 0..4) {                          // Fix 2: match array bounds
        marks[i] = readln().toDouble()
    }
    StudentGrade(marks)
}
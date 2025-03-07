import java.util.Scanner  // Import the Scanner class

fun main() {
    val reader = Scanner(System.`in`) // Create a Scanner instance for input

    print("Enter two numbers: ")
    val first = reader.nextDouble()   // Use nextDouble() with capital D
    val second = reader.nextDouble()

    print("Enter an operator (+, -, *, /): ")
    val operator = reader.next()[0]     // Get the first character of the input string

    // Use Double (with a capital D) instead of double and let the 'when' expression assign the result.
    val result: Double = when (operator) {
        '+' -> first + second
        '-' -> first - second
        '*' -> first * second
        '/' -> first / second
        else -> {
            println("Error! Operator is not correct")
            return
        }
    }

    // Print the result using System.out.printf with correct capitalization.
    System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result)
}

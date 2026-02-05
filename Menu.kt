fun main() {

    while (true) {
        println("\n===== MENU =====")
        println("1. Even or Odd")
        println("2. Greater Number")
        println("3. Positive, Negative or Zero")
        println("4. Pass or Fail")
        println("5. Voting Eligibility")
        println("6. Leap Year")
        println("7. Day of Week")
        println("8. Simple Calculator")
        println("9. Exit")
        print("Enter your choice: ")

        val choice = readln().toInt()

        when (choice) {

            // Task 1
            1 -> {
                print("Enter a number: ")
                val number = readln().toInt()

                if (number % 2 == 0)
                    println("$number is Even.")
                else
                    println("$number is Odd.")
            }

            // Task 2
            2 -> {
                print("Enter Number 1: ")
                val num1 = readln().toInt()

                print("Enter Number 2: ")
                val num2 = readln().toInt()

                if (num1 > num2)
                    println("$num1 is greater than $num2")
                else if (num2 > num1)
                    println("$num2 is greater than $num1")
                else
                    println("Both numbers are equal")
            }

            // Task 3
            3 -> {
                print("Enter a number: ")
                val n = readln().toInt()

                if (n > 0)
                    println("$n is Positive.")
                else if (n < 0)
                    println("$n is Negative.")
                else
                    println("$n is Zero.")
            }

            // Task 4
            4 -> {
                print("Enter your marks: ")
                val marks = readln().toInt()

                if (marks >= 50)
                    println("Pass")
                else
                    println("Fail")
            }

            // Task 5
            5 -> {
                print("Enter your age: ")
                val age = readln().toInt()

                if (age >= 18)
                    println("You are eligible for voting.")
                else
                    println("You are not eligible for voting.")
            }

            // Task 6
            6 -> {
                print("Enter a year: ")
                val year = readln().toInt()

                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                    println("Leap Year")
                else
                    println("Not a Leap Year")
            }

            // Task 7
            7 -> {
                print("Enter day number (1-7): ")
                val day = readln().toInt()

                val result = when (day) {
                    1 -> "Monday"
                    2 -> "Tuesday"
                    3 -> "Wednesday"
                    4 -> "Thursday"
                    5 -> "Friday"
                    6 -> "Saturday"
                    7 -> "Sunday"
                    else -> "Invalid day"
                }
                println(result)
            }

            // Task 8
            8 -> {
                print("Enter Number 1: ")
                val num1 = readln().toInt()

                print("Enter Number 2: ")
                val num2 = readln().toInt()

                print("Enter operator ( +  -  *  / ): ")
                val operator = readln()

                val calcResult = when (operator) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    "/" -> num1 / num2
                    else -> {
                        println("Invalid operator")
                        return
                    }
                }

                println("Result = $calcResult")
            }

            // Exit
            9 -> {
                println("Exiting program...")
                return
            }

            else -> println("Invalid choice. Try again.")
        }
    }
}

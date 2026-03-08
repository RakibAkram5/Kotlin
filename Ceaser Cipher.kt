import java.util.Scanner

fun encrypt(text: String, shift: Int): String {
    val normalizedShift = ((shift % 26) + 26) % 26
    return text.map { char ->
        when {
            char.isUpperCase() -> {
                val shifted = (char.code - 'A'.code + normalizedShift) % 26
                ('A'.code + shifted).toChar()
            }
            char.isLowerCase() -> {
                val shifted = (char.code - 'a'.code + normalizedShift) % 26
                ('a'.code + shifted).toChar()
            }
            else -> char // Keep spaces, punctuation, numbers unchanged
        }
    }.joinToString("")
}

fun decrypt(text: String, shift: Int): String {
    return encrypt(text, -shift) // Decryption is just encryption with negative shift
}

fun bruteForce(text: String) {
    println("\n📋 All possible decryptions (Brute Force):")
    println("-".repeat(45))
    for (shift in 1..25) {
        val decrypted = decrypt(text, shift)
        println("  Shift ${shift.toString().padStart(2)}: $decrypted")
    }
    println("-".repeat(45))
}

fun printBanner() {
    println("""
    ╔══════════════════════════════════════════╗
    ║         🔐 CAESAR CIPHER TOOL 🔐         ║
    ╚══════════════════════════════════════════╝
    """.trimIndent())
}

fun printMenu() {
    println("""
    ┌──────────────────────────────────────────┐
    │              MAIN MENU                   │
    ├──────────────────────────────────────────┤
    │  1. 🔒 Encrypt a message                 │
    │  2. 🔓 Decrypt a message                 │
    │  3. 🔍 Brute Force decrypt               │
    │  4. ❌ Exit                              │
    └──────────────────────────────────────────┘
    """.trimIndent())
    print("  Enter your choice (1-4): ")
}

fun getShift(scanner: Scanner): Int {
    while (true) {
        print("  Enter shift value (1-25): ")
        val input = scanner.nextLine().trim()
        val shift = input.toIntOrNull()
        if (shift != null && shift in 1..25) return shift
        println("  ⚠️  Invalid input! Please enter a number between 1 and 25.")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    printBanner()

    while (true) {
        printMenu()
        when (scanner.nextLine().trim()) {

            "1" -> {
                println("\n🔒 ENCRYPT MODE")
                println("-".repeat(45))
                print("  Enter message to encrypt: ")
                val message = scanner.nextLine()
                val shift = getShift(scanner)
                val encrypted = encrypt(message, shift)
                println("\n  ✅ Original  : $message")
                println("  ✅ Shift     : $shift")
                println("  ✅ Encrypted : $encrypted")
                println("-".repeat(45))
            }

            "2" -> {
                println("\n🔓 DECRYPT MODE")
                println("-".repeat(45))
                print("  Enter message to decrypt: ")
                val message = scanner.nextLine()
                val shift = getShift(scanner)
                val decrypted = decrypt(message, shift)
                println("\n  ✅ Encrypted : $message")
                println("  ✅ Shift     : $shift")
                println("  ✅ Decrypted : $decrypted")
                println("-".repeat(45))
            }

            "3" -> {
                println("\n🔍 BRUTE FORCE MODE")
                println("-".repeat(45))
                print("  Enter encrypted message: ")
                val message = scanner.nextLine()
                bruteForce(message)
            }

            "4" -> {
                println("\n  👋 Goodbye! Stay secure!\n")
                return
            }

            else -> println("\n  ⚠️  Invalid choice! Please enter 1, 2, 3, or 4.\n")
        }

        println()
    }
}
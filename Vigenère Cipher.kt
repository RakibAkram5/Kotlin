import java.util.Scanner

// ─────────────────────────────────────────────
//  CORE FUNCTIONS
// ─────────────────────────────────────────────

fun validateKey(key: String): Boolean = key.all { it.isLetter() }

fun encrypt(text: String, key: String): String {
    val cleanKey = key.uppercase()
    var keyIndex = 0
    return text.map { char ->
        when {
            char.isUpperCase() -> {
                val shift = cleanKey[keyIndex % cleanKey.length].code - 'A'.code
                keyIndex++
                (('A'.code + (char.code - 'A'.code + shift) % 26)).toChar()
            }
            char.isLowerCase() -> {
                val shift = cleanKey[keyIndex % cleanKey.length].code - 'A'.code
                keyIndex++
                (('a'.code + (char.code - 'a'.code + shift) % 26)).toChar()
            }
            else -> char // spaces, punctuation, numbers untouched
        }
    }.joinToString("")
}

fun decrypt(text: String, key: String): String {
    val cleanKey = key.uppercase()
    var keyIndex = 0
    return text.map { char ->
        when {
            char.isUpperCase() -> {
                val shift = cleanKey[keyIndex % cleanKey.length].code - 'A'.code
                keyIndex++
                (('A'.code + (char.code - 'A'.code - shift + 26) % 26)).toChar()
            }
            char.isLowerCase() -> {
                val shift = cleanKey[keyIndex % cleanKey.length].code - 'A'.code
                keyIndex++
                (('a'.code + (char.code - 'a'.code - shift + 26) % 26)).toChar()
            }
            else -> char
        }
    }.joinToString("")
}

fun showVigenereTable() {
    println("\n  📊 Vigenère Table (A–F preview):")
    println("  " + "─".repeat(40))
    print("      ")
    for (c in 'A'..'F') print("  $c ")
    println(" ...")
    println("  " + "─".repeat(40))
    for (row in 'A'..'F') {
        print("   $row |")
        for (col in 'A'..'F') {
            val enc = (('A'.code + (row.code - 'A'.code + col.code - 'A'.code) % 26)).toChar()
            print("  $enc ")
        }
        println(" ...")
    }
    println("  " + "─".repeat(40))
    println("  (Full table: 26×26 grid of shifted alphabets)\n")
}

fun showKeyExpansion(text: String, key: String) {
    val cleanKey = key.uppercase()
    val letters = text.filter { it.isLetter() }
    println("\n  🔑 Key Expansion:")
    println("  " + "─".repeat(50))
    print("  Plaintext : ")
    println(letters.take(30).joinToString(" "))
    print("  Key       : ")
    val expandedKey = (letters.indices).map { cleanKey[it % cleanKey.length] }
    println(expandedKey.take(30).joinToString(" "))
    if (letters.length > 30) println("  ... (truncated)")
    println("  " + "─".repeat(50))
}

// ─────────────────────────────────────────────
//  UI HELPERS
// ─────────────────────────────────────────────

fun printBanner() {
    println("""
╔══════════════════════════════════════════════════╗
║        🔐  VIGENÈRE CIPHER TOOL  🔐              ║
║   Polyalphabetic Substitution Cipher             ║
╚══════════════════════════════════════════════════╝
    """.trimIndent())
}

fun printMenu() {
    println("""
┌──────────────────────────────────────────────────┐
│                   MAIN MENU                      │
├──────────────────────────────────────────────────┤
│  1. 🔒 Encrypt a message                         │
│  2. 🔓 Decrypt a message                         │
│  3. 🔄 Encrypt then Decrypt (verify roundtrip)   │
│  4. 📊 Show Vigenère Table                       │
│  5. ❌ Exit                                      │
└──────────────────────────────────────────────────┘
    """.trimIndent())
    print("  Enter your choice (1-5): ")
}

fun getKey(scanner: Scanner): String {
    while (true) {
        print("  Enter keyword (letters only, e.g. KEY): ")
        val key = scanner.nextLine().trim()
        if (key.isNotEmpty() && validateKey(key)) return key
        println("  ⚠️  Invalid key! Use letters only (A-Z / a-z), no spaces or numbers.")
    }
}

fun separator() = println("  " + "─".repeat(50))

// ─────────────────────────────────────────────
//  MAIN
// ─────────────────────────────────────────────

fun main() {
    val scanner = Scanner(System.`in`)
    printBanner()

    while (true) {
        printMenu()
        when (scanner.nextLine().trim()) {

            "1" -> {
                println("\n  🔒 ENCRYPT MODE")
                separator()
                print("  Enter message   : ")
                val message = scanner.nextLine()
                val key = getKey(scanner)

                showKeyExpansion(message, key)

                val encrypted = encrypt(message, key)
                println("\n  ✅ Plaintext  : $message")
                println("  ✅ Keyword    : $key")
                println("  ✅ Ciphertext : $encrypted")
                separator()
            }

            "2" -> {
                println("\n  🔓 DECRYPT MODE")
                separator()
                print("  Enter ciphertext : ")
                val message = scanner.nextLine()
                val key = getKey(scanner)

                showKeyExpansion(message, key)

                val decrypted = decrypt(message, key)
                println("\n  ✅ Ciphertext : $message")
                println("  ✅ Keyword    : $key")
                println("  ✅ Plaintext  : $decrypted")
                separator()
            }

            "3" -> {
                println("\n  🔄 ROUNDTRIP VERIFICATION")
                separator()
                print("  Enter message : ")
                val message = scanner.nextLine()
                val key = getKey(scanner)

                val encrypted = encrypt(message, key)
                val decrypted = decrypt(encrypted, key)
                val match = message == decrypted

                println("\n  Original    : $message")
                println("  Keyword     : $key")
                println("  Encrypted   : $encrypted")
                println("  Decrypted   : $decrypted")
                println("  Match       : ${if (match) "✅ YES — Perfect roundtrip!" else "❌ NO — Something went wrong!"}")
                separator()
            }

            "4" -> showVigenereTable()

            "5" -> {
                println("\n  👋 Goodbye! Stay secure!\n")
                return
            }

            else -> println("\n  ⚠️  Invalid choice! Please enter 1–5.\n")
        }

        println()
    }
}
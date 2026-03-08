import java.util.Scanner

// ─────────────────────────────────────────────
//  CORE FUNCTIONS
// ─────────────────────────────────────────────

fun validateKey(key: String): Boolean = key.all { it.isLetter() }

/**
 * Autokey Cipher Encryption
 * Key = primer keyword + plaintext letters (extended automatically)
 * Each letter gets a unique shift based on its position's key character
 */
fun encrypt(text: String, primer: String): String {
    val letters = text.filter { it.isLetter() }.uppercase()
    val fullKey = (primer.uppercase() + letters).substring(0, letters.length)

    var keyIndex = 0
    return text.map { char ->
        when {
            char.isUpperCase() -> {
                val shift = fullKey[keyIndex++].code - 'A'.code
                (('A'.code + (char.code - 'A'.code + shift) % 26)).toChar()
            }
            char.isLowerCase() -> {
                val shift = fullKey[keyIndex++].code - 'A'.code
                keyIndex
                (('a'.code + (char.code - 'a'.code + shift) % 26)).toChar()
            }
            else -> char
        }
    }.joinToString("")
}

/**
 * Autokey Cipher Decryption
 * Recovers plaintext one character at a time,
 * each decrypted letter extends the key for the next position
 */
fun decrypt(text: String, primer: String): String {
    val cleanPrimer = primer.uppercase()
    val result = StringBuilder()
    val keyBuffer = StringBuilder(cleanPrimer)
    var keyIndex = 0

    for (char in text) {
        when {
            char.isUpperCase() -> {
                val shift = keyBuffer[keyIndex].code - 'A'.code
                val plain = (('A'.code + (char.code - 'A'.code - shift + 26) % 26)).toChar()
                result.append(plain)
                keyBuffer.append(plain)
                keyIndex++
            }
            char.isLowerCase() -> {
                val shift = keyBuffer[keyIndex].code - 'A'.code
                val plain = (('a'.code + (char.code - 'a'.code - shift + 26) % 26)).toChar()
                result.append(plain)
                keyBuffer.append(plain.uppercaseChar())
                keyIndex++
            }
            else -> result.append(char)
        }
    }
    return result.toString()
}

// ─────────────────────────────────────────────
//  DISPLAY HELPERS
// ─────────────────────────────────────────────

fun showKeyExpansion(text: String, primer: String, mode: String) {
    val letters = text.filter { it.isLetter() }.uppercase()
    val cleanPrimer = primer.uppercase()

    println("\n  🔑 Key Expansion (Autokey):")
    println("  " + "─".repeat(56))

    if (mode == "encrypt") {
        val fullKey = (cleanPrimer + letters).substring(0, letters.length)
        val preview = minOf(letters.length, 28)

        println("  Primer     : $cleanPrimer")
        print("  Plaintext  : ")
        println(letters.take(preview) + if (letters.length > preview) "..." else "")
        print("  Full Key   : ")
        println(fullKey.take(preview) + if (fullKey.length > preview) "..." else "")

        println("\n  📌 Key Construction:")
        println("     [$cleanPrimer] ← primer")
        println("     + [${letters.take(preview - cleanPrimer.length)}...] ← plaintext letters appended")
    } else {
        println("  Primer     : $cleanPrimer")
        println("  📌 Key grows as each plaintext letter is recovered during decryption.")
        println("     Primer [$cleanPrimer] → decrypt char 1 → append to key → decrypt char 2 → ...")
    }

    println("  " + "─".repeat(56))
}

fun showComparison(text: String, primer: String) {
    println("\n  📊 CIPHER COMPARISON for: \"$text\" | Primer: \"$primer\"")
    println("  " + "─".repeat(56))

    // Caesar (shift = primer[0] - 'A')
    val caesarShift = primer.uppercase()[0].code - 'A'.code
    val caesarEnc = text.map { c ->
        when {
            c.isUpperCase() -> (('A'.code + (c.code - 'A'.code + caesarShift) % 26)).toChar()
            c.isLowerCase() -> (('a'.code + (c.code - 'a'.code + caesarShift) % 26)).toChar()
            else -> c
        }
    }.joinToString("")

    // Vigenere (repeating key)
    val vKey = primer.uppercase()
    var vIdx = 0
    val vigenereEnc = text.map { c ->
        when {
            c.isUpperCase() -> {
                val s = vKey[vIdx++ % vKey.length].code - 'A'.code
                (('A'.code + (c.code - 'A'.code + s) % 26)).toChar()
            }
            c.isLowerCase() -> {
                val s = vKey[vIdx++ % vKey.length].code - 'A'.code
                (('a'.code + (c.code - 'a'.code + s) % 26)).toChar()
            }
            else -> c
        }
    }.joinToString("")

    // Autokey
    val autokeyEnc = encrypt(text, primer)

    println("  Caesar   (shift=${caesarShift})     : $caesarEnc  ← single fixed shift")
    println("  Vigenère (key=$primer, repeating) : $vigenereEnc  ← repeating keyword")
    println("  Autokey  (primer=$primer)         : $autokeyEnc  ← self-extending key ✅")
    println("  " + "─".repeat(56))
    println("  💡 Autokey is stronger — key never repeats, reducing pattern attacks.\n")
}

fun printBanner() {
    println("""
╔════════════════════════════════════════════════════════╗
║         🔐  AUTOKEY CIPHER TOOL  🔐                   ║
║   Self-Extending Polyalphabetic Substitution Cipher    ║
╚════════════════════════════════════════════════════════╝
    """.trimIndent())
    println("""
  📖 How Autokey Works:
     • Start with a short primer keyword (e.g. "KEY")
     • Extend it by appending the plaintext itself
     • Result: a unique, non-repeating key stream
     • Much stronger than standard Vigenère!
  """)
}

fun printMenu() {
    println("""
┌──────────────────────────────────────────────────────┐
│                    MAIN MENU                         │
├──────────────────────────────────────────────────────┤
│  1. 🔒 Encrypt a message                             │
│  2. 🔓 Decrypt a message                             │
│  3. 🔄 Roundtrip (Encrypt → Decrypt verify)          │
│  4. 📊 Compare Caesar vs Vigenère vs Autokey         │
│  5. ❌ Exit                                          │
└──────────────────────────────────────────────────────┘
    """.trimIndent())
    print("  Enter your choice (1-5): ")
}

fun getPrimer(scanner: Scanner): String {
    while (true) {
        print("  Enter primer keyword (letters only, e.g. KEY): ")
        val key = scanner.nextLine().trim()
        if (key.isNotEmpty() && validateKey(key)) return key
        println("  ⚠️  Invalid primer! Use letters only (A-Z / a-z).")
    }
}

fun separator() = println("  " + "─".repeat(56))

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
                print("  Enter message : ")
                val message = scanner.nextLine()
                val primer = getPrimer(scanner)

                showKeyExpansion(message, primer, "encrypt")

                val encrypted = encrypt(message, primer)
                println("\n  ✅ Plaintext  : $message")
                println("  ✅ Primer     : $primer")
                println("  ✅ Ciphertext : $encrypted")
                separator()
            }

            "2" -> {
                println("\n  🔓 DECRYPT MODE")
                separator()
                print("  Enter ciphertext : ")
                val message = scanner.nextLine()
                val primer = getPrimer(scanner)

                showKeyExpansion(message, primer, "decrypt")

                val decrypted = decrypt(message, primer)
                println("\n  ✅ Ciphertext : $message")
                println("  ✅ Primer     : $primer")
                println("  ✅ Plaintext  : $decrypted")
                separator()
            }

            "3" -> {
                println("\n  🔄 ROUNDTRIP VERIFICATION")
                separator()
                print("  Enter message : ")
                val message = scanner.nextLine()
                val primer = getPrimer(scanner)

                val encrypted = encrypt(message, primer)
                val decrypted = decrypt(encrypted, primer)
                val match = message == decrypted

                println("\n  Original    : $message")
                println("  Primer      : $primer")
                println("  Encrypted   : $encrypted")
                println("  Decrypted   : $decrypted")
                println("  Match       : ${if (match) "✅ YES — Perfect roundtrip!" else "❌ NO — Mismatch detected!"}")
                separator()
            }

            "4" -> {
                println("\n  📊 CIPHER COMPARISON MODE")
                separator()
                print("  Enter message : ")
                val message = scanner.nextLine()
                val primer = getPrimer(scanner)
                showComparison(message, primer)
            }

            "5" -> {
                println("\n  👋 Goodbye! Stay secure!\n")
                return
            }

            else -> println("\n  ⚠️  Invalid choice! Please enter 1–5.\n")
        }

        println()
    }
}
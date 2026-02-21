# 🟦 Kotlin Pattern Logic Masterclass

This repository contains clean, optimized Kotlin implementations for various geometric patterns (Stars, Squares, Hills, and Diamonds). The goal of this project is to demonstrate **logic building** using nested loops and coordinate geometry.

## 📌 The Logic Building Framework

Most people struggle with patterns because they try to memorize them. Instead, this project uses a **Grid System**:

1.  **Outer Loop (`i`):** Manages the **Rows**.
2.  **Inner Loop (`j`):** Manages the **Columns** (Spaces + Characters).
3.  **The Formula:** Every pattern is just a mathematical relationship between `i` and `j`.

---

## 🚀 Patterns Covered

### 1. Simple Triangles
* **Increasing Triangle:** `j` goes from 1 to `i`.
* **Decreasing Triangle:** `j` goes from `i` to `n`.

### 2. Hill & Pyramid Patterns
* **Hill Pattern:** Combining a decreasing triangle of spaces with an increasing triangle of stars.
* **Reverse Hill:** The vertical flip of the Hill pattern.

### 3. Advanced Shapes
* **Diamond:** A combination of a Hill and a Reverse Hill.
* **Double Hill:** Two hills side-by-side using multiple inner loops.
* **Square Patterns:** Fixed-width loops using different characters (`#`, `$`, `&`).

---

## 🛠️ Visual Logic Table

| Pattern | Row Logic ($i$) | Column Logic ($j$) | Character |
| :--- | :--- | :--- | :--- |
| **Square** | $1 \dots n$ | $1 \dots n$ | `#` |
| **Increasing** | $1 \dots n$ | $1 \dots i$ | `*` |
| **Decreasing** | $1 \dots n$ | $i \dots n$ | `*` |
| **Hill** | $1 \dots n$ | Spaces: $n-i$, Stars: $2i-1$ | `*` |

---

## 💻 Code Example: The Diamond

```kotlin
fun drawDiamond(n: Int) {
    // Upper Hill
    for (i in 1..n) {
        for (j in i..n) print("  ")
        for (j in 1 until 2 * i) print("* ")
        println()
    }
    // Lower Reverse Hill
    for (i in n - 1 downTo 1) {
        for (j in n downTo i) print("  ")
        for (j in 1 until 2 * i) print("* ")
        println()
    }
}w

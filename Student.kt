class Student(
    val name: String,
    val rollNo: Int,
    val marks: Float
) {
    fun display() {
        println("Name: $name")
        println("Roll Number: $rollNo")
        println("Marks: $marks")
    }
}
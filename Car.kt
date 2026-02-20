class Car(
    val brand: String,
    val model: String,
    val year: Int
) {
    fun display() {
        println("Brand: $brand")
        println("Model: $model")
        println("Year: $year")
    }
}
fun main() {
    val student = DoubleArray(5)
    println("Enter Student Marks: ")
    for (i in 0..4) {
        student[i] = readln().toDouble()
        if (student[i] <= 100 && student[i] > 90) {
            println("A")
        } else if (student[i] <= 90 && student[i] >= 80) {
            println("B")
        }
        else if(student[i]<=79&&student[i]>=70){
            println("C")
        }
        else if(student[i]<=69&&student[i]>=60){
            println("D")
        }
        else{
            println("F")
        }
    }
}
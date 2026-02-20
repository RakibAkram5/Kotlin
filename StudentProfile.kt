import kotlin.time.TimeSource

class StudentProfile (
    var name: String,
    var rollNumber: Int,
    var marks: Double
){
    fun display(){
        println("Student Name: $name")
        println("Roll Number: $rollNumber")
        println("Marks: $marks")
    }
    fun caclculateGrade(){
        if(marks>=80){
            println("Grade: A")
        }
        else if(marks>=60){
            println("Grade: B")
        }
        else if(marks>=40){
            println("Grade: C")
        }
        else{
            println("Grade: Fail.")
        }
    }
}

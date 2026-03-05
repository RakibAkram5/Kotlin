open class person(
    age: Int,
    name: String
){
    init{
        println("My name is $name")
        println("My age is $age")
    }

}
class mathTeacher(
    age: Int,
    name: String
):person(age,name){
    fun teachmaths(){
        println("I teach in Primary School.")
    }
}
class footballer(
    age: Int,
    name: String

):person(age,name){
    fun playfootball(){
        println("I play for LA Galaxy.")
    }
}
fun main(agrs: Array<String>){
    val t1=mathTeacher(23,"Rakib")
    t1.teachmaths()
    println()
    val f1=footballer(22,"Rafay")
    f1.playfootball()

}
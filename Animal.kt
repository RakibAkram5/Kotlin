abstract class Animal{
    abstract fun sound()
}
class Dog:Animal(){
    override fun sound() {
        println("Dog Barks")
    }
}

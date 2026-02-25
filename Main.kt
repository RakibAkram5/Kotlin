fun main(){
    val userAtm=ATM(500000.999)
    userAtm.deposit(20000.11)
    println("current Balance: ${userAtm.getBalance()}")
    val d =Dog()
    d.sound()
}
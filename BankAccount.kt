import jdk.jfr.DataAmount

class BankAccount (
    var accountHolder: String,
    var accountNumber: Int,
    private var balance: Double
)
{
    fun desposite(amount: Double){
        balance+=amount
        if(amount>0)
            println("Deposited: $amount")
        else
            println("Invalid Desposit amount")

    }
    fun widthdraw(amount: Double){
        if(amount<=balance){
            balance-=amount
            println("Withdrawn: $amount")
        }
        else{
            println("Insufficient Balance.")
        }
    }
    fun showbalance(){
        println("Current Balance: $balance")
    }
    fun showAccountinfo(){
        println("Account Holder: $accountHolder")
        println("Account Number: $accountNumber")
    }
}
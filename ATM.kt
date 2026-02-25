class ATM (
    private var balance: Double

){
    fun deposit(amount:Double){
        if(amount>0){
            balance+=amount
            println("Deposit: $amount")
        }
        else{
            println("Invalid amount")
        }
    }
    fun withdraw(amount: Double){
        if(amount<=balance){
            balance-=amount
            println("Withdraw: $amount")
        }
        else{
            println("Insufficient balance")
        }

    }
    fun getBalance(): Double{
        return balance
    }
}

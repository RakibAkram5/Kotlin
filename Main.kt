fun main(){
    print("Enter the Amount: ")
    var amount=readln().toDouble()
    print("\n Enter the Account Number: ")
    var an=readln().toInt()
    print("\n Enter The Account Holder Name: ")
    var ah=readln()
    val acc=BankAccount(ah,an,amount)
    acc.desposite(amount)
    acc.showAccountinfo()
    acc.widthdraw(amount)
    acc.showAccountinfo()
    
}
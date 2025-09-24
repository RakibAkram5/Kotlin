fun main(){
    print("Enter The Number: ")
    var number=readln().toInt()
    if(number<0){
        print("$number is Negitive.")
    }
    else if(number>0){
        print("$number is Positive.")
    }
    else{
        print("$number is Zero.")
    }
}
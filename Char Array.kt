fun main(){
//    val letters=charArrayOf('A','B','C','D')
//    println(letters.joinToString())
//    val arr= CharArray(5)
//    arr[0]='H'
//    arr[1]='E'
//    arr[2]='L'
//    arr[3]='L'
//    arr[4]='O'
//    println(arr.joinToString(""))
//    print("Enter a Word: ")
//    val input=readln()
//    val charArray=input.toCharArray()
//    println("Characters Are: ")
//    for(ch in charArray){
//        print(ch)
//    }

    val arr=charArrayOf('r','a','k','i','b')
    printCharcters(arr)
    println("\nVowels: ${countVowels(arr)}")
    toUpperCaseArray(arr)
    for(c in arr){
        print("$c")
    }
}
fun printCharcters(arr: CharArray){
    for(i in arr.indices){
        print("${arr[i]}")
    }
}
fun countVowels(arr: CharArray):Int{
    var count=0
    for(i in arr.indices){
        if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='A'||arr[i]=='E'||arr[i]=='I'||arr[i]=='O'||arr[i]=='U'){
            count++
        }
    }
    return count
}
fun toUpperCaseArray(arr: CharArray){
    for(i in arr.indices){
        if(arr[i]>='a'&&arr[i]<='z'){
            arr[i]=(arr[i]-32)
        }
    }
}

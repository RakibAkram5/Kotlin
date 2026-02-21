fun main(){
    var n=5
    drawIncreasingTriangle(5)
    drawDecreasingTriangle(5)
    drawHill(5)
}
fun drawIncreasingTriangle(n: Int){
    for(i in 1..n){
        for(j in 1..i){
            print("* ")
        }
        println()
    }
}
fun drawDecreasingTriangle(n: Int){
    for(i in 1..n){
        for(j in i..n){
            print("* ")
        }
        println()
    }
}
fun drawHill(n: Int){
    for(i in 1..n){
        for(j in i..n){
            print(" ")
        }
        for(j in 1..i){
            print("* ")
        }
        for(j in 1 until i ){
            print("* ")
        }
        println()
    }
}
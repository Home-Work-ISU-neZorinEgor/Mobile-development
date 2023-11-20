fun main(){
    val k = readln().toInt()
    val x = readln().toInt()
    val y = readln().toInt()
    println(res(k, x, y))
}

fun res(k: Int, x: Int, y: Int): Int {
    if ((x > y) && (k - x >= 2)){
        return (k - x)
    } else if ((x < y) && (k - y >= 2)){
        return (k - y)
    } else if ((x == y) && (k <= x)){
        return 2
    } else{
        return (k - x)
    }
}

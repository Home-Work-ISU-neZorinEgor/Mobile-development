fun main() {
    val N: Int = 85 //прошло месяцев
    val M: Int = 19 //сколько живут кролики
    val bunnies = LongArray(N)

    for (month in 0 until N) {
        if (month < 2) {
            bunnies[month] = 1
        } else if (month < M) {
            bunnies[month] = bunnies[month - 2] + bunnies[month - 1]
        } else if (month == M || month == M + 1) {
            bunnies[month] = bunnies[month - 2] + bunnies[month - 1] - 1
        } else {
            bunnies[month] = bunnies[month - 2] + bunnies[month - 1] - bunnies[month - M - 1]
        }
    }
    

    println(bunnies[N - 1])
}

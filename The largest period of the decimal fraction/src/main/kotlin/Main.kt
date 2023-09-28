fun findLongestRecurringDecimal(): Int {
    var maxLength = 0
    var number = 0

    for (d in 2 until 1000) {
        val remainder = BooleanArray(d) { false } //значения по умолчанию
        var numerator = 1
        var position = 0

        while (numerator != 0 && !remainder[numerator]) {
            remainder[numerator] = true
            numerator = (numerator * 10) % d
            position++
        }

        if (position - 1 > maxLength) {
            maxLength = position - 1
            number = d
        }
    }

    return number
}

fun main() {
    val result = findLongestRecurringDecimal()
    println("Число $result дает наибольший период.")
}

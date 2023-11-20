internal abstract class Shape : Comparable<Shape> {
    internal abstract fun area(): Double
    override fun compareTo(s: Shape) = this.area().compareTo(s.area())
}

internal class Square(val a: Int) : Shape() {
    override fun area() = (a * a).toDouble()
}

internal open class Rect(val a: Int, val b: Int) : Shape() {
    override fun area() = (a * b).toDouble()
}

internal class RectAsSquare(square: Square) : Rect(square.a, square.a)


fun main() {
    val ras = RectAsSquare(Square(10))
    println(ras.area())
    println(RectAsSquare(Square(12)).area())
}
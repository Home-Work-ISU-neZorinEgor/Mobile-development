// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(x: Int, y: Int, var width: Int, var height: Int)
    : Movable, Figure(x, y), Transforming {
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun area(): Float = (width * height).toFloat()

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val ax = x - centerX
        val ay = y - centerY
        x = if (direction == RotateDirection.Clockwise) {
            y = - ax + centerY
            ay + centerX
        } else {
            y = ax + centerY
            - ay + centerX
        }
        width = height.also { height = width }
    }

    override fun toString(): String {
        return "Rectangle ($x, $y), width: $width, height: $height"
    }
}
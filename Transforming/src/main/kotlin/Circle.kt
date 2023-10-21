import kotlin.math.PI

class Circle(x: Int, y: Int, var r: Int) : Figure(x, y), Transforming {
    override fun area(): Float = (PI * r * r).toFloat()

    override fun resize(zoom: Int) {
        r *= zoom
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
    }

    override fun toString(): String {
        return "Circle ($x, $y), radius: $r"
    }
}
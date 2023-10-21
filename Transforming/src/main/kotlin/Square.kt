class Square(x: Int, y: Int, var side: Int) : Figure(x, y), Transforming  {
    override fun area(): Float = (side * side).toFloat()

    override fun resize(zoom: Int) {
        side *= zoom
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
        return "Square ($x, $y), side: $side"
    }
}
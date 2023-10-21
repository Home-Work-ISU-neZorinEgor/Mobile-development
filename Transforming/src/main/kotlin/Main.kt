fun main() {
    val array = arrayOf(Rect(2, 2, 4, 2), Square(2, 2, 4), Circle(2, 2, 5))
    for (fig in array) {
        println("Новый элемент: \n$fig")
        println("Поворот по часовой в точке 3,-3: ")
        fig.rotate(RotateDirection.Clockwise, 3, -3)
        println(fig)
        fig.rotate(RotateDirection.CounterClockwise, 3, -3)
        println("Вернулись на исходную: ${fig.x} ${fig.y}")
        println("Поворот против часовой в точке 3,-3")
        fig.rotate(RotateDirection.CounterClockwise, 3, -3)
        println(fig)

        print("Увеличить размер в 2 раза: ")
        fig.resize(2)
        println("$fig\n")
    }
}
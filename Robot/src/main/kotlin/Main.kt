class Main{

}

fun moveRobot(robot: Robot, toX: Int, toY: Int) {
    while (robot.x != toX || robot.y != toY) {
        // Вычисляем разницу между текущими координатами робота и целевыми координатами
        val deltaX = toX - robot.x
        val deltaY = toY - robot.y

        if (deltaX > 0) {
            // Робот должен двигаться вправо
            while (robot.direction != Direction.RIGHT) {
                robot.turnRight()
            }
            robot.stepForvard()
            println("Шаг вправо: $robot")
        } else if (deltaX < 0) {
            // Робот должен двигаться влево
            while (robot.direction != Direction.LEFT) {
                robot.turnLeft()
            }
            robot.stepForvard()
            println("Шаг влево: $robot")
        } else if (deltaY > 0) {
            // Робот должен двигаться вверх
            while (robot.direction != Direction.UP) {
                robot.turnRight()
            }
            robot.stepForvard()
            println("Шаг вверх: $robot")
        } else if (deltaY < 0) {
            // Робот должен двигаться вниз
            while (robot.direction != Direction.DOWN) {
                robot.turnLeft()
            }
            robot.stepForvard()
            println("Шаг вниз: $robot")
        }
    }
}

enum class Direction{
    UP, DOWN, LEFT, RIGHT
}

fun main() {
    val r = Robot(3, 4, Direction.DOWN)
    println("Начальная позиция: $r")

    moveRobot(r, 5, 2)

    println("Конечная позиция: $r")
}




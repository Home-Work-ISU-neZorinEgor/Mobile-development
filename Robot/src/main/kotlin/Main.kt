class Main{

}

fun moveRobot(robot: Robot, toX: Int, toY: Int){

}

enum class Direction{
 UP, DOWN, LEFT, RIGHT
}

fun main(){
    val r = Robot(3, 4, Direction.DOWN)
    println(r)
    r.stepForvard()
    println(r)
}
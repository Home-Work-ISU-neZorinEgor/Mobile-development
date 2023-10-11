class Robot(var x: Int, var y: Int, var direction: Direction) {

    fun stepForvard(){
        when (direction){
            Direction.DOWN -> y--
            Direction.UP -> y++
            Direction.LEFT -> x--
            Direction.RIGHT -> x++
        }
    }

    fun turnLeft(){
        when (direction){
            Direction.DOWN -> Direction.RIGHT
            Direction.UP -> Direction.LEFT
            Direction.LEFT -> Direction.DOWN
            Direction.RIGHT -> Direction.UP
        }
    }

    fun turnRight(){
        when (direction){
            Direction.DOWN -> Direction.LEFT
            Direction.UP -> Direction.RIGHT
            Direction.LEFT -> Direction.UP
            Direction.RIGHT -> Direction.DOWN
        }
    }

    override fun toString(): String{
        return "(x: ${x}, y: ${y}), looks ${direction}"
    }
}
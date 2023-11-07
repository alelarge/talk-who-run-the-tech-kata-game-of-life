data class Position(var x: Int, var y: Int)
class Grid(private val rows: Int, private val cols: Int) {
    fun hasNext() : Boolean {
        return true
    }

    fun getNeighbourPositions(position: Position, scale: Int): Set<Position> {
        return setOf()
    }
}
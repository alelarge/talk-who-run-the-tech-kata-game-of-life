class Grid(private val rows: Int, private val cols: Int) {
    fun hasNext() : Boolean {
        return true
    }

    fun getNeighbourPositions(position: Position, scale: Int): Set<Position> {
        return setOf(
            Position(0, 0), Position(0, 1), Position(0, 2),
            Position(1, 0), Position(1, 2),
            Position(2, 0), Position(2, 1), Position(2, 2)
        )
    }
}
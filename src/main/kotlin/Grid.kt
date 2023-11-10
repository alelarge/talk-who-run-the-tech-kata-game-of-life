class Grid( val rows: Int, val cols: Int) {
    private var currentPosition = Position(0, 0)
    private var isInitialized = false
    fun hasNext() : Boolean {
        return currentPosition.x < rows && currentPosition.y < cols
    }
    fun next(): Position {
        if (!isInitialized) {
            isInitialized = true
        }

        val position = currentPosition.copy()

        currentPosition.y++
        if (currentPosition.y == cols) {
            currentPosition.y = 0
            currentPosition.x++
        }
        return position
    }
    fun getNeighbourPositions(position: Position, scale: Int): Set<Position> {
        return setOf(-scale to -scale, 0 to -scale, scale to -scale, -scale to 0, scale to 0, -scale to scale, 0 to scale, scale to scale)
            .map { (dx, dy) ->
                val (x, y) = position
                Position(position.x + dx, position.y + dy)
            }
            .filter { (x,y) -> x>=0 && y>=0 && x<rows && y<cols}.toSet()
    }

    fun reset() {
        currentPosition = Position(0, 0)
        isInitialized = false
    }
}
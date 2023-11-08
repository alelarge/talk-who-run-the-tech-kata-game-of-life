class Cell (private var cellState: CellState) {
    private var state = cellState

    fun isAlive(): Boolean {
        return state == CellState.ALIVE
    }

    fun evolve(neighbours: List<Cell>) {
        val liveNeighbours = neighbours.count { it.state == CellState.ALIVE }
        state = when (state) {
            CellState.ALIVE -> {
                if (liveNeighbours < 2 || liveNeighbours > 3) {
                    CellState.DEAD
                } else {
                    CellState.ALIVE
                }
            }

            CellState.DEAD -> {
                if (liveNeighbours == 3) {
                    CellState.ALIVE
                } else {
                    CellState.DEAD
                }
            }
        }
    }
}
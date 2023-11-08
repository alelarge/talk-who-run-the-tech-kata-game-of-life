class Cell (private var cellState: CellState) {
    private var state = cellState

    fun isAlive() : Boolean {
        return state == CellState.ALIVE
    }

    fun evolve(neighbours: List<Cell>){
        val liveNeighbours = neighbours.count {it.state == CellState.ALIVE}
        if (liveNeighbours < 2) {
            state = CellState.DEAD
        }
    }
}
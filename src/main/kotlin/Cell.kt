class Cell (private var cellState: CellState) {
    private var state = cellState

    fun isAlive() : Boolean {
        if(state == CellState.ALIVE) {
            return true
        } else {
            return false
        }
    }
}
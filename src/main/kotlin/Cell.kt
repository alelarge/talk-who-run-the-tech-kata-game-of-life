enum class CellState{
    ALIVE
}

class Cell (private var cellState: CellState) {
    fun isAlive() : Boolean {
        return true
    }
}
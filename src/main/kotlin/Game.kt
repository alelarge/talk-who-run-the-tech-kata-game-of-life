class Game {
    constructor(
        grid: Grid,
        aliveCell: List<Position>
    ) {
        this.grid = grid
        this.aliveCell = aliveCell
    }

    private val grid: Grid
    private var aliveCell: List<Position>

    fun isOver() : Boolean {
        if (aliveCell.isEmpty()) {
            return true
        } else {
            return false
        }
    }
    fun play() {
        aliveCell = listOf()
    }

    fun getCellAtPosition(position: Position): Cell{
        if(aliveCell.contains(position)){
            return Cell(CellState.ALIVE)
        } else {
            return Cell(CellState.DEAD)
        }
    }


}
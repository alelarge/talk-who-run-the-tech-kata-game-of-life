import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellTest {
    @Test
    fun `cell dies when it has less than 2 live neighbours`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.DEAD), Cell(CellState.DEAD))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }
}
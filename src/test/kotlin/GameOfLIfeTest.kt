import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GridTest {
    @Test
    fun `initialized a 3x3 grid`(){
        val grid = Grid(3,3)
        assertThat(grid.hasNext()).isTrue
    }

    @Test
    fun `must return all positions of the neighbours of the cell at the center of the grid`() {
        // Given
        val grid = Grid(3, 3)
        val cellNeighbourPositions = grid.getNeighbourPositions(Position(1, 1), 1)

        // When
        val expectedNeighbours = setOf(
            Position(0, 0), Position(0, 1), Position(0, 2),
            Position(1, 0), Position(1, 2),
            Position(2, 0), Position(2, 1), Position(2, 2)
        )
        // Then
        assertThat(expectedNeighbours.toSet()).isEqualTo(cellNeighbourPositions.toSet())
    }

    @Test
    fun `must return all positions of the neighbours of the cell at bottom right`() {
        // Given
        val grid = Grid(3, 3)
        val cellNeighbourPositions = grid.getNeighbourPositions(Position(2, 2), 1)

        // When
        val expectedNeighbours = setOf(

                                  Position(1, 1), Position(1, 2),
                                  Position(2, 1)
        )
        // Then
        assertThat(expectedNeighbours.toSet()).isEqualTo(cellNeighbourPositions.toSet())
    }
}

class CellTest {
    @Test
    fun `cell should be alive when initialized as alive`(){
        val aliveCell = Cell(CellState.ALIVE)
        assertThat(aliveCell.isAlive()).isTrue
    }
    @Test
    fun `cell should be dead when initialized as dead`(){
        val aliveCell = Cell(CellState.DEAD)
        assertThat(aliveCell.isAlive()).isFalse
    }
    @Test
    fun `cell dies when it has less than 2 live neighbours`(){
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.DEAD), Cell(CellState.DEAD))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell dies when it has more than 3 live neighbours`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell stays alive when it has 3 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }
    @Test
    fun `cell stays alive when it has 2 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }
}

class GameOfLIfeTest{
    @Test
    fun `at the start of the game game of life, if I have no living cells then the game is over`(){
        val grid = Grid(3, 3)
        val game = Game(grid, emptyList<Position>())
        assertThat(game.isOver()).isTrue
    }

    @Test
    fun `at the beginning of the game game of life, if you have living cells, the game continues`(){
        val grid = Grid(3, 3)
        val game = Game(grid, listOf(Position(0,0)))
        assertThat(game.isOver()).isFalse
    }
    @Test
    fun`at the start of the game, if I have a living cell, then at the next turn, the game is over`(){
        //Given
        val grid = Grid(3, 3)
        val game = Game(grid, listOf(Position(0,0)))

        // When
        game.play()

        //Then
        assertThat(game.isOver()).isTrue
    }

    @Test
    fun `horizontal cells evolve into vertical cells in the next generation`() {
        //Given
        val grid = Grid(3, 3)
        val initialAliveCells = listOf(
            Position(1, 0), Position(1, 1), Position(1, 2)
        )
        //When
        val game = Game(grid, initialAliveCells)
        //Then

        assertThat(game.getCellAtPosition(Position(1, 0)).isAlive()).isTrue
        assertThat(game.getCellAtPosition(Position(1, 1)).isAlive()).isTrue
        assertThat(game.getCellAtPosition(Position(1, 2)).isAlive()).isTrue

        game.play()

        assertThat(game.getCellAtPosition(Position(0, 1)).isAlive()).isTrue
        assertThat(game.getCellAtPosition(Position(1, 1)).isAlive()).isTrue
        assertThat(game.getCellAtPosition(Position(2, 1)).isAlive()).isTrue
    }
}
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GridTest {
    @Test
    fun `initialized a 3x3 grid`(){
        val grid = Grid(3,3)
        assertThat(grid.hasNext()).isTrue
    }

    @Test
    fun `must return all positions of the neighbours of the cell`() {
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
}
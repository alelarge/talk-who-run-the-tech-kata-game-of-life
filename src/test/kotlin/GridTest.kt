import org.assertj.core.api.Assertions
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class GridTest {
    @Test
    fun `initialized a 3x3 grid`() {
        val grid = Grid(3, 5)
        assertThat(grid.rows).isEqualTo(3)
        assertThat(grid.cols).isEqualTo(5)
    }
}
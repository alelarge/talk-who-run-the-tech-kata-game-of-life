import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GridTest {
    @Test
    fun `initialized a 3x3 grid`(){
        val grid = Grid(3,3)
        assertThat(grid.hasNext()).isTrue
    }
}
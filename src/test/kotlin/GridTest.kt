import org.assertj.core.api.Assertions
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class GridTest {
    @Test
        fun `initialized a 3x3 grid`(){
            val grid = Grid(3, 3)
            Assertions.assertThat(grid.rows).isEqualTo(3)
            Assertions.assertThat(grid.cols).isEqualTo(3)
        }
}
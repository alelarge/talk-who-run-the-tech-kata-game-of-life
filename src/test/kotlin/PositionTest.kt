import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `create position`(){
        val position = Position(3,5)
        assertThat(position.x).isEqualTo(3)
        assertThat(position.y).isEqualTo(5)
    }
}
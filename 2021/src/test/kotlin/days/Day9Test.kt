package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.core.IsNull.notNullValue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day9Test {

    private val dayOne = Day9()

    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(15))
    }

    @Test
    fun testPartTwo() {
        assertThat(dayOne.partTwo(), `is`(1134))
    }
}

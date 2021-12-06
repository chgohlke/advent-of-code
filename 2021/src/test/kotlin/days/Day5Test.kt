package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.core.IsNull.notNullValue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day5Test {

    private val dayOne = Day5()

    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(5))
    }

    @Test
    fun testPartTwo() {
        assertThat(dayOne.partTwo(), `is`(0))
    }
}

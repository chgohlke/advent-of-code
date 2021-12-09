package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.core.IsNull.notNullValue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day8Test {

    private val dayOne = Day8()

    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(1))
    }

    @Test
    fun testPartTwo() {
        assertThat(dayOne.partTwo(), `is`(1))
    }
}

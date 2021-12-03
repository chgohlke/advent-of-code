package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.core.IsNull.notNullValue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day3Test {

    private val dayOne = Day3()

    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(198))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayOne.partTwo()
        assertThat(partTwo, notNullValue())
        assertThat(partTwo, instanceOf(Int::class.java))
        assertThat(partTwo, `is`(230))
    }
}

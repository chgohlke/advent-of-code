package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.core.IsNull.notNullValue
import org.junit.jupiter.api.Test

class Day2Test {

    private val dayOne = Day2()

    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(150))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayOne.partTwo()
        assertThat(partTwo, notNullValue())
        assertThat(partTwo, instanceOf(Int::class.java))
        assertThat(partTwo, `is`(900))
    }
}

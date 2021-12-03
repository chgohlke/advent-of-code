package util

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.IsIterableContainingInOrder.contains
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class UtilTests {

    @Test
    fun testReadInputAsString() {
        val testInputAsString = InputReader.getInputAsString(1)
        assertThat(testInputAsString, `is`("199\n200\n208\n210\n200\n207\n240\n269\n260\n263"))
    }

    @Test
    fun testReadInputAsList() {
        val testInputAsList = InputReader.getInputAsList(1)
        assertThat(testInputAsList, contains("199", "200", "208", "210", "200", "207", "240", "269", "260", "263"))
    }
}

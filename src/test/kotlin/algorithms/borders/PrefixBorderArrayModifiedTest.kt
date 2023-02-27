package algorithms.borders

import org.junit.Test

internal class PrefixBorderArrayModifiedTest {

    private val prefixBorderArrayModified = PrefixBorderArrayModified()
    private val string = "CACZZZCACA"
    private val bpm = arrayOf(0, 0, 1, 0, 0, 0, 0, 0, 3, 2)

    @Test
    fun testModifiedBorders() {
        val expectedResult = bpm

        val actualResult = prefixBorderArrayModified.execute(string)

        assert(expectedResult.contentEquals(actualResult))
    }

}
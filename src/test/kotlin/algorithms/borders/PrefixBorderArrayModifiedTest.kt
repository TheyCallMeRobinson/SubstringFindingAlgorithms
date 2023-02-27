package algorithms.borders

import org.junit.Test

internal class PrefixBorderArrayModifiedTest {

    private val prefixBorderArrayModified = PrefixBorderArrayModified()
    private val string1 = "CACZZZCACA"
    private val string2 = "ABXABZMABXABZ"
    private val bpm1 = arrayOf(0, 0, 1, 0, 0, 0, 0, 0, 3, 2)
    private val bpm2 = arrayOf(0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 6)

    @Test
    fun test1() {
        val expectedResult = bpm1

        val actualResult = prefixBorderArrayModified.execute(string1)

        assert(expectedResult.contentEquals(actualResult))
    }

    @Test
    fun test2() {
        val expectedResult = bpm2

        val actualResult = prefixBorderArrayModified.execute(string2)

        assert(expectedResult.contentEquals(actualResult))
    }

}
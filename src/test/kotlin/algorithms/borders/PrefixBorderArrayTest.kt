package algorithms.borders

import org.junit.Test

internal class PrefixBorderArrayTest {

    private val prefixBorderArray = PrefixBorderArray()

    @Test
    fun testLongString() {
        assert(isBorderArrayCorrect("abcacabcf", arrayOf(0, 0, 0, 1, 0, 1, 2, 3, 0)))
    }

    @Test
    fun testShortString() {
        assert(isBorderArrayCorrect("abcabc", arrayOf(0, 0, 0, 1, 2, 3)))
    }

    @Test
    fun testEmptyString() {
        assert(isBorderArrayCorrect("", emptyArray()))
    }

    private fun isBorderArrayCorrect(testString: String, expectedBorderArray: Array<Int>): Boolean {
        return expectedBorderArray.contentEquals(prefixBorderArray.execute(testString))
    }
}
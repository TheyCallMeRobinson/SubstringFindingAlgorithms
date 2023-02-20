package algorithms.stringmatch

import Position
import org.junit.Assert.*
import org.junit.Test

class KMPStringMatchTest {
    private val kmp = KMPStringMatch()
    private val string = "abcfdeabc"
    private val subString = "abc"

    @Test
    fun testString() {
        val expectedResult = listOf(Position(0), Position(6))

        val actualResult = kmp.execute(string, subString)

        assertEquals(actualResult, expectedResult)
    }
}
package algorithms.stringmatch

import Position
import org.junit.Assert
import org.junit.Test

class ShiftAndMatchTest {
    private val shiftAnd = ShiftAndMatch()
    private val string = "abcfdeabc"
    private val subString = "abc"

    @Test
    fun testString() {
        val expectedResult = listOf(Position(0), Position(6))

        val actualResult = shiftAnd.execute(string, subString)

        Assert.assertEquals(actualResult, expectedResult)
    }
}
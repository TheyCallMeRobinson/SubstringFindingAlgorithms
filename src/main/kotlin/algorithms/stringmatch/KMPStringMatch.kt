package algorithms.stringmatch

import Position
import algorithms.borders.PrefixBorderArray

class KMPStringMatch : StringMatchAlgorithm {

    private val borderFinder: PrefixBorderArray = PrefixBorderArray()

    override fun execute(baseString: String, substring: String): List<Position> {
        val borders = borderFinder.execute(substring)
        val positions = mutableListOf<Position>()

        var compareIndex = 0

        for (i in baseString.indices) {
            while (compareIndex > 0 && baseString[i] != substring[compareIndex]) {
                compareIndex = borders[compareIndex - 1]
            }

            if (baseString[i] == substring[compareIndex]) {
                compareIndex++
            }

            if (compareIndex == substring.length) {
                positions.add(Position(i - compareIndex + 1))
                compareIndex = borders[substring.length - 1]
            }
        }

        return positions
    }
}
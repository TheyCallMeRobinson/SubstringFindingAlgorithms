package algorithms

import Position
import StringMatchAlgorithm

class NaiveStringMatch : StringMatchAlgorithm{
    override fun execute(baseString: String, substring: String): List<Position> {
        val positions = mutableListOf<Position>()
        for (i in 0..baseString.length - substring.length) {
            var j = 0
            while (j < substring.length && baseString[i + j] == substring[j]) {
                j++
            }
            if (j == substring.length) {
                positions.add(Position(i))
            }
        }
        return positions
    }
}

package algorithms.stringmatch

import Position

class ShiftAndMatch : StringMatchAlgorithm {
    override fun execute(baseString: String, substring: String): List<Position> {
        val mapEntries = mutableMapOf<Char, Long>()
        val positionList = mutableListOf<Position>()

        for(i in 0..255) mapEntries[i.toChar()] = 0L
        for (i in substring.indices) mapEntries[substring[i]] = mapEntries[substring[i]]!! or (1L shl (substring.length - 1 - i))

        val uHigh = 1L shl (substring.length - 1)
        var mask = 0L

        for (i in baseString.indices) {
            val code = if (mapEntries[baseString[i]] == null) 0 else mapEntries[baseString[i]]
            mask = (mask shr 1 or uHigh) and code!!

            if (mask and 1 != 0L) {
                positionList.add(Position(i - substring.length + 1))
            }
        }
        return positionList
    }
}
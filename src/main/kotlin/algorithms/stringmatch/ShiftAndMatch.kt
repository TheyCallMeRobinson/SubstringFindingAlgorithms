package algorithms.stringmatch

import Position

class ShiftAndMatch : StringMatchAlgorithm{
    override fun execute(baseString: String, substring: String): List<Position> {
        val mapEntries = mutableMapOf<Char, Int>()
        val positionList = mutableListOf<Position>()

        for (i in substring.indices) {
            mapEntries[substring[i]] = 1 shl (substring.length - 1 - i)
        }

        val uHigh = 1 shl (substring.length - 1)
        var mask = 0

        for(i in baseString.indices) {
            val code = if(mapEntries[baseString[i]] == null) 0 else mapEntries[baseString[i]]
            mask = (mask shr 1 or uHigh) and code!!

            if(mask and 1 != 0) {
                positionList.add(Position(i - substring.length + 1))
            }
        }

        return positionList
    }
}
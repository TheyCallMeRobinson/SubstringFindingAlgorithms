package algorithms.borders

class PrefixBorderArrayModified(private val prefixBorderArray: PrefixBorderArray) {

    fun execute(baseString: String): Array<Int> {
        val stringLength = baseString.length
        val bpm = Array(stringLength) {0}
        val bp = prefixBorderArray.execute(baseString)
        bpm[stringLength - 1] = bp[stringLength - 1]

        for (i in 1 until stringLength - 1) {
            if (bp[i] != 0 && baseString[bp[i]] == baseString[i + 1]) {
                bpm[i] = bpm[bp[i] - 1]
            } else {
                bpm[i] = bp[i]
            }
        }

        return bpm
    }
}
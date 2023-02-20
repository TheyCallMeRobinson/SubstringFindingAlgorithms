package algorithms.borders

class PrefixBorderArrayNaive{

    fun execute(baseString: String): Array<Int> {
        val stringLength = baseString.length
        val bp = Array(stringLength) {0}
        for (i in 1 until stringLength) {
            var bpRight = bp[i - 1]
            while(bpRight != 0 && baseString[i] != baseString[bpRight]) {
                bpRight = bp[bpRight - 1]
            }
            if (baseString[i] == baseString[bpRight]) {
                bp[i] = bpRight + 1
            } else {
                bp[i] = 0
            }
        }
        return bp
    }
}
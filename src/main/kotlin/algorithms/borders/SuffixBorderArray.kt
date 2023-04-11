package algorithms.borders

fun createSuffixBorderArray(text: String): Array<Int> {
    val n = text.length
    val bs = Array(n){0}
    for(i in n - 1 downTo 0) {
        var bsLeft = bs[i+1] //Позиция с конца слева от предыдущей грани
        while (bsLeft != 0 && (text[i] != (text[n - bsLeft - 1]))) bsLeft = bs[n - bsLeft]

        if(text[i] == text[n - bsLeft - 1]) bs[i] = bsLeft + 1
        else bs[i] = 0
    }
    return bs
}
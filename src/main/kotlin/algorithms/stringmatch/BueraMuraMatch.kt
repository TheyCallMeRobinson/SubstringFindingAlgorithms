package algorithms.stringmatch

import Position


class BueraMuraMatch: StringMatchAlgorithm {
    override fun execute(baseString: String, substring: String): List<Position> {
        val list = mutableListOf<Position>()
        val posMap: HashMap<Char, ArrayList<Int>> = positionMap(substring)
        val m: Int = substring.length
        val n: Int = baseString.length
        // Поиск вхождений
        // Правая граница «прикладывания» образца
        // (символ в тексте, следующий за тем, который будет сравнен)
        // Поиск вхождений
        // Правая граница «прикладывания» образца
        // (символ в тексте, следующий за тем, который будет сравнен)
        var nTextR = m
        // Сравнение образца с текстом справа налево
        while (nTextR <= n) {
            var k = m - 1
            var i = nTextR - 1
            while (k >= 0) {
                if (substring[k] != baseString[i]) {
                    // text[i] – плохой символ
                    break
                }
                k--
                i--
            }
            // Результаты сравнения
            if (k < 0) {
                list.add(Position(i + 1))
            }
            // Продвижение по правилу
            nTextR += badCharShift(posMap, baseString, i, k)
        }
        return list
    }

    private fun positionMap(pattern: String): HashMap<Char, ArrayList<Int>> {
        val m = pattern.length
        val posList = HashMap<Char, ArrayList<Int>>()
        for (k in m - 1 downTo 0) {
            if (!posList.containsKey(pattern[k])) {
                posList[pattern[k]] = ArrayList()
            }
            posList[pattern[k]]!!.add(k)
        }
        return posList
    }

    fun badCharShift(
        posMap: HashMap<Char, ArrayList<Int>>,
        text: String,
        textBadCharPos: Int,
        patternBadCharPos: Int,
    ): Int {
        if (patternBadCharPos < 0 || textBadCharPos < 0) {
            // Образец совпал – сдвиг на 1
            return 1
        }
        var nPos = -1 // Искомая позиция слева от плохого символа
        // Список позиций данного символа textBadCharPos (на каких индексах встречается этот символ textBadCharPos)
        val posList: List<Int>? = posMap[text[textBadCharPos]]
        // Список не пуст
        if (!posList.isNullOrEmpty()) {
            // Длина списка
            val nLen = posList.size
            // Ищем элемент, меньший чем плохая позиция
            for (k in 0 until nLen) {
                if (posList[k] < patternBadCharPos) {
                    nPos = posList[k]
                    break
                }
            }
        }
        return patternBadCharPos - nPos
    }
}
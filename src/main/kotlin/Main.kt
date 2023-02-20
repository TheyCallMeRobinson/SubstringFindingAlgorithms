import algorithms.borders.PrefixBorderArray
import algorithms.stringmatch.NaiveStringMatch
import algorithms.stringmatch.StringMatchAlgorithm
import java.util.Scanner

fun String.indexOfStringMatch(substring: String, algorithm: StringMatchAlgorithm = NaiveStringMatch()): List<Position> {
    return algorithm.execute(this, substring)
}

fun String.getBorderShiftArray(algorithm: PrefixBorderArray = PrefixBorderArray()): Array<Int> {
    return algorithm.execute(this)
}

fun Scanner.nextLine(precedingString: String): String {
    println(precedingString)
    return next()
}

fun naiveStringMatchOutput(scanner: Scanner) {
    val inputBaseString = scanner.nextLine(precedingString = "Input base string: ")
    val inputSubstring = scanner.nextLine(precedingString = "Input substring: ")
    val positions = inputBaseString.indexOfStringMatch(inputSubstring)
    for (i in positions) {
        println(i)
    }
}

fun prefixBorderArrayOutput(scanner: Scanner) {
    val inputString = scanner.nextLine(precedingString = "Input string: ")
    val array = inputString.getBorderShiftArray()
    for (i in array) {
        println(i)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    prefixBorderArrayOutput(scanner)
}
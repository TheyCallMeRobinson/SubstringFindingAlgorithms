import algorithms.NaiveStringMatch
import java.util.Scanner

fun String.indexOf(substring: String, algorithm: StringMatchAlgorithm = NaiveStringMatch()): List<Position> {
    return algorithm.execute(this, substring)
}

fun Scanner.nextLine(precedingString: String): String {
    println(precedingString)
    return next()
}

fun main() {
    val scanner = Scanner(System.`in`)
    val inputBaseString = scanner.nextLine(precedingString = "Input base string: ")
    val inputSubstring = scanner.nextLine(precedingString = "Input substring: ")
    val positions = inputBaseString.indexOf(inputSubstring)
    for (i in positions) {
        println(i)
    }
}
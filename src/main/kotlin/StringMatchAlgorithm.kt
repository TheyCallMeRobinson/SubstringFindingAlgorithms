interface StringMatchAlgorithm {
    fun execute(baseString: String, substring: String): List<Position>
}
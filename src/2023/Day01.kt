fun main() {
    val strings = readInput("Day01")

    val partOneSum = strings.sumOf { line ->
        val first = line.first { it.isDigit() }
        val last = line.last { it.isDigit() }
        "$first$last".toInt()
    }
    println("Part 1 answer: $partOneSum")

    val partTwoSum = strings.sumOf { string ->
        val firstValue = getDigit(string, true)
        val secondValue = getDigit(string, false)
        "$firstValue$secondValue".toInt()
    }
    println("Part 2 answer: $partTwoSum")
}

val wordToDigit = mapOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9"
)

private fun getDigit(string: String, isFirst: Boolean): String {
    val wordIndexPair = if (isFirst) {
        string.findAnyOf(wordToDigit.keys)
    } else {
        string.findLastAnyOf(wordToDigit.keys)
    } ?: (Int.MAX_VALUE to "")

    val digitIndexPair = if (isFirst) {
        string.findAnyOf(wordToDigit.values)
    } else {
        string.findLastAnyOf(wordToDigit.values)
    } ?: (Int.MAX_VALUE to "")

    return when {
        (isFirst && wordIndexPair.first <= digitIndexPair.first) || (!isFirst && wordIndexPair.first >= digitIndexPair.first) -> wordToDigit[wordIndexPair.second]
            ?: digitIndexPair.second

        else -> digitIndexPair.second
    }
}

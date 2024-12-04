fun main() {
    fun part1(input: String) = input.fold(0) { acc, c -> acc + if (c == '(') 1 else if (c == ')') -1 else 0 }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01")
    part1(input).println()
    //part2(input).println()
}

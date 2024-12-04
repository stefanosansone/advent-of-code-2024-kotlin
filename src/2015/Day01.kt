package `2015`

import println
import readInput

fun main() {
    fun part1(input: String) = input.fold(0) { acc, c -> acc + if (c == '(') 1 else if (c == ')') -1 else 0 }

    fun part2(input: String): Int {
        var floor = 0
        return input.indexOfFirst {
            floor += if (it == '(') 1 else -1
            floor < 0
        } + 1
    }

    val input = readInput("2015","Day01")
    part1(input).println()
    part2(input).println()
}

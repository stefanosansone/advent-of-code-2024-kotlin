package `2024`

import println
import readLines
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

fun main() {
    fun parseInput(input: List<String>): Pair<List<Int>, List<Int>> {
        val pairs = input
            .map { it.trim().split("\\s+".toRegex()).map(String::toInt) }
            .map { it[0] to it[1] }
        return pairs.unzip()
    }

    fun part1(input: List<String>): Int {
        val (list1, list2) = parseInput(input)
        val sortedList1 = list1.sorted()
        val sortedList2 = list2.sorted()
        return sortedList1.zip(sortedList2).sumOf { (a, b) -> (a - b).absoluteValue }
    }

    fun part2(input: List<String>): Int {
        val (list1, list2) = parseInput(input)
        return list1.sumOf { num -> list2.count { it == num } * num }
    }

    val input = readLines("2024", "Day01")
    part1(input).println()
    part2(input).println()
}

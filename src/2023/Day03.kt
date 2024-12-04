fun main() {
    val lines = readInput("Day03")
    val parts = mapEngineParts(lines)

    println("Part 1 answer: " + parts.values.sumOf { it.sum() })
    println("Part 2 answer: " + parts.values.sumOf { if (it.size == 2) it[0] * it[1] else 0 })
}

fun mapEngineParts(lines: List<String>): Map<Pair<Int, Int>, MutableList<Int>> = buildMap {
    for ((y, line) in lines.withIndex()) {
        val numberPositions = findNumberPositions(line)
        for ((number, start, end) in numberPositions) {
            for (y2 in (y - 1).coerceAtLeast(0)..(y + 1).coerceAtMost(lines.lastIndex)) {
                val line2 = lines[y2]
                val x0 = start - 1
                val x1 = end + 1
                for (x in x0.coerceAtLeast(0)..x1.coerceAtMost(line2.lastIndex)) {
                    if (!line2[x].isDigit() && line2[x] != '.') {
                        getOrPut(x to y2) { mutableListOf() } += number
                    }
                }
            }
        }
    }
}

fun findNumberPositions(line: String): List<Triple<Int, Int, Int>> {
    val numberPositions = mutableListOf<Triple<Int, Int, Int>>()
    var currentNumber = StringBuilder()
    var startIndex = -1

    for ((index, char) in line.withIndex()) {
        if (char.isDigit()) {
            if (currentNumber.isEmpty()) {
                startIndex = index
            }
            currentNumber.append(char)
        } else if (currentNumber.isNotEmpty()) {
            numberPositions.add(Triple(currentNumber.toString().toInt(), startIndex, index - 1))
            currentNumber = StringBuilder()
        }
    }

    if (currentNumber.isNotEmpty()) {
        numberPositions.add(Triple(currentNumber.toString().toInt(), startIndex, line.length - 1))
    }

    return numberPositions
}

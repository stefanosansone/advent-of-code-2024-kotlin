fun main() {
    val games = readInput("Day02")

    val validGamesSum = games.sumOf { game -> getValidGameId(game) }
    println("Part 1 answer: $validGamesSum")

    val power = games.sumOf { game -> getPowerForGame(game) }
    println("Part 2 answer: $power")
}

val cubesLimit = mapOf(
    "red" to 12, "green" to 13, "blue" to 14
)

val cubesPower = mutableMapOf<String, Int>()

fun getValidGameId(game: String): Int {
    game.parseGameSets().forEach { (color, count) ->
        if (count > (cubesLimit[color] ?: 0)) return 0
    }
    return game.substringBefore(":").filter { it.isDigit() }.toInt()
}

// Works with any number of different colors
fun getPowerForGame(game: String): Int {
    game.parseGameSets().forEach { (color, count) ->
        cubesPower[color] = maxOf(cubesPower.getOrDefault(color, 0), count)
    }
    return cubesPower.values.fold(1) { acc, value -> acc * value }.also { cubesPower.clear() }
}

fun String.parseGameSets(): List<Pair<String, Int>> = split(":").last().split(";").flatMap { set ->
        set.split(",").map { cubes ->
            val color = cubes.filter { it.isLetter() }
            val count = cubes.filter { it.isDigit() }.toInt()
            color to count
        }
    }

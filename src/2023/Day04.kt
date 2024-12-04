fun main() {
    val cards = readInput("Day04")

    val cardsInfo = buildList {
        cards.forEach { card ->
            val (winningNumbers, myNumbers) = card.split(":").last().split("|").map {
                    it.trim().split(" ").filter { number ->
                        number.isNotEmpty()
                    }.map(String::toInt)
                }

            val count = winningNumbers.count { it in myNumbers }
            add(Pair(count, 1))
        }
    }.toMutableList()

    cardsInfo.forEachIndexed { index, pair ->
        (index + 1 until index + pair.first + 1).forEach { i ->
            cardsInfo[i] = cardsInfo[i].copy(second = cardsInfo[i].second + pair.second)
        }
    }

    println("Part 1 answer: ${cardsInfo.sumOf { (count, _) -> if (count == 0) 0 else 1 shl (count - 1) }}")
    println("Part 2 answer: ${cardsInfo.sumOf { it.second }}")
}

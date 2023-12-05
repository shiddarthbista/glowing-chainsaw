import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            (2.0.pow(it.matchingNumbers().toDouble())/2.0).toInt()
        }
    }

    fun part2(input: List<String>): Int {
        val scratchcardsCount = mutableMapOf<Int, Int>().withDefault { 1 }
        scratchcardsCount[1] = 1

        input.map {
            val game = it.substringBefore(":").split(" ").last().toInt()

            val matches = it.matchingNumbers()
            if (matches == 0){
                scratchcardsCount.putIfAbsent(game,1)
            }
            for (i in  1 ..matches){
                for(j in 1..scratchcardsCount.getValue(game)) {
                    scratchcardsCount[i + game] = (scratchcardsCount.getValue(i + game) + 1)
                }
            }
        }
        return scratchcardsCount.values.sum()
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 13)
    check(part2(testInput) == 30)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()

}

fun String.matchingNumbers(): Int {
    val scores = this.substringAfter(":")
    val (winning, player) = scores.split("|")
    val winningList = winning.split(" ").filter { it.isNotEmpty() }
    val playerList = player.split(" ").filter { it.isNotEmpty() }
    return playerList.intersect(winningList.toSet()).size
}
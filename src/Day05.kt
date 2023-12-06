fun main() {
    fun part1(input: List<String>): Int {
        val seeds = input[0].substringAfter(": ").split(" ").map { it.toLong() }
        val mapRanges = input.drop(2).map { it.split(" /n") }
        println(mapRanges)
        println(seeds)

        return 1
    }

    fun part2(input: List<String>): Int {
        return 1
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
//    check(part1(testInput) == 1)
//    check(part2(testInput) == 1)

    val input = readInput("Day05")
    part1(testInput).println()
    part2(input).println()
}



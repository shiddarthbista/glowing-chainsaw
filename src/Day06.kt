fun main() {
    fun part1(input: List<String>): Int {
        val racePoints = input.map { lines ->
            lines.split(":").last().split(" ")
                .filter { it.isNotBlank() }
                .map { it.toInt() } }
        val race = racePoints[0].zip(racePoints[1])

        return race.map {(time,distance) ->
            (0..time).map{
                it * (time - it)
            }.count { it > distance  }
        }.reduce { acc, i -> acc * i }
    }

    fun part2(input: List<String>): Int {
        val racePoints2 = input.map { lines ->
            lines.split(":").last().split(" ")
                .filter { it.isNotBlank() }
                .joinToString("").toLong()
        }

        val time = racePoints2.first()
        val distance = racePoints2.last()
        
        return(0..time).count {buttonTimePress ->
            val distanceTravelled = (buttonTimePress * (time-buttonTimePress))
            distanceTravelled > distance
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 288)
    check(part2(testInput) == 71503)

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}



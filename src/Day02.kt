fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val (game, balls) = it.split(":")
            var gameId = game.substringAfter(" ").toInt()

            val sets = balls.split(";").map { it.trim() }

            for (set in sets) {
                val pulledBalls = set.split(",").map { it.trim() }

                for (ball in pulledBalls) {
                    val (count, color) = ball.split(" ")

                    if ((color == "red" && count.toInt() > 12) || (color == "green" && count.toInt() > 13) || (color == "blue" && count.toInt() > 14)) {
                        gameId = 0
                    }
                }
            }
            gameId
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            var redBalls = 0
            var blueBalls = 0
            var greenBalls = 0
            val balls = it.substringAfter(":")
            val sets = balls.split(";").map { it.trim() }
            val colors = mutableMapOf<String, Int>()



            for (set in sets) {
                val pulledBalls = set.split(",").map { it.trim() }

                for (ball in pulledBalls) {
                    val (count, color) = ball.split(" ")

                    when (color) {
                        "red" -> if (count.toInt() > redBalls) {
                            redBalls = count.toInt()
                        }

                        "blue" -> if (count.toInt() > blueBalls) {
                            blueBalls = count.toInt()
                        }

                        "green" -> if (count.toInt() > greenBalls) {
                            greenBalls = count.toInt()
                        }

                    }
                }

            }
            redBalls * greenBalls * blueBalls
        }
    }


        // test if implementation meets criteria from the description, like:
        val testInput = readInput("Day02_test")
        check(part1(testInput) == 8)
        check(part2(testInput) == 2286)

        val input = readInput("Day02")
        part1(input).println()
        part2(input).println()
    }



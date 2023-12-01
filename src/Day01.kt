fun main() {
    fun part1(input: String): Int {
        return input.split(" ").sumOf { it ->
            val first = it.first { it.isDigit() }.digitToInt()
            val last = it.last { it.isDigit() }.digitToInt()
            first * 10 + last
        }
    }

    fun part2(input: String): Int {
        fun convertWordToNumber(input: String): String {
            val wordToNumberMap = mapOf(
                    "zero" to "0",
                    "one" to "1",
                    "two" to "2",
                    "three" to "3",
                    "four" to "4",
                    "five" to "5",
                    "six" to "6",
                    "seven" to "7",
                    "eight" to "8",
                    "nine" to "9"
            )

            var result = input
            for ((word, number) in wordToNumberMap) {
                result = result.replace(word, "${word[0]}$number${word[word.length-1]}")
            }

            return result
        }

            val transformedList = input.split(" ").map { it: String ->
                println(it)
                convertWordToNumber(it)
            }

            println(transformedList)

            return transformedList.sumOf { it ->
                val first = it.first { it.isDigit() }.digitToInt()
                val last = it.last { it.isDigit() }.digitToInt()
                first * 10 + last
            }
        }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
     check(part2(testInput.toString()) == 281)

    val input = readInput("Day01").toString()
    part2(input).println()
   // part2(input).println()
}

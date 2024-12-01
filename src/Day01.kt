import kotlin.math.abs

fun main() {
    // watched the aoc livestream and learned some new standard library things like unzip/zip
    // https://www.youtube.com/live/r7nMRJ57QA0?si=_I_6ORkQmiJMBbBN
    // Super Impressed with
    //Returns a pair of lists, where first list is built from the first values of each pair from this collection,
    //second list is built from the second values of each pair from this collection.

    // Medium article on use of zip and unzip - https://medium.com/@ajunior.em/kotlin-and-the-zip-unzip-3629894e64f4

    fun part1(input: List<String>): Int {

        val (left, right) = prepLists(input)

        val result = left.sorted().zip(right.sorted()).sumOf { (first, second) ->
            abs(first - second)
        }

        return result
    }

    fun part2(input: List<String>): Int {
        val (left, right) = prepLists(input)

        val frequencies: Map<Int,Int> = right.groupingBy { it }.eachCount()

        // article on Fold vs Reduce -  https://www.baeldung.com/kotlin/fold-vs-reduce
        return left.fold( 0 ) { acc, num ->
            acc + num * frequencies.getOrDefault(num, 0)
        }
    }


    // Read the input from the `src/day01.txt` file.
    val input = readInput("day01")
    part1(input).println()
    part2(input).println()
}

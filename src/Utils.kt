import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(filename: String) : List<String> = Path("src/$filename.txt").readText().trim().lines()

fun prepLists(input: List<String>) : Pair<List<Int>, List<Int>> {
    val (left, right) = input.map { line:String  ->
        val first = line.substringBefore(" ").toInt()
        val second = line.substringAfterLast(" ").toInt()
        first to second
    }.unzip()
    return Pair(left,right)
}
/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

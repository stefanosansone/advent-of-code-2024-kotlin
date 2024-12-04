import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file in the specified folder under "src".
 */
fun readLines(subfolder: String, name: String): List<String> {
    return Path("src/$subfolder/$name.txt").readText().trim().lines()
}

/**
 * Reads the content of the given input txt file in the specified folder under "src".
 */
fun readInput(subfolder: String, name: String): String {
    return Path("src/$subfolder/$name.txt").readText()
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

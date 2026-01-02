/*
 * Time: O(n)
 * Reason: Build a cleaned string and reverse it.
 *
 * Space: O(n)
 * Reason: Extra string is used.
 *
 * Extra => uses internal fun to reverse
 */
fun isPalindromeBruteForce(s: String): Boolean {
    val updatedString = StringBuilder()
    for (i in 0..s.length - 1) {
        if (s[i].isLetterOrDigit()){
            updatedString.append(s[i].lowercaseChar())
        }
    }

    val original = updatedString.toString()
    val reversed = original.reversed()

    return original == reversed
}

/*
 * Time: O(n)
 * Reason: Each character is checked once.
 *
 * Space: O(1)
 * Reason: No extra space used.
 */
fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    while (start <= end) {
        if (!s[start].isLetterOrDigit()) {
            start++
            continue
        }
        if (!s[end].isLetterOrDigit()) {
            end--
            continue
        }
        if (s[start].lowercaseChar() != s[end].lowercaseChar()) {
            return false
        }
        start++
        end--
    }
    return true
}

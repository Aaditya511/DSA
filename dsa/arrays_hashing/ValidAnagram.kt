
/*
 * Time Complexity: O(n log n)
 * Reason: Sorting both strings.
 *
 * Space Complexity: O(n)
 * Reason: toCharArray() + sorted() create new collections.
 */
fun validAnagramBruteForce(s: String, t: String): Boolean {
    return s.toCharArray().sorted() == t.toCharArray().sorted()
}

/*
 * Time Complexity: O(n)
 * Reason: Single pass over both strings.
 *
 * Space Complexity: O(n)
 * Reason: Map stores character frequencies.
 */

fun validAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val map = mutableMapOf<Char, Int>()
    for (i in 0..s.length - 1) {
        map[s[i]] = map.getOrDefault(s[i], 0) + 1
        map[t[i]] = map.getOrDefault(t[i], 0) - 1
    }
    map.values.forEach {
        if (it != 0) return false
    }
    return true
}

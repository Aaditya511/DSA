/*
 * Time Complexity: O(n * k log k)
 * Reason: For each string (n), sorting characters takes O(k log k),
 * where k is the average length of a string.
 *
 * Space Complexity: O(n * k)
 * Reason: Sorted strings are used as keys and stored in the HashMap.
 */
fun groupAnagramsBruteForce(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    for (i in 0..strs.size - 1) {
        val actualWord = strs[i]
        val sortedWord = strs[i].toCharArray().sorted().joinToString()
        map.getOrPut(sortedWord) { mutableListOf() }.add(actualWord)
    }
    return map.values.toList()
}

/*
 * Time Complexity: O(n * k)
 * Reason: For each string (n), character frequency counting takes O(k).
 *
 * Space Complexity: O(n)
 * Reason: Map stores frequency signature for each word.
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    for (i in 0..strs.size - 1) {
        val actualWord = strs[i]
        val countCharArr = IntArray(26) { 0 }
        for (j in 0..actualWord.length - 1) {
            countCharArr[actualWord[j] -'a']++
        }
       map.getOrPut(countCharArr.joinToString()){mutableListOf()}.add(actualWord)

    }
    return map.values.toList()
}

/**
 * Problem: Contains Duplicate
 *
 * -----------------------------
 * Approach 1: Brute Force
 * -----------------------------
 * Compare every element with every other element.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
fun containsDuplicateBrutrForce(arr: IntArray): Boolean {
    for (i in 0..arr.size - 1) {
        for (j in 0..arr.size - 1) {
            if (i != j && arr[i] == arr[j]) return true
        }
    }
    return false
}

/**
 * Approach 2: Optimise (Map)
 * Store frequency of elements.
 * If any element appears more than once, return true.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

fun containsDuplicate(arr: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    for (i in 0..arr.size - 1) {
        map[arr[i]] = map.getOrDefault(arr[i], 0) + 1
        if (map[arr[i]]!! > 1) return true
    }
    return false
}




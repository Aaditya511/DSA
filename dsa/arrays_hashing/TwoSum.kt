
/*
 * Time Complexity: O(n²)
 * Reason: Nested loops check all possible pairs.
 *
 * Space Complexity: O(1)
 * Reason: No extra data structure is used.
 */
fun twoSumBruteForce(arr: IntArray, target: Int): IntArray {
    for (i in arr.indices) {
        for (j in arr.indices) {
            if (i != j && arr[i] + arr[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

/*
 * Time Complexity: O(n)
 * Reason: Single pass using HashMap lookup.
 *
 * Space Complexity: O(n)
 * Reason: HashMap stores previously seen elements.
 */
fun twoSum(arr: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    for (i in arr.indices) {
        val searchingNum = target - arr[i]
        if (map.containsKey(searchingNum)){
            return intArrayOf(map[searchingNum]!!,i)
        }
        map[arr[i]] = i
    }
    return intArrayOf()
}
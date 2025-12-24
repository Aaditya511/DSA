
/*
 * Time Complexity: O(n log n)
 * Reason: Frequency map creation takes O(n),
 *         sorting map entries by frequency takes O(n log n).
 *
 * Space Complexity: O(n)
 * Reason: HashMap and sorted list store up to n elements.
 */
fun topKFrequentBruteForce(arr: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in arr.indices) {
        map[arr[i]] = map.getOrDefault(arr[i], 0) + 1
    }
    val sortedList = map.entries.sortedByDescending { it.value }
    val ans = IntArray(k)
    for (i in 0..k - 1) {
        ans[i] = sortedList[i].key
    }
    return ans
}

/*
 * Time Complexity: O(n)
 * Reason:
 * - First loop counts frequency of each element.
 * - Second loop places elements into buckets based on frequency.
 * - Third loop scans buckets from highest to lowest to get top K.
 *
 * Space Complexity: O(n)
 * Reason:
 * - Map stores frequency of each element.
 * - Bucket array stores elements grouped by frequency.
 */
fun topKFrequent(arr: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in arr.indices) {
        map[arr[i]] = map.getOrDefault(arr[i], 0) + 1
    }
    val list = Array(arr.size + 1) { mutableListOf<Int>() }

    map.forEach { (key, value) ->
        list[value].add(key)
    }
    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        val innerList = list[i]
        for (j in innerList.size - 1 downTo 0) {
            if (result.size != k){
                result.add(innerList[j])
            }
        }
    }

    return result.toIntArray()
}

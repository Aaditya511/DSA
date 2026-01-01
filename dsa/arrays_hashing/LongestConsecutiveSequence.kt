/*
 * Time Complexity: O(n log n)
 * Reason: Converting to Set and sorting the elements dominates the time.
 *
 * Space Complexity: O(n)
 * Reason: Extra space is used for Set and sorted list.
 */
fun longestConsecutiveBruteForce(arr: IntArray = intArrayOf(2, 20, 4, 10, 3, 4, 5)): Int {
    val list = arr.toSet().sorted()
    var currentAns = 1
    var maxAns = 1
    for (i in 0..list.size - 2) {
        if (list[i + 1] == list[i] + 1) {
            currentAns++
        } else {
            currentAns = 1
        }
        maxAns = maxOf(currentAns, maxAns)
    }
    return maxAns
}


/*
 * Time Complexity: O(n)
 * Reason: Each number is processed only once across all sequences.
 *
 * Space Complexity: O(n)
 * Reason: HashMap and recursion stack use extra space.
 */
fun longestConsecutive(arr: IntArray = intArrayOf(100, 4, 200, 1, 3, 2)): Int {
    if (arr.isEmpty()) return 0

    val map = mutableMapOf<Int, Boolean>()

    for (i in 0..arr.size - 1) {
        map[arr[i]] = true
    }

    for (i in 0..arr.size - 1) {
        if (map.containsKey(arr[i] - 1)) {
            map[arr[i]] = false
        }
    }

    var maxAns = 1

    for (i in 0..arr.size - 1) {
        val currentNumber = arr[i]
        if (map[currentNumber] == true) {
            val ans = countNext(currentNumber, map)
            maxAns = maxOf(maxAns, ans)
        }
    }

    return maxAns
}

private fun countNext(currentNumber: Int, map: Map<Int, Boolean>): Int {
    val nextNumber = currentNumber + 1

    if (!map.containsKey(nextNumber)) {
        return 1
    }

    return 1 + countNext(nextNumber, map)
}



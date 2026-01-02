

fun twoSumTwoPointer(array: IntArray, target: Int): IntArray {
    var start = 0
    var end = array.size - 1
    val ans = IntArray(2)
    while (start < end) {
        val sum = array[start] + array[end]
        if (sum > target) {
            end--
        } else if (sum < target) {
            start++
        } else {
            ans[0] = start
            ans[1] = end
            break
        }
    }
    return ans
}


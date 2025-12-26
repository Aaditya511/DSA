/*
 * Time Complexity: O(n²)
 * Reason: Nested loops check all .
 *
 * Space Complexity: O(1)
 * Reason: No extra data structure is used.
 */
fun productExceptSelfBruteForce(array: IntArray): IntArray {
    val ans = IntArray(array.size)
    for (i in 0..array.size - 1) {
        var product = 1
        for (j in 0..array.size - 1) {
            if (i != j) {
                product *= array[j]
            }
        }
        ans[i] = product
    }
    return ans
}

/*
 * Time Complexity: O(n)
 * Reason: No Nested loop used .
 *
 * Space Complexity: O(n) also(3n)
 * Reason:Creating Prefix sufix array
 */
fun productExceptSelf(array: IntArray): IntArray {
    val prefixProduct = IntArray(array.size)
    val suffixProduct = IntArray(array.size)
    val ansArray = IntArray(array.size)
    prefixProduct[0] = 1
    for (i in 1..array.size - 1) {
        prefixProduct[i] = prefixProduct[i - 1] * array[i - 1]
    }
    suffixProduct[array.size - 1] = 1
    for (i in array.size - 2 downTo 0) {
        suffixProduct[i] = array[i +1] * suffixProduct[i+1]
    }
    for (i in 0..array.size-1){
        ansArray[i] = prefixProduct[i]* suffixProduct[i]
    }
    return ansArray

}

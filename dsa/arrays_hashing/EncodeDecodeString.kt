
/*
 * Time Complexity: O(n)
 * Reason: Single pass.
 *
 * Space Complexity: O(1)
 * Reason: Creating list in decode fun
 */

fun encode(strs: List<String>): String {
    val word = StringBuilder()
    for (i in 0..strs.size-1){
        word.append(strs[i]).append('#')
    }
    return word.toString()
}

fun decode(str: String): List<String> {
    val word = StringBuilder()
    val list = mutableListOf<String>()
    for (i in 0..str.length - 1) {
        if (str[i] != '#') {
            word.append(str[i])
        } else {
            list.add(word.toString())
            word.clear()
        }
    }
    return list
}

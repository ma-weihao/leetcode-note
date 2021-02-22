package top.wello.leetcode

private fun largeGroupPositions(s: String): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    var size = 1
    for (i in s.indices) {
        if (i >= s.length - 1 || s[i + 1] != s[i]) {
            if (size > 2) {
                res.add(listOf(i - size + 1, i))
            }
            size = 1
        } else {
            size++
        }
    }
    return res
}

fun main() {
    println(largeGroupPositions("abcdddeeeeaabbbcd"))
}
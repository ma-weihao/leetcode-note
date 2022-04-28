package top.wello.leetcode

// 455. 分发饼干
private fun findContentChildren(g: IntArray, s: IntArray): Int {
    var count = 0
    g.sort()
    s.sort()
    var i = 0
    var j = 0
    while (i < g.size && j < s.size) {
        while (j < s.size && g[i] > s[j]) {
            j++
        }
        if (j < s.size) {
            count++
        }
        i++
        j++
    }
    return count
}

fun main() {
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}
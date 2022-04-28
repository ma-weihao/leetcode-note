package top.wello.leetcode

import java.util.*
import kotlin.Pair

/**
 * Created by maweihao on 12/28/20
 */
internal class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        Arrays.sort(g)
        Arrays.sort(s)
        val numOfChildren = g.size
        val numOfCookies = s.size
        var count = 0
        var i = 0
        var j = 0
        while (i < numOfChildren && j < numOfCookies) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++
            }
            if (j < numOfCookies) {
                count++
            }
            i++
            j++
        }
        return count
    }
}

public data class Pair<out A, out B>(
    public val first: A,
    public val second: B
) {

    /**
     * Returns string representation of the [Pair] including its [first] and [second] values.
     */
    public override fun toString(): String = "($first, $second)"
}
package top.wello.leetcode

// 205. 同构字符串

fun isIsomorphic(s: String, t: String): Boolean {
    val maps = mutableMapOf<Char, Char>()
    val mapt = mutableMapOf<Char, Char>()

    for (i in s.indices) {
        val sc = s[i]
        val tc = t[i]
        if (maps[sc] != null && maps[sc] != tc || mapt[tc] != null && mapt[tc] != sc) {
            return false
        }
        maps[sc] = tc
        mapt[tc] = sc
    }
    return true
}

fun main() {
    println(isIsomorphic("ab", "aa"))
    println(isIsomorphic("foo", "bar"))
    println(isIsomorphic("paper", "title"))
}


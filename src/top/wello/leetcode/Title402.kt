package top.wello.leetcode

import java.util.*

// 402 移掉 k 位数字

fun removeKdigits(num: String, kk: Int): String {
    var k = kk
    val stack = LinkedList<Char>()
    for (s in num) {
        while (stack.isNotEmpty() && k > 0 && stack.peekLast() > s) {
            stack.pollLast()
            k--
        }
        stack.offerLast(s)
    }
    repeat(k) {
        stack.pollLast()
    }
    while (stack.peekFirst() == '0') {
        stack.pollFirst()
    }
    var sb = StringBuilder()
    // leetcode bug
    for (c in stack) {
        sb.append(c)
    }
    var str = sb.toString()
    if (str.isEmpty()) {
        str = "0"
    }
    return str
}

fun main() {
    println(removeKdigits("1432219", 3))
    println(removeKdigits("10200", 1))
    println(removeKdigits("10", 2))
}
package top.wello.leetcode

import java.util.*

/**
 * Created by maweihao on 12/28/20
 */
class Title188 {
    fun maxProfit(k: Int, prices: IntArray): Int {
        var k = k
        if (prices.size == 0) {
            return 0
        }
        val n = prices.size
        k = Math.min(k, n / 2)
        val buy = Array(n) { IntArray(k + 1) }
        val sell = Array(n) { IntArray(k + 1) }
        buy[0][0] = -prices[0]
        sell[0][0] = 0
        for (i in 1..k) {
            sell[0][i] = Int.MIN_VALUE / 2
            buy[0][i] = sell[0][i]
        }
        for (i in 1 until n) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i])
            for (j in 1..k) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i])
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i])
            }
        }
        return Arrays.stream(sell[n - 1]).max().asInt
    }
}
package top.wello.leetcode

import java.util.*

/**
 * Created by maweihao on 12/29/20
 */
class Title542 {
    private fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val m = matrix.size
        val n: Int = matrix[0].size
        val dist = Array(m) { IntArray(n) }
        val seen = Array(m) { BooleanArray(n) }
        val queue: Queue<IntArray> = LinkedList()
        // 将所有的 0 添加进初始队列中
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    queue.offer(intArrayOf(i, j))
                    seen[i][j] = true
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            val cell = queue.poll()
            val i = cell[0]
            val j = cell[1]
            for (d in 0..3) {
                val ni = i + dirs[d][0]
                val nj = j + dirs[d][1]
                if (ni in 0 until m && nj in 0 until n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1
                    queue.offer(intArrayOf(ni, nj))
                    seen[ni][nj] = true
                }
            }
        }
        return dist
    }

    companion object {
        var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    }
}
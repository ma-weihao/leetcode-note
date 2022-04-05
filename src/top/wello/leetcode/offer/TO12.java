package top.wello.leetcode.offer;

/**
 * Created by maweihao on 2/16/2022
 */
public class TO12 {

    public static void main(String[] args) {
        char[][] chars = {{'a', 'a'}};
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, m, n, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int m, int n, int k, String word) {
        if (i < 0 || i == m || j < 0 || j == n || k == word.length() || board[i][j] == '\0' || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        board[i][j] = '\0';
        k = k + 1;
        boolean res = dfs(board, i, j + 1, m, n, k, word) || dfs(board, i + 1, j, m, n, k, word) || dfs(board, i + 1, j, m, n, k, word)
                || dfs(board, i, j - 1, m, n, k, word) || dfs(board, i - 1, j, m, n, k, word);
        board[i][j] = word.charAt(k - 1);
        return res;
    }
}

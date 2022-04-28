package top.wello.leetcode;

/**
 * Created by maweihao on 2/22/21
 */
public class T766 {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        if (height == 1 || width == 1) {
            return true;
        }
        int i = height - 2;
        int j = 0;
        while (true) {
            int ii = i + 1;
            int jj = j + 1;
            while (ii <= height - 1 && jj <= width - 1) {
                if (matrix[i][j] != matrix[ii][jj]) {
                    return false;
                }
                ii++;
                jj++;
            }
            if (i > 0) {
                i--;
            } else if (j < width - 2) {
                j++;
            } else {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
    }
}

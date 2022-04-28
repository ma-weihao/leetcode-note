package top.wello.leetcode;

/**
 * Created by maweihao on 2/28/21
 */
public class T896 {

    public boolean isMonotonic(int[] A) {
        int len = A.length;
        int index = 0;
        int flag = 0;
        while (index + 1 < len) {
            int minus = A[index + 1] - A[index];
            if (flag == 0) {
                flag = minus;
            } else if (flag * minus < 0) {
                return false;
            }
            index++;
        }
        return true;
    }
}

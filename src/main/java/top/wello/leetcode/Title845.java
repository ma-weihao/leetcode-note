package top.wello.leetcode;

import java.util.Arrays;

/**
 * Created by maweihao on 10/25/20
 * 数组中的最长山脉
 */
public class Title845 {

    public int longestMountain(int[] a) {
        int len = a.length;
        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            if (a[i] > a[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int[] right = new int[len];
        for (int i = len - 2; i > 0; i--) {
            if (a[i] > a[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int max = 0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 1; i < len - 1; i++) {
            int n = left[i] + right[i] + 1;
            if (left[i] != 0 && right[i] != 0 && n > max) {
                max = n;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {875,884,239,731,723,685};
        System.out.println(new Title845().longestMountain(a));
    }
}

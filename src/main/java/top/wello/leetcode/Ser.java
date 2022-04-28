package top.wello.leetcode;

import java.io.IOException;

/**
 * Created by maweihao on 11/30/21
 */
public class Ser {

    public static void main(String[] args) throws IOException {
        int a = 1;
        System.out.println(-a);
    }

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int res2 = 1;
        while ((res & res2) == 0) {
            res2 <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & res2) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}

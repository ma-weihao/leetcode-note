package top.wello.leetcode.sort;

import java.util.Arrays;

/**
 * Created by maweihao on 9/6/21
 */
public class T07 {

    public static int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) return 0;
        int reverse = 0;
        while (x != 0) {
            int left = x % 10;
            if (reverse < Integer.MIN_VALUE / 10 || reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + left;
            x = x / 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome2(1));
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public static boolean isPalindrome(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        return  x == reverse(x);
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    // 最大子序列和
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        if (nums.length <= 1) {
            return max;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i -1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}

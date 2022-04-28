package top.wello.leetcode.offer;

import top.wello.leetcode.ListNode;

import java.util.Stack;

/**
 * Created by maweihao on 2/28/21
 */
public class TO06 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode l = head;
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}

package top.wello.leetcode.offer;

import top.wello.leetcode.ListNode;

/**
 * 反转链表
 * Created by maweihao on 8/30/21
 */
public class TO24 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

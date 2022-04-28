package top.wello.leetcode.offer;

import top.wello.leetcode.ListNode;

/**
 * 删除链表倒数第 k 个节点
 * Created by maweihao on 8/31/21
 */
public class TO21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(-1, head);
        ListNode slow = fakeHead;
        ListNode fast = fakeHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return fakeHead.next;
    }
}

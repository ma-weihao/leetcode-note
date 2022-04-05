package top.wello.leetcode;


/**
 * Created by maweihao on 11/6/21
 */
public class T24 {

    public static ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode a = fake;
        ListNode b;
        ListNode c;

        while (a.next != null && a.next.next != null) {
            b = a.next;

            a.next = b.next;
            c = b.next.next;
            b.next.next = b;
            b.next = c;

            a = b;
        }
        return fake.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        swapPairs(head);
        "sssff".indexOf("ff");
    }
}

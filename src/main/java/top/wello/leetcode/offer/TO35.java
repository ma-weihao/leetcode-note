package top.wello.leetcode.offer;

import top.wello.leetcode.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * Created by maweihao on 8/30/21
 */
public class TO35 {


    private Map<Node, Node> cache = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cache.containsKey(head)) {
            Node node = new Node(head.val);
            cache.put(head, node);
            node.random = copyRandomList(head.random);
            node.next = copyRandomList(head.next);
        }
        return cache.get(head);
    }

}

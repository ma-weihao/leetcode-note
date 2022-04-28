package top.wello.leetcode.offer;

import top.wello.leetcode.ListNode;
import top.wello.leetcode.TreeNode;

import java.util.*;

/**
 * 从上到下打印二叉树
 * Created by maweihao on 8/31/21
 */
public class TO32 {


    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> listNodes = new LinkedList<>();
        listNodes.offer(root);
        while (!listNodes.isEmpty()) {
            TreeNode pop = listNodes.pollFirst();
            list.add(pop.val);
            if (pop.left != null) {
                listNodes.offer(pop.left);
            }
            if (pop.right != null) {
                listNodes.offer(pop.right);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    // 从上到下打印二叉树
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                inner.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(inner);
        }
        int[] a = new int[2];
        return res;
    }

}

package top.wello.leetcode.sort;

import top.wello.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by maweihao on 9/7/21
 */
public class Traverse {

    // 先序遍历，用栈保存右节点
    public void preOrderTraverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode now = root;
        while (now != null || !stack.isEmpty()) {
            if (now != null) {
                System.out.print(now.val);
                stack.push(now);
                now = now.left;
            } else {
                TreeNode pop = stack.pop();
                now = pop.right;
            }
        }
    }

    public void preOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    // 用栈保存中节点
    public void inOrderTraverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode now = root;
        while (!stack.isEmpty() || now != null) {
            if (now != null) {
                stack.push(now);
                now = now.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop);
                now = pop.right;
            }
        }
    }

    public int hammingWeight(int n) {
        int cnt = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            cnt += n & flag;
            n = n >>> 1;
        }
        return cnt;
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (nums[l] % 2 == 1) l++;
            while (nums[r] % 2 == 0) r--;
            if (l >= r) {
                break;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }

    public int maxDepth(TreeNode root, int dep) {
        if (root == null) return dep;
        return Math.max(maxDepth(root.left, dep + 1), maxDepth(root.right, dep + 1));
    }

    public static void postorderTraversal(TreeNode root) {
        Deque<TreeNode> treeNodeStack = new LinkedList<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }

    // 队列
    public void levelTraverse(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            System.out.print(poll.val);
            if (poll.left != null) {
                list.push(poll.left);
            }
            if (poll.right != null) {
                list.push(poll.right);
            }
        }
    }

    public static int findNthDigit(int n) {
        if (n == 0) return 0;
        int row = 1;
        long max = 0;
        while (n >= max) {
            max = (long) (max + 9 * Math.pow(10.0, row - 1.0) * row);
            row++;
        }
        row--;
        long min = (long) (max - 9 * Math.pow(10.0, row - 1.0) * row);
        long v = (n - min) / row;
        int left = (int) ((n - min) % row);
        long first = (long) Math.pow(10.0, row - 1);
        if (left == 0) {
            String s = String.valueOf(first + v - 1);
            return Integer.parseInt(s.substring(s.length() - 1));
        } else {
            return Integer.parseInt(String.valueOf(first + v).charAt(left - 1) + "");
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}

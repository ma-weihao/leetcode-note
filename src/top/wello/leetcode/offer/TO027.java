package top.wello.leetcode.offer;

import top.wello.leetcode.TreeNode;

/**
 * Created by maweihao on 2/16/2022
 */
public class TO027 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;
        mirrorTreeInner(root);
        return root;
    }

    private void mirrorTreeInner(TreeNode root) {
        if (root == null) return ;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        mirrorTree(left);
        mirrorTree(right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        return judge(l.left, l.right) && judge(l.right, r.left);
    }
}

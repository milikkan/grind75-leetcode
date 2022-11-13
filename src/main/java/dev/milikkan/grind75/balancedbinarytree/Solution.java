package dev.milikkan.grind75.balancedbinarytree;

// problem link: https://leetcode.com/problems/balanced-binary-tree/
public class Solution {
    // time: O(n)
    // space: O(n)
    public static boolean isBalanced(TreeNode root) {
        return traverseDFS(root).isBalanced;
    }

    private static NodeInfo traverseDFS(TreeNode root) {
        if (root == null) {
            return new NodeInfo(true, 0);
        }

        NodeInfo left = traverseDFS(root.left);
        NodeInfo right = traverseDFS(root.right);

        boolean isBalanced = left.isBalanced &&
                right.isBalanced &&
                Math.abs(left.level - right.level) <= 1;

        return new NodeInfo(isBalanced, 1 + Math.max(left.level, right.level));
    }

    public static void main(String[] args) {
        var tree1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7))
        );

        var tree2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2)
        );

        TreeNode tree3 = null;

        System.out.println(isBalanced(tree1)); // true
        System.out.println(isBalanced(tree2)); // false
        System.out.println(isBalanced(tree3)); // true
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class NodeInfo {
    boolean isBalanced;
    int level;

    public NodeInfo(boolean isBalanced, int level) {
        this.isBalanced = isBalanced;
        this.level = level;
    }
}
package dev.milikkan.grind75;

import java.util.LinkedList;

// problem link: https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {

    // time: O(n)
    // space: O(n)
    // traverse method: BFS
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.poll();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) treeNodes.offer(current.left);
            if (current.right != null) treeNodes.offer(current.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode tree2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        TreeNode tree3 = null;

        printTreeBFS(invertTree(tree1)); // 2 3 1
        printTreeBFS(invertTree(tree2)); // 4 7 2 9 6 3 1
        printTreeBFS(invertTree(tree3)); // -
    }

    private static void printTreeBFS(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(root);

        while (!treeQueue.isEmpty()) {
            TreeNode current = treeQueue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) treeQueue.offer(current.left);
            if (current.right != null) treeQueue.offer(current.right);
        }
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

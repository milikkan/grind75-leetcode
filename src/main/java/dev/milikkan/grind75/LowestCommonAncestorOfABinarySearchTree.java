package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorOfABinarySearchTree {
    // time: O(logn)
    // space: O(logn)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2); 
        TreeNode eight = new TreeNode(8); 
        TreeNode zero = new TreeNode(0); 
        TreeNode four = new TreeNode(4); 
        TreeNode seven = new TreeNode(7); 
        TreeNode nine = new TreeNode(9); 
        TreeNode three = new TreeNode(3); 
        TreeNode five = new TreeNode(5);
        // construct tree1
        six.left = two;
        six.right = eight;
        two.left = zero;
        two.right = four;
        four.left = three;
        four.right = five;
        eight.left = seven;
        eight.right = nine;

        System.out.println(lowestCommonAncestor(six, two, eight).val); // 6
        System.out.println(lowestCommonAncestor(six, two, four).val); // 2
    }
}



// Leetcode 669-trim-a-binary-search-tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // if r is null
        if (root == null) {
            return null;
        }
        System.out.println(root.val);
        // r.val < low, go right retain sub tree
        if (root.val < low) {
            TreeNode tmp = trimBST(root.right, low, high);
            return tmp;
        }
        // r.val == low, clear left tree
        if (root.val == low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
            return root;
        }

        // 
        if (root.val > high) {
            System.out.println("in");
            return trimBST(root.left, low, high);
        }

        if (root.val == high) {
            root.right = null;
            root.left = trimBST(root.left, low, high);
            return root;
        }

        // unknow trim needed
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root;
    }
}
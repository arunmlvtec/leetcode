/**
 * Leetcode Problem Solutions
 * Problem No: 		226
 * Problem Name: 	Invert Binary Tree
 * Description: 	Invert a binary tree.
 * 
 *      	 4
 *         /   \
 *        2     7
 *       / \   / \
 *      1   3 6   9
 *   to
 *        4
 *      /   \
 *     7     2
 *    / \   / \
 *   9   6 3   1
 *   
 * Solved By: Arun Pokharna
 * 
 * */

package leetcode.invertbinarytree;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        return root;
    }
	
	public static void main(String[] args) {
		
	}

}

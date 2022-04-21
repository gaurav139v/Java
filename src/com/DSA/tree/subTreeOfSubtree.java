package com.DSA.tree;

public class subTreeOfSubtree {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(){}
		TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public boolean isIdentical(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        
        if(root == null || subRoot == null)
            return false;
        
        if(root.val == subRoot.val){
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        
        return false;    
        
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if(root == null) return false;
        
        if(subRoot.val == root.val){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
	
	
	public static void main(String[] args) {
		
		
		    

	}

}

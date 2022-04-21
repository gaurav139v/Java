package com.DSA.tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
	static int idx = -1;
	
	public Node generateTree(int[] nodes) { 
		idx++;
		
		if(nodes[idx] == -1) {
			return null;
		}
		
		Node newNode = new Node(nodes[idx]);
		newNode.leftNode = generateTree(nodes);
		newNode.rightNode = generateTree(nodes);
		
		return newNode;
	}
}


public class Tree {
	
	private static Node root;
	
	public static void preOrder(Node temp) {
		if(temp == null) {
			return ;
		}
		
		System.out.print(temp.data+" ");
		preOrder(temp.leftNode);
		preOrder(temp.rightNode);		
	}
	
	public static void inOrder(Node root) {
		if(root == null) return ;
		
		inOrder(root.leftNode);
		System.out.print(root.data+ " ");
		inOrder(root.rightNode);		
	}
	
	public static void postOrder(Node root) {
		if(root == null) return ;
		
		postOrder(root.leftNode);		
		postOrder(root.rightNode);
		System.out.print(root.data+" ");
	}
	
	public static void levelOrder(Node root) {
		if(root == null ) return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
//		q.add(null);
		
//		while(!q.isEmpty()) {
//			
//			Node currNode = q.remove();
//			if(currNode == null) {
//				System.out.println();
//				if(q.isEmpty()) {
//					break;
//				}else {
//					q.add(null);
//				}
//				
//			}else {
//				System.out.print(currNode.data+" ");
//				
//				if(currNode.leftNode != null) {
//					q.add(currNode.leftNode);
//				}
//				
//				if(currNode.rightNode != null) {
//					q.add(currNode.rightNode);
//				}
//			}
//			
//		}
		
		
		while(!q.isEmpty()){
	          int n = q.size();
	          
	          for(int i=1; i<=n; i++){
	            Node temp = q.poll();
	            
	            System.out.print(temp.data + " ");
	            
	            if(temp.leftNode != null)
	                q.add(temp.leftNode);
	                
	            if (temp.rightNode != null)
	                q.add(temp.rightNode);
	            
	          }
	          System.out.println();
	          
	      }
	}
	
	public static int count(Node root) {
		if(root == null) return 0;
		
		int x = count(root.leftNode);
		int y = count(root.rightNode);
		return x + y + 1;
	}
	
	public static int sumOfNodes(Node root) {
		if(root== null) return 0;
		
		int x = sumOfNodes(root.leftNode);
		int y = sumOfNodes(root.rightNode);
		
		return x + y + root.data;
	}
	
	public static int heightOfTree(Node root) {
		if(root == null) return 0;
		
		int x = heightOfTree(root.leftNode);
		int y = heightOfTree(root.rightNode);
		return Math.max(x, y) + 1;
		
	}
	
	// O(n^2)
	public static int diameter(Node root) {
		
		if(root == null ) return 0;
		
		int diam1 = diameter(root.leftNode);
		int diam2 = diameter(root.rightNode);
		int diam3 = heightOfTree(root.leftNode) + heightOfTree(root.rightNode) + 1;
		
		return Math.max(diam3, Math.max(diam1, diam2));
	}
	
	static class TreeInfo {
		int diam;
		int ht;
		
		TreeInfo(int diam, int ht){
			this.diam = diam;
			this.ht = ht;
		}
	}
	
	// O(n)
	public static TreeInfo diameter2(Node root) {
		
		if(root == null) return new TreeInfo(0,0);
		
		TreeInfo leftheight = diameter2(root.leftNode);
		TreeInfo rightheight = diameter2(root.rightNode);
		
		int myheight = Math.max(leftheight.ht, rightheight.ht)+1;
		
		int diam1 = leftheight.diam;
		int diam2 = rightheight.diam;
		int diam3 = leftheight.ht + rightheight.ht + 1;
		
		int mydiam = Math.max(Math.max(diam1, diam2), diam3);
		TreeInfo t = new TreeInfo(mydiam, myheight);
		return t;	
		
	}
	
	public static int sumOfKthLevel(Node root, int k) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int sum = 0;
		int count = 1;
		
		while(count <= k) {
			Node currNode = q.remove();
			if(currNode == null) {
				count++;
				if(q.isEmpty()) {
					break;
				}else {
					q.add(null);
				}
			}else {
				if(count == k)
					sum = sum + currNode.data;
				
				if(currNode.leftNode != null)
					q.add(currNode.leftNode);
				
				if(currNode.rightNode != null)
					q.add(currNode.rightNode);
			}			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] nodes = {1,2,4,-1,-1,5,-1,-1, 3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
	    root = tree.generateTree(nodes);
		
//	    preOrder(root);
//	    inOrder(root);
//	    postOrder(root);
	    levelOrder(root);
//	    System.out.println(count(root));
//	    System.out.println(sumOfNodes(root));
//	    System.out.println(heightOfTree(root));
//	    System.out.println(diameter(root));
//	    System.out.println(diameter2(root).diam);
	    
//	    System.out.println(sumOfKthLevel(root, 3));
		
	}

}

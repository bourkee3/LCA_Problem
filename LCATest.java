import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest{

	@Test
	public void testEmptyTree() {

		LCA tree = new LCA();
		assertNull("Find the Lowest Common Ancestor when the Binary Tree is empty: ", tree.findLCA(1, 2));
		assertEquals("Find the Lowest Common Ancestor when the Binary Tree is empty: ", null, tree.findLCA(1, 2));
	}

	@Test
	public void testNullCase()
	{
		LCA tree = new LCA();

		assertNull("Test method returns null for an empty tree", tree.findLCA(1,2));
	}

	@Test
	public void testTreeNodeConstructor() {
		TreeNode temp = new TreeNode(1);
		assertNotNull("Testing TreeNode constructor: ", temp);
	}

	@Test
	public void testOneNode() {
		LCA tree = new LCA();
		tree.root = new TreeNode(1);
		assertEquals("Binary Tree Test to see whether a Tree w/ only one node returns that nodes key when the parameters passed are both that nodes key.", 1, tree.findLCA(1,1).data);
	}

	@Test
	public void testTwoNodes() {
		LCA tree = new LCA();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		assertEquals("Test that a Binary Tree with only one root and one child. ", 1, tree.findLCA(1, 2).data);	
	}

	@Test
	public void testLowestCommonAncestor(){

		//Important test to see whether the code locates the lowest common ancestor correctly.
		//First create a structured Binary Tree.
		//Test Tree Structure:

		//		      _1_
		//           /    \
		//          /      \
		//	     _2_ 	    _3_
		//     /     \    /     \
		//   _4_    _5_  _6_     _7_
		// /    \  /   \/   \   /   \
		//8      9     10    11      12

		LCA tree = new LCA();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(7);
		tree.root.right.left = new TreeNode(6);
		tree.root.left.left.left = new TreeNode(8);
		tree.root.left.left.right = new TreeNode(9);
		tree.root.left.right.right = new TreeNode(10);




		assertEquals("LCA of 2 and 3 :", 1, tree.findLCA(2,3).data);
		assertEquals("LCA of 4 and 5 :", 2, tree.findLCA(4, 5).data);
		assertEquals("LCA of 6 and 7 :", 3, tree.findLCA(6,7).data);
		assertEquals("LCA of 8 and 9 :", 4, tree.findLCA(8,9).data);


	}

	@Test
	public void testForNonExistentNodes(){

		LCA tree = new LCA();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);



		assertEquals("Test to find lowest common ancestors of non-existent nodes in populated binary tree: ", null, tree.findLCA(94, 37));

	}







}

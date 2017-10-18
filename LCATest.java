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




	
	



}

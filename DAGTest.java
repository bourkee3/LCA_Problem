import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	@Test
	public void testSizeEmpty() {
		DAG treeEmpty = new DAG();

		assertEquals("Testing the lowest common ancestor of empty tree", -1,
				treeEmpty.LCA(0, 0));
	}

	@Test
	public void testSizeOneNode() {
		DAG treeOneNode = new DAG();
		treeOneNode.rootNode = new TreeNode(1);

		assertEquals("Testing the lowest common ancestor of a one node tree", -1,
				treeOneNode.LCA(1, 0));
	}
	
	//Create new Directed Acyclic Graph to use in tests
	DAG newTree = new DAG();
	
	@Test
	public void test15NodeTree() {
		
		//creating tree with 15 nodes 
		
		newTree.rootNode = new TreeNode(1);
		newTree.rootNode.left = new TreeNode(2);
		newTree.rootNode.right = new TreeNode(3);
		newTree.rootNode.left.left = new TreeNode(4);
		newTree.rootNode.left.right = new TreeNode(5);
		newTree.rootNode.right.left = new TreeNode(6);
		newTree.rootNode.right.right = new TreeNode(7);
		newTree.rootNode.left.left.left = new TreeNode(8);
		newTree.rootNode.left.left.right = new TreeNode(9);
		newTree.rootNode.left.right.left = new TreeNode(10);
		newTree.rootNode.left.right.right = new TreeNode(11);
		newTree.rootNode.right.left.left = new TreeNode(12);
		newTree.rootNode.right.left.right = new TreeNode(13);
		newTree.rootNode.right.right.left = new TreeNode(14);
		newTree.rootNode.right.right.right = new TreeNode(15); 

		assertEquals("LCA of this tree is", 1,
				newTree.LCA(1, 2));
		assertEquals("LCA of this tree is", 1,
				newTree.LCA(2, 3));
		assertEquals("LCA of this tree is", 2,
				newTree.LCA(2, 4));
		assertEquals("LCA of this tree is", 2,
				newTree.LCA(4, 5));
		assertEquals("LCA of this tree is", 3,
				newTree.LCA(6, 7));
		assertEquals("LCA of this tree is", 4,
				newTree.LCA(4, 8));
		assertEquals("LCA of this tree is", 4,
				newTree.LCA(8, 9));
		assertEquals("LCA of this tree is", 6,
				newTree.LCA(6, 12));
		assertEquals("LCA of this tree is", 7,
				newTree.LCA(14, 15));
		assertEquals("LCA of this tree is", 2,
				newTree.LCA(8, 2));
		assertEquals("LCA of this tree is", 2,
				newTree.LCA(9, 11));
		assertEquals("LCA of this tree is", 3,
				newTree.LCA(13, 14));
		assertEquals("LCA of this tree is", 1,
				newTree.LCA(15, 1));
	}
	
	//Testing an empty graph
	
	@Test
	public void testEmptyGraph() {
		DAG DAG = new DAG();
		assertEquals(0, DAG.findLCA_DAG(null, null, null));
	}

	//Testing a graph with only one node 
	
	@Test
	public void testGraphOneNode() {
		DAG DAG = new DAG();
		TreeNode n1 = new TreeNode(1);
		DAG.addToGraph(n1);
		assertEquals(1, DAG.findLCA_DAG(n1, n1, n1));
	}


}

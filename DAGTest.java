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


}

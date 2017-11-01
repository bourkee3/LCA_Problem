import java.util.ArrayList;
import java.util.List;


public class DAG {
	
	TreeNode rootNode;
	List<Integer> NodePath1 = new ArrayList<>();
	List<Integer> NodePath2 = new ArrayList<>();
	

	int LCA (int n1, int n2)
	{
		NodePath1.clear();
		NodePath2.clear();
		return findLCA(rootNode, n1, n2);
	}
	
	int LCA_DAG (TreeNode n1, TreeNode n2)
	{
		return findLCA_DAG(rootNode, n1, n2);
	}
	
	private int findLCA(TreeNode rootNode, int n1, int n2)
	{
		if (!findPath(rootNode, n1, NodePath1) || !findPath(rootNode, n2, NodePath2)) 
			{
				if(NodePath1.size() == 0 && NodePath2.size() == 0)
				{
					if(!NodePath1.contains(n1) && !NodePath2.contains(n2))
					{
						System.out.println("These nodes does not exist in the tree.");
					}
					else
					System.out.println("Tree is empty.");
				}
				if (NodePath1.size() > 0 && NodePath2.size() == 0)
				{
					System.out.println("Node 1 is present but Node 2 is not.");
				}
				if (NodePath2.size() > 0 && NodePath1.size() == 0)
				{
					System.out.println("Node 2 is present but Node 1 is not.");
				}
				return -1;
			}
			int i;
			for (i = 0; i < NodePath1.size() && i < NodePath2.size(); i++)
			{
				if (!NodePath1.get(i).equals(NodePath2.get(i)))
				{
					break;
				}
			}
			return NodePath1.get(i - 1);
	}
	
	int findLCA_DAG(TreeNode rootNode, TreeNode n1, TreeNode n2)
	{
		if(n1 != null && n2 != null) 
		{
		if (n1.ancestors != null && n2.ancestors != null) {
			for (int i = 0; i < n2.ancestors.size(); i++) {
				for (int j = 0; j < n1.ancestors.size(); j++) {
					if (n2.ancestors.get(i) == n1.ancestors.get(j)) {
						return n2.ancestors.get(i).data;
					}
				}
			}
		} else
			return rootNode.data;
		}
		return 0;
	}
	
	private boolean findPath(TreeNode rootNode, int n, List<Integer> path)
    {
        if (rootNode == null) {
            return false;
        }
        path.add(rootNode.data);
        if (rootNode.data == n) {
            return true;
        }
        if (rootNode.left != null && findPath(rootNode.left, n, path)) {
            return true;
        }
        if (rootNode.right != null && findPath(rootNode.right, n, path)) {
            return true;
        }
        path.remove(path.size()-1);
 
        return false;
    }
	
	public void addToGraph(TreeNode n1)
	{
		n1.ancestors = new ArrayList <TreeNode> ();
		n1.ancestors.add(n1);
		
	}
	
	public void addAncestorsToNode(TreeNode n1, TreeNode n2)
	{
		for (int i=0; i < n1.ancestors.size(); i++)
		{
			if(!n2.ancestors.contains(n1.ancestors.get(i)))
			{
				n2.ancestors.add(n1.ancestors.get(i));
			}
		}
	}
	public void addAncestorsToNodeAtPosition(int p, TreeNode n1, TreeNode n2)
	{
		for (int i=0; i < n1.ancestors.size(); i++)
		{
			if(!n2.ancestors.contains(n1.ancestors.get(i)))
			{
				n2.ancestors.add(p, n1.ancestors.get(i));
			}
		}
	}
	
	
	
}
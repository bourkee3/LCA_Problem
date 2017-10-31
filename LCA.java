/*************************************************************************
 *
 *  @author Emma Bourke - bourkee3
 *
 *************************************************************************/
//Given a binary tree, find the lowest common ancestor of two given nodes in the tree

class TreeNode{
	int data;
	TreeNode left, right;

	public TreeNode(int item){

		data = item;

		left = null;

		left = right; 
	}
}

public class LCA {
	
	//Create root of the binary tree

	TreeNode root;
	TreeNode findLCA( int n1, int n2){
		return findLCA(root, n1, n2);
	}

	TreeNode findLCA(TreeNode n, int n1, int n2){
		
		//End case
		if ( n == null){
			return null;
		}
		
		//Checks to see whether either node: n1 or n2 matches the root key
		if( n.data == n1 || n.data == n2){
			return n;		//returns n if present
		}
		
		//Now Check for keys in both left and right subtrees

		TreeNode leftLCA = findLCA(n.left, n1, n2);
		TreeNode rightLCA = findLCA(n.right, n1,n2);

		//Checks to see of they are present
		if( leftLCA != null && rightLCA != null){
			return n;
		}return (leftLCA != null) ? leftLCA : rightLCA;			//If the are, returns the LCA of both subtrees 

	}



}





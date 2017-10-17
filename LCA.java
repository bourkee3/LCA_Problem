
public class LCA {

	public class TreeNode{
		int data;
		TreeNode left, right;

		public TreeNode(int item){

			data = item;

			left = null;

			left = right; 
		}
	}

	public class BinaryTree {
		
		TreeNode root;
		TreeNode findLCA( int n1, int n2){
			return findLCA(root, n1, n2);
		}

		TreeNode findLCA(TreeNode n, int n1, int n2){

			if ( n == null){
				return null;
			}
			if( n.data == n1 || n.data == n2){
				return n;
			}

			TreeNode leftLCA = findLCA(n.left, n1, n2);
			TreeNode rightLCA = findLCA(n.right, n1,n2);
			
			if( leftLCA != null && rightLCA != null){
				return n;
			}return (leftLCA != null) ? leftLCA : rightLCA;
			
		}



	}



}

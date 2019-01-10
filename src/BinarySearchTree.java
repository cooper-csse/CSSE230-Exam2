import java.util.ArrayList;


/**
 * Exam 2 Tree methods
 * 
 * TODO:
 * @author Cooper Anderson (andersc7)
 * 
 * Directions: Implement the methods below marked with "TODO" 
 * For details, see the .pdf/.docx files for instructions, both are included in this package
 */

public class BinarySearchTree {

	BinaryNode root;

	final BinaryNode NULL_NODE = new BinaryNode();

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	// --------------------------------------------

	int countNodesWithOddLengthLabels() {
		// TODO: Implement me!
		return -1;
	} // countNodesWithOddLengthLabels

	void deleteNodesWithOneChild() {
		// TODO: Implement me!
	}

	ArrayList<String> getDirectionsToItem(String x) {
		// TODO: Implement me!
		return new ArrayList<String>();
	}
	
	// --------------------------------------------

	// The following methods are used by the unit tests
	public void insert(String e) {
		root = root.insert(e);
	}

	/**
	 * Feel free to call from tests to use to verify the shapes of your trees while
	 * debugging. Just remove the calls you are done so the output isn't cluttered.
	 * 
	 * @return A string showing a traversal of the nodes where children are indented
	 *         so that the structure of the tree can be determined.
	 * 
	 */
	public String toIndentString() {
		return root.toIndentString("");
	}

	@Override
	public String toString() {
		return root.toString();
	}

	// /////////////// BinaryNode
	public class BinaryNode {
		public String data;
		public BinaryNode left;
		public BinaryNode right;

		// The rest of the methods are used by the unit tests and for debugging

		public BinaryNode() {
			this.data = null;
			this.left = null;
			this.right = null;
		}

		public BinaryNode(String element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		// --------------------------------------------

		public BinaryNode insert(String e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(data) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(data) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		// --------------------------------------------
		
		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data + right.toString();
		}

		// --------------------------------------------
		
		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return indent + "NULL\n";
			}
			String myInfo = indent + String.format("%s\n", this.data);
			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}

}
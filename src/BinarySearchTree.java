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

	/**
	 * @return The number of items that have odd-length labels
	 */
	int countNodesWithOddLengthLabels() {
		return this.root != NULL_NODE ? this.root.countNodesWithOddLengthLabels() : 0;
	}

	/**
	 * Remove all nodes from the tree that have a single child
	 */
	void deleteNodesWithOneChild() {
		if (this.root != NULL_NODE) this.root = this.root.deleteNodesWithOneChild();
	}

	/**
	 * @param x The item to which you are getting directions
	 * @return A step by step list of how to get to the destination
	 */
	ArrayList<String> getDirectionsToItem(String x) {
		return this.root.getDirectionsToItem(x, new ArrayList<>());
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

		// --------------------------------------------

		public int countNodesWithOddLengthLabels() {
			return (this.data.length() % 2) + (this.left != NULL_NODE ? this.left.countNodesWithOddLengthLabels() : 0) + (this.right != NULL_NODE ? this.right.countNodesWithOddLengthLabels() : 0);
		}

		public BinaryNode deleteNodesWithOneChild() {
			// Check to make sure both nodes are not NULL_NODE
			if (this.left != this.right) {
				// if right node is the only one that is NULL_NODE, return the left node
				if (this.right == NULL_NODE)
					return this.left.deleteNodesWithOneChild();
				else if (this.left == NULL_NODE)
					return this.right.deleteNodesWithOneChild();
			}
			// Recurse down the rest of the tree
			if (this.left != NULL_NODE) this.left = this.left.deleteNodesWithOneChild();
			if (this.right != NULL_NODE) this.right = this.right.deleteNodesWithOneChild();
			return this;
		}

		public ArrayList<String> getDirectionsToItem(String item, ArrayList<String> output) {
			if (this == NULL_NODE) {
				output.add(item + " not found");
				return output;
			}
			int direction = item.compareTo(this.data);
			if (direction == 0)
				output.add(this.data + " found");
			else if (direction > 0) {
				output.add("right at " + this.data);
				this.right.getDirectionsToItem(item, output);
			} else {
				output.add("left at " + this.data);
				this.left.getDirectionsToItem(item, output);
			}
			return output;
		}
	}

}
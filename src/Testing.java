import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int countNodesWithOddLengthLabelsPoints = 0;
	private static int deleteNodesWithOneChildPoints = 0;
	private static int getDirectionsToItemPoints = 0;
	
	// -----------------------------------------------------
	// Test helper operations
	// -----------------------------------------------------

	private BinarySearchTree makeABCTree() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert("H");
		t.insert("B");
		t.insert("J");
		t.insert("A");
		t.insert("G");
		t.insert("I");
		t.insert("K");
		t.insert("D");
		t.insert("L");
		t.insert("C");
		t.insert("E");
		t.insert("F");
		return t;
	} // makeABCTree

	private BinarySearchTree makeCompleteTree() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert("Lime");
		t.insert("Banana");
		t.insert("Plum");
		t.insert("Asian Pear");
		t.insert("Kiwi");
		t.insert("Orange");
		t.insert("Quince");
		return t;
	} // makeCompleteTree

	private BinarySearchTree makeFruitTree() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert("Kiwi");
		t.insert("Banana");
		t.insert("Peach");
		t.insert("Apple");
		t.insert("Guava");
		t.insert("Mango");
		t.insert("Durian");
		return t;
	} // makeFruitTree

	private BinarySearchTree makeUpsideDownVShapeTree() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert("D");
		t.insert("C");
		t.insert("B");
		t.insert("A");
		t.insert("X");
		t.insert("Y");
		t.insert("Z");
		return t;
	} // makeUpsideDownVShapeTrees

	private BinarySearchTree makeZigzagTree() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert("A");
		t.insert("Z");
		t.insert("B");
		t.insert("Y");
		t.insert("C");
		t.insert("X");
		t.insert("D");
		t.insert("W");
		return t;
	} // makeZigzagTree

	// -----------------------------------------------------
	// Tests for counting nodes with odd length labels
	// -----------------------------------------------------

	@Test
	public void testCountNodesWithOddLengthLabelsV01() {
		// From ABC Tree - all are odd length
		BinarySearchTree t = makeABCTree();
		assertEquals(12, t.countNodesWithOddLengthLabels());
		countNodesWithOddLengthLabelsPoints += 4;
	} // testCountNodesWithOddLengthLabelsV01

	@Test
	public void testCountNodesWithOddLengthLabelsV02() {
		// From Fruit Tree - some are odd length and some are even length
		BinarySearchTree t = makeFruitTree();
		assertEquals(4, t.countNodesWithOddLengthLabels());
		countNodesWithOddLengthLabelsPoints += 4;
	} // testCountNodesWithOddLengthLabelsV02

	@Test
	public void testCountNodesWithOddLengthLabelsV03() {
		// From Empty Tree
		BinarySearchTree t = new BinarySearchTree();
		assertEquals(0, t.countNodesWithOddLengthLabels());
		countNodesWithOddLengthLabelsPoints += 4;
	} // testCountNodesWithOddLengthLabelsV03

	@Test
	public void testCountNodesWithOddLengthLabelsV04() {
		// From Complete Tree - all are even length
		BinarySearchTree t = makeCompleteTree();
		assertEquals(0, t.countNodesWithOddLengthLabels());
		countNodesWithOddLengthLabelsPoints += 4;
	} // testCountNodesWithOddLengthLabelsV04

	// -----------------------------------------------------
	// Tests for delete node with one child
	// -----------------------------------------------------

	@Test
	public void testDeleteLeavesWithOneNodeV01() {
		// From ABC Tree
		BinarySearchTree t = makeABCTree();
		t.deleteNodesWithOneChild();
		assertEquals("ABCDFHIJL", t.toString());
		deleteNodesWithOneChildPoints += 4;
	} // testDeleteLeavesWithOneNodeV01

	@Test
	public void testDeleteLeavesWithOneNodeV02() {
		// From Complete Tree
		BinarySearchTree t = makeCompleteTree();
		t.deleteNodesWithOneChild();
		assertEquals("Asian PearBananaKiwiLimeOrangePlumQuince", t.toString());
		deleteNodesWithOneChildPoints += 4;
	} // testDeleteLeavesWithOneNodeV02

	@Test
	public void testDeleteLeavesWithOneNodeV03() {
		// From Empty Tree
		BinarySearchTree t = new BinarySearchTree();
		t.deleteNodesWithOneChild();
		assertEquals("", t.toString());
		deleteNodesWithOneChildPoints += 4;
	} // testDeleteLeavesWithOneNodeV03

	@Test
	public void testDeleteLeavesWithOneNodeV04() {
		// From Upside Down V Shape Tree
		BinarySearchTree t = makeUpsideDownVShapeTree();
		t.deleteNodesWithOneChild();
		assertEquals("ADZ", t.toString());
		deleteNodesWithOneChildPoints += 4;
	} // testDeleteLeavesWithOneNodeV04

	@Test
	public void testDeleteLeavesWithOneNodeV05() {
		// From Zigzag Tree
		BinarySearchTree t = makeZigzagTree();
		t.deleteNodesWithOneChild();
		assertEquals("W", t.toString());
		deleteNodesWithOneChildPoints += 4;
	} // testDeleteLeavesWithOneNodeV05

	// -----------------------------------------------------
	// Tests for get directions to item
	// -----------------------------------------------------

	@Test
	public void testGetDirectionsToItemV01() {
		// Find "F" in ABC Tree - success
		BinarySearchTree t = makeABCTree();
		ArrayList<String> result = t.getDirectionsToItem("F");
		assertEquals("[left at H, right at B, left at G, right at D, right at E, F found]", result.toString());
		getDirectionsToItemPoints += 5;
	} // testGetDirectionsToItemV01

	@Test
	public void testGetDirectionsToItemV02() {
		// Find "9" in ABC Tree - failure
		BinarySearchTree t = makeABCTree();
		ArrayList<String> result = t.getDirectionsToItem("9");
		assertEquals("[left at H, left at B, left at A, 9 not found]", result.toString());
		getDirectionsToItemPoints += 5;
	} // testGetDirectionsToItemV02

	@Test
	public void testGetDirectionsToItemV03() {
		// Find "Banana" in an empty tree - failure
		BinarySearchTree t = new BinarySearchTree();
		ArrayList<String> result = t.getDirectionsToItem("Banana");
		assertEquals("[Banana not found]", result.toString());
		getDirectionsToItemPoints += 5;
	} // testGetDirectionsToItemV03

	@Test
	public void testGetDirectionsToItemV04() {
		// Find "Kiwi" in an fruit tree - success
		BinarySearchTree t = makeFruitTree();
		ArrayList<String> result = t.getDirectionsToItem("Kiwi");
		assertEquals("[Kiwi found]", result.toString());
		getDirectionsToItemPoints += 5;
	} // testGetDirectionsToItemV04

	// -----------------------------------------------------
	// Post test operations
	// -----------------------------------------------------

	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/16 - countNodesWithOddLengthLabels correctness points\n",
				countNodesWithOddLengthLabelsPoints);
		System.out.printf("%2d/20 - deleteNodesWithOneChild correctness points\n", deleteNodesWithOneChildPoints);
		System.out.printf("%2d/20 - getDirectionsToItem correctness points\n", getDirectionsToItemPoints);
		System.out.printf("TBD/4 - efficency will be checked by visual inspection of code by grader\n");
		System.out.println("=============================================================================");
		System.out.printf("%2d/60 - grand total so far", 
				countNodesWithOddLengthLabelsPoints + deleteNodesWithOneChildPoints + getDirectionsToItemPoints);
	} // displayPoints
}

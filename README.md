# _JBinaryTree_

_Description: JBinaryTree is an implementation of a binary search tree in Java. The project started as an academic excercise, but soon, it was transformed to a full object oriented implementation for any developer wanting to use search binary trees. JBinaryTree supports the most common traversal algorithmns plus a reverse in order trasversal not present in the specifications, but very useful for programmers wanting to reverse traverse the tree._

_Suggestions are always welcomed._

## Documentation

All documentation is in javadoc format http://mmontuori.github.io/jbinarytree/javadoc/

## Download

http://mmontuori.github.io/jbinarytree/jar/jbinarytree.jar

## Project Setup

_Using JBinaryTree is simple. A sample implementaion on an Integer as key and String as value is privided as a template. Following is a snippet implementation:_

	public class IntStringBinaryTree extends BinaryTree<Integer, String> {

		public IntStringBinaryTree(boolean debug) {
			super(debug);
		}
		
		@Override
		public int compare(Node<Integer, String> a, Node<Integer, String> b) {
			if ( a.key.intValue() < b.key.intValue() ) {
				return -1;
			} else if ( a.key.intValue() == b.key.intValue() ){
				return 0;
			} else {
				return 1;
			}
		}
		
		@Override
		public void orderedNode(Node<Integer, String> orderedNode) {
			Integer key = orderedNode.key;
			System.out.println("ordered node key: " + key.intValue());
		}
	
	}

This is all it takes to create a Binary Search Tree implementiation of Integer as key, and String as value. A sample usage of a class implementing 100 random numbers in the binary tree, find a record, and remove a record is:

	import java.util.Random;
	
	import com.mmontuori.binarytree.*;
	
	public class TestBinTree {
	
		private static final int SIZE = 100;
		
		public static void main(String[] args) {
			BinaryTree<Integer, String> testTree = new IntStringBinaryTree();
			Random random = new Random();
			int toSearch = 0;
			for ( int i=0; i<SIZE; ++i) {
				int rnd = random.nextInt(10000);
				Integer key = new Integer(rnd);
				String value = String.valueOf(rnd);
				Node<Integer, String> node = new Node<Integer,String>(key, value);
				System.out.println("adding node: " + rnd);
				testTree.addNode(node);
				if ( SIZE/2 == i ) {
					toSearch = rnd;
					System.out.println("record to search and remove: " + toSearch);
				}
			}
			System.out.println("tree size: " + testTree.getSize());
			System.out.println("tree right size: " + testTree.getRightSize());
			System.out.println("tree left size: " + testTree.getLeftSize());
			testTree.traverseInOrder(testTree.getRoot());
			Integer key = new Integer(toSearch);
			Node<Integer,String> node = testTree.findNode(key);
			System.out.println("node found: " + node.key.intValue());
			testTree.removeNode(toSearch);
			testTree.traverseInOrder(testTree.getRoot());
			System.out.println("tree size: " + testTree.getSize());
			System.out.println("tree right size: " + testTree.getRightSize());
			System.out.println("tree left size: " + testTree.getLeftSize());
		}

	}

## Deploying

_Just add jbinarytree.jar to your CLASSPATH and use it._

## License
JBinaryTree is release under the GPLv2 license.

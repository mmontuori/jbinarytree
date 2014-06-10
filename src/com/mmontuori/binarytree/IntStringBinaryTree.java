package com.mmontuori.binarytree;

/**
 * IntStringBinaryTree is a sample implementation of JBinaryTree using an
 * Integer as a key object and a string as a value object
 * 
 * @author Michael Montuori <michael.montuori@gmail.com>
 * @version 1.0
 *
 */
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

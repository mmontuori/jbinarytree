package com.mmontuori.binarytree;

/**
 * @author Michael Montuori
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

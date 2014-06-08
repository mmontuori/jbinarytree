package com.mmontuori.binarytree;

/**
 * @author michael
 *
 */
public class IntStringBinaryTree extends BinaryTree<Integer, String> {
	
	/* (non-Javadoc)
	 * @see com.mmontuori.binarytree.BinaryTree#compare(com.mmontuori.binarytree.Node, com.mmontuori.binarytree.Node)
	 */
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

	/* (non-Javadoc)
	 * @see com.mmontuori.binarytree.BinaryTree#orderedNode(com.mmontuori.binarytree.Node)
	 */
	@Override
	public void orderedNode(Node<Integer, String> orderedNode) {
		Integer key = orderedNode.key;
		System.out.println("ordered node key: " + key.intValue());
	}

}

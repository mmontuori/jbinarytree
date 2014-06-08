package com.mmontuori.binarytree;

/**
 * @author michael
 *
 * @param <A>
 * @param <B>
 */
public abstract class BinaryTree<A,B> {

	private Node<A,B> root;
	
	/**
	 * 
	 */
	int size = 0;
	
	/**
	 * 
	 */
	int rightSize = 0;
	
	/**
	 * 
	 */
	int leftSize = 0;
	
	/**
	 * @return
	 */
	public Node<A,B> getRoot() {
		return root;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return
	 */
	public int getRightSize() {
		return rightSize;
	}

	/**
	 * @return
	 */
	public int getLeftSize() {
		return leftSize;
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public abstract int compare(Node<A,B> a, Node<A,B> b);
		
	/**
	 * @param node
	 */
	public void addNode(Node<A,B> node) {
		if (root == null) {
			root = node;
			size++;
		} else {
			Node<A,B> currentNode = root;
			Node<A,B> parent;
			while (true) {
				parent = currentNode;
				int compareResult = compare(node, currentNode);
				if (compareResult < 0) {
					currentNode = currentNode.leftChild;
					if (currentNode == null) {
						parent.leftChild = node;
						size++;
						leftSize++;
						return;
					}
				} else {
					currentNode = currentNode.rightChild;
					if (currentNode == null) {
						parent.rightChild = node;
						size++;
						rightSize++;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * @param orderedNode
	 */
	public abstract void orderedNode(Node<A,B> orderedNode);

	/**
	 * @param currentNode
	 */
	public void traverseReverseOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			traverseReverseOrder(currentNode.rightChild);
			orderedNode(currentNode);
			traverseReverseOrder(currentNode.leftChild);
		}
	}
	
	/**
	 * @param currentNode
	 */
	public void traverseInOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			traverseInOrder(currentNode.leftChild);
			orderedNode(currentNode);
			traverseInOrder(currentNode.rightChild);
		}
	}
	
	/**
	 * @param currentNode
	 */
	public void traversePreOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			orderedNode(currentNode);
			traversePreOrder(currentNode.leftChild);
			traversePreOrder(currentNode.rightChild);
		}
	}
	
	/**
	 * @param currentNode
	 */
	public void traversePostOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			traversePostOrder(currentNode.leftChild);
			traversePostOrder(currentNode.rightChild);
			orderedNode(currentNode);

		}
	}

	/**
	 * @param key
	 * @return
	 */
	public Node<A,B> findNode(Node<A,B> key) {
		Node<A,B> currentNode = root;
		int cmpvalue = -1;
		while (cmpvalue != 0) {
			cmpvalue = compare(key, currentNode);
			if (cmpvalue < 0) {
				currentNode = currentNode.leftChild;
			} else if (cmpvalue > 0) {
				currentNode = currentNode.rightChild;
			}
			if (currentNode == null) {
				return null;
			}
		}
		return currentNode;
	}

}

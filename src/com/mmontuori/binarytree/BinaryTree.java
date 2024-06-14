package com.mmontuori.binarytree;

/**
 * BinaryTree is the class implementing a binary search tree algorithms. The class is capable of providing different tree traversal such as:
 * in order, pre order, post order, and reverse in order. It is also capable of providing the total size, right and left sizes to examine if
 * the tree is unbalanced
 * 
 * @author Michael Montuori <michael.montuori@gmail.com>
 * @version 1.0
 *
 * @param <A> the key object type
 * @param <B> the value object type
 */
public abstract class BinaryTree<A,B> {

	/**
	 * This is the root node, which is the first element added to the tree
	 */
	private Node<A,B> root;
	
	/**
	 * The total tree size
	 */
	int size = 0;
	
	/**
	 * The right tree size
	 */
	int rightSize = 0;
	
	/**
	 * The left tree size
	 */
	int leftSize = 0;
	
	/**
	 * if set to true additional debug information is printed to standard out. Default is false 
	 */
	boolean debug = false;
	
	/**
	 * constructor to use for debugging purposes
	 * @param debug set to true for additional debugging information
	 */
	public BinaryTree(boolean debug) {
		this.debug = debug;
	}
	
	/**
	 * regular constructor used for general use
	 */
	public BinaryTree() {
		this(false);
	}
	
	/**
	 * access the root Node
	 * 
	 * @return the root Node reference
	 */
	public Node<A,B> getRoot() {
		return root;
	}

	/**
	 * returns the total binary tree size or number of elements
	 * 
	 * @return the total tree size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * returns the right binary tree size or number of elements
	 * 
	 * @return the right size
	 */
	public int getRightSize() {
		return rightSize;
	}

	/**
	 * returns the left binary tree size or number of elements
	 * 
	 * @return the left size
	 */
	public int getLeftSize() {
		return leftSize;
	}

	/**
	 * abstract method that must be implemented to compare 2 nodes. The method must return '-1' if node a is < than node b,
	 * '0' if node a is = to node b, and '1' if node a is > then node b. The return code allows the BinaryTree class to store
	 * the node in the appropriate side of the binary tree (left or right)
	 * 
	 * @param a the first node reference to compare
	 * @param b the second node reference to compare
	 * @return '-1' if a<b, '0' if a=b, '1' if a>b
	 */
	public abstract int compare(Node<A,B> a, Node<A,B> b);
		
	/**
	 * adds a Node reference to the binary search tree. The first node added becomes the root node, the subsequent elements are
	 * added based on comparing the node to add to the existing nodes in the tree.
	 * 
	 * @param node the node to add to the binary search tree
	 */
	public void addNode(Node<A,B> node) {
		if (root == null) {
			if (debug) System.out.println("node " + node.key + " added as root");
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
						if (debug) System.out.println("assigning node " + node.key + " to the parent left child of " + parent.key);
						parent.leftChild = node;
						size++;
						leftSize++;
						return;
					}
				} else {
					currentNode = currentNode.rightChild;
					if (currentNode == null) {
						if (debug) System.out.println("assigning node " + node.key + " to the parent right child of " + parent.key);
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
	 * This is the call back method used when traversing a tree in the chosen order
	 * 
	 * @param orderedNode the current ordered node
	 */
	public abstract void orderedNode(Node<A,B> orderedNode);

	/**
	 * This method is used to traverse the binary tree in descending order, meaning biggest node first, smallest at last.
	 * This is achieved by traversing the right subtree first, visiting the root, and traversing the left subtree.
	 * Every time a node is iterated, the orderedNode function is called with the current node as a parameter
	 * 
	 * @param currentNode the actual focused node
	 */
	public void traverseReverseOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			traverseReverseOrder(currentNode.rightChild);
			orderedNode(currentNode);
			traverseReverseOrder(currentNode.leftChild);
		}
	}
	
	/**
	 * This method is used to traverse the binary tree in ascending order, meaning smallest node first, biggest at last.
	 * This is achieved by traversing the left subtree first, visiting the root, and traversing the right subtree.
	 * Every time a node is iterated, the orderedNode function is called with the current node as a parameter
	 * 
	 * @param currentNode the actual focused node
	 */
	public void traverseInOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			traverseInOrder(currentNode.leftChild);
			orderedNode(currentNode);
			traverseInOrder(currentNode.rightChild);
		}
	}
	
	/**
	 * This method is used to traverse the binary tree in ascending order, meaning smallest node first, biggest at last,
	 * with the exception that the root node is visited first.
	 * This is achieved by visiting the root, traversing the left subtree, and traversing the right subtree.
	 * @param currentNode the actual focused node
	 */
	public void traversePreOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			orderedNode(currentNode);
			traversePreOrder(currentNode.leftChild);
			traversePreOrder(currentNode.rightChild);
		}
	}
	
	/**
	 * This method is used to traverse the binary tree in ascending order, meaning smallest node first, biggest at last,
	 * with the exception that the root node is visited last.
	 * This is achieved by traversing the left subtree first, traversing the right subtree, and visiting the root. 
	 * @param currentNode the actual focused node
	 */
	public void traversePostOrder(Node<A,B> currentNode) {
		if (currentNode != null) {
			traversePostOrder(currentNode.leftChild);
			traversePostOrder(currentNode.rightChild);
			orderedNode(currentNode);

		}
	}

	/**
	 * This method scans the tree to find the node which key matches the key in the parameter. Returns null is the node is not found.
	 * 
	 * @param key the key to find
	 * @return the node found or null if the node is not found
	 */
	public Node<A,B> findNode(A key) {
		Node<A,B> keyNode = new Node<A,B>(key,null);
		Node<A,B> currentNode = root;
		int cmpvalue = -1;
		while (cmpvalue != 0) {
			cmpvalue = compare(keyNode, currentNode);
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
	
	/**
	 * removes a node from the tree
	 * @param key the node key to match for deletion
	 * @return true if the record has been deleted from the tree, false otherwise
	 */
	public boolean removeNode(A key) {
		if (debug) System.out.println("removing node with key " + key);
		// Start at the top of the tree
		Node<A,B> keyNode = new Node<A,B>(key,null);
        Node<A,B> currentNode = root;
        Node<A,B> parent = root;
        int cmpvalue = compare(keyNode, currentNode);
        if (debug) System.out.println("compate value " + cmpvalue);
        // When searching for a Node this will
        // tell us whether to search to the
        // right or left
        boolean isItALeftChild = true;
        // While we haven't found the Node
        // keep looking
        
        //while (focusNode.key != key) {
        while (cmpvalue != 0) {
        	if (debug) System.out.println("examining node " + currentNode.key);
            parent = currentNode;
            // If we should search to the left
            //if (key < focusNode.key) {
            if ( cmpvalue < 0 ) {
                isItALeftChild = true;
                // Shift the focus Node to the left child
                currentNode = currentNode.leftChild;
            } else {
                // Greater than focus node so go to the right
                isItALeftChild = false;
                // Shift the focus Node to the right child
                currentNode = currentNode.rightChild;
            }
            // The node wasn't found
            if (currentNode == null) {
            	if (debug) System.out.println("node " + key + " not found");
                return false;
            }
            cmpvalue = compare(keyNode, currentNode);
            if (debug) System.out.println("compate value " + cmpvalue);
        }
        if (debug) System.out.println("examining node " + currentNode.key);
        if (debug) System.out.println("parent node " + parent.key);
        // If Node doesn't have children delete it
        if (currentNode.leftChild == null && currentNode.rightChild == null) {
        	if (debug) System.out.println("node " + currentNode.key + " does not have children");
            // If root delete it
            if (currentNode == root) {
                root = null;
                size--;
            }
            // If it was marked as a left child
            // of the parent delete it in its parent
            else if (isItALeftChild) {
                parent.leftChild = null;
                leftSize--;
                size--;
            }
            // Vice versa for the right child
            else {
                parent.rightChild = null;
                rightSize--;
                size--;
            }
        }
        // If no right child
        else if (currentNode.rightChild == null) {
        	if (debug) System.out.println("node " + currentNode.key + " does not have right child");
            if (currentNode == root) {
                root = currentNode.leftChild;
                size--;
                leftSize--;
            }
            // If focus Node was on the left of parent
            // move the focus Nodes left child up to the
            // parent node
            else if (isItALeftChild) {
                parent.leftChild = currentNode.leftChild;
                leftSize--;
                size--;
            }
            // Vice versa for the right child
            else {
                parent.rightChild = currentNode.leftChild;
                rightSize--;
                size--;
            }
        }
        // If no left child
        else if (currentNode.leftChild == null) {
        	if (debug) System.out.println("node " + currentNode.key + " does not have left child");
            if (currentNode == root) {
                root = currentNode.rightChild;
                size--;
                rightSize--;
            }
            // If focus Node was on the left of parent
            // move the focus Nodes right child up to the
            // parent node
            else if (isItALeftChild) {
                parent.leftChild = currentNode.rightChild;
                leftSize--;
                size--;
            }
            // Vice versa for the left child
            else {
                parent.rightChild = currentNode.rightChild;
                rightSize--;
                size--;
            }
        }
        // Two children so I need to find the deleted nodes
        // replacement
        else {
        	if (debug) System.out.println("node " + currentNode.key + " have 2 children");
            Node<A,B> replacement = findReplacementNode(currentNode);
            // If the focusNode is root replace root
            // with the replacement
            if (currentNode == root) {
                root = replacement;
                size--;
            }
            // If the deleted node was a left child
            // make the replacement the left child
            else if (isItALeftChild) {
                parent.leftChild = replacement;
                leftSize--;
                size--;
            }
            // Vice versa if it was a right child
            else {
                parent.rightChild = replacement;
                rightSize--;
                size--;
            }
            replacement.leftChild = currentNode.leftChild;
        }
        return true;
    }
	
    /**
     * finds the replacement node for a node with 2 children needing deletion
     * @param nodeToReplace finds the replacement node for deletion for nodes with 2 chidren
     * @return the replacement Node reference
     */
    private Node<A,B> findReplacementNode(Node<A,B> nodeToReplace) {
        Node<A,B> replacementParent = nodeToReplace;
        Node<A,B> replacement = nodeToReplace;
        Node<A,B> focusNode = nodeToReplace.rightChild;
        // While there are no more left children
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild
        if (replacement != nodeToReplace.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = nodeToReplace.rightChild;
        }
        if (debug) System.out.println("replacement node for " + nodeToReplace.key + " is " + replacement.key);
        return replacement;
    }
		
}

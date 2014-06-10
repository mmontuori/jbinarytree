package com.mmontuori.binarytree;

/**
 * Node is the main container for binary search tree nodes. The class contains a key, a value, a left and a right child. Node is used by
 * BinaryTree as the main container.
 * 
 * @author Michael Montuori <michael.montuori@gmail.com>
 * @version 1.0
 *
 * @param <A> is the object to be used as the node key
 * @param <B> is the actual object value to store in the binary tree
 */
public class Node<A,B> {
	
	/**
	 * the key object
	 */
	public A key;
	
	/**
	 * the value object
	 */
	public B value;
	
	/**
	 * the left child containing the key value smaller than the parent
	 */
	public Node<A,B> leftChild;
	
	/**
	 * the right child containing the key value equal or greater than the parent
	 */
	public Node<A,B> rightChild;
	
	/**
	 * The constructor accepts a key and a value object. Which are the basic value to create a bunary search tree node
	 * 
	 * @param key
	 * @param value
	 */
	public Node(A key, B value) {
		this.key = key;
		this.value = value;
	}
		
}

package com.mmontuori.binarytree;

/**
 * 
 * @author michael
 *
 * @param <A>
 * @param <B>
 */
public class Node<A,B> {
	
	/**
	 * 
	 */
	public A key;
	
	/**
	 * 
	 */
	public B value;
	
	/**
	 * 
	 */
	public Node<A,B> leftChild;
	
	/**
	 * 
	 */
	public Node<A,B> rightChild;
	
	/**
	 * @param key
	 * @param value
	 */
	public Node(A key, B value) {
		this.key = key;
		this.value = value;
	}
		
}

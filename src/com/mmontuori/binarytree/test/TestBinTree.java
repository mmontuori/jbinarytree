package com.mmontuori.binarytree.test;

import java.util.Random;

import com.mmontuori.binarytree.*;

public class TestBinTree {
	
	private static final int SIZE = 10000;
	
	public static void main(String[] args) {
		BinaryTree<Integer, String> testTree = new IntStringBinaryTree();
		Random random = new Random();
		int toSearch = 0;
		for ( int i=0; i<SIZE; ++i) {
			int rnd = random.nextInt(10000000);
			Integer key = new Integer(rnd);
			String value = String.valueOf(rnd);
			Node<Integer, String> node = new Node<Integer,String>(key, value);
			testTree.addNode(node);
			if ( SIZE/2 == i ) {
				toSearch = rnd;
				System.out.println("record to search: " + toSearch);
			}
		}
		System.out.println("tree size: " + testTree.getSize());
		System.out.println("tree right size: " + testTree.getRightSize());
		System.out.println("tree left size: " + testTree.getLeftSize());
		//testTree.traverseReverseOrder(testTree.getRoot());
		Integer key = new Integer(toSearch);
		Node<Integer,String> keyNode = new Node<Integer,String>(key, "");
		Node<Integer,String> node = testTree.findNode(keyNode);
		System.out.println("node found: " + ((Integer)node.key).intValue());
	}

}

package com.mmontuori.binarytree.test;

import java.util.Random;

import com.mmontuori.binarytree.*;

public class TestBinTree {
	
	private static final int SIZE = 10;
	
	public static void main(String[] args) {
		BinaryTree<Integer, String> testTree = new IntStringBinaryTree(true);
		Random random = new Random();
		int toSearch = 0;
		for ( int i=0; i<SIZE; ++i) {
			int rnd = random.nextInt(1000);
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

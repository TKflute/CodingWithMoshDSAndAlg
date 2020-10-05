package com.codingwithmosh.dsaa.linkedlist;

import java.util.NoSuchElementException;

// this is Mosh's solution (using ints only)
public class LinkedList {
	
  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  private int size;

  public void addLast(int item) {
    var node = new Node(item);

    if (isEmpty())
      first = last = node;
    else {
      last.next = node;
      last = node;
    }

    size++;
  }
  
  // I have other versions in my CSharpCodingChallenges repo
  public void reverse2() {
	  // this is a swapping version, no copying of values
	  // 10 -> 20 -> 30
	  // 10 <- 20 <- 30
	  // pattern is : 
	  // start on second node (current)
	  // grab next node (next)
	  // reset pointer from current node to point to previous node
	  // bump up both pointer nodes
	  // after loop, reset first and last
	  if (isEmpty()) {
		  return;
	  } 
	  Node previous = first;
	  Node current = first.next;
	  while(current != null) {
		  Node next = current.next;
		  current.next = previous;
		  
		  // this isn't a swap- just bumping both nodes up
		  // was getting confused as to if I was losing previous node value:
		  // Linked Lists are only in order b/c of pointers
		  // so you don't swap order of nodes directly- you swap order of pointers, and then repoint first/last
		  previous = current;
		  current = next;
	  }
	  
	  last = first;
	  last.next = null;
	  first = previous; // (when break out of loop, current will be null)
  }
  
  public void showList() {
		Node cNode = first;
		while(cNode != null) {
			System.out.print(cNode.value + "-->");
			cNode = cNode.next;
		}
			
		System.out.println("NULL");
	}
  public void addFirst(int item) {
    var node = new Node(item);

    if (isEmpty())
      first = last = node;
    else {
      node.next = first;
      first = node;
    }

    size++;
  }

  private boolean isEmpty() {
    return first == null;
  }

  public int indexOf(int item) {
    int index = 0;
    var current = first;
    while (current != null) {
      if (current.value == item) return index;
      current = current.next;
      index++;
    }
    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public void removeFirst() {
    if (isEmpty())
      throw new NoSuchElementException();

    if (first == last)
      first = last = null;
    else {
      var second = first.next;
      first.next = null;
      first = second;
    }

    size--;
  }

  public void removeLast() {
    if (isEmpty())
      throw new NoSuchElementException();

    if (first == last)
      first = last = null;
    else {
      var previous = getPrevious(last);
      last = previous;
      last.next = null;
    }

    size--;
  }

  private Node getPrevious(Node node) {
    var current = first;
    while (current != null) {
      if (current.next == node) return current;
      current = current.next;
    }
    return null;
  }

  public int size() {
    return size;
  }

  public int[] toArray() {
    int[] array = new int[size];
    var current = first;
    var index = 0;
    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }

    return array;
  }

  public void reverse() {
    if (isEmpty()) return;

    var previous = first;
    var current = first.next;
    while (current != null) {
      var next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    last = first;
    last.next = null;
    first = previous;
  }

  public int getKthFromTheEnd(int k) {
    if (isEmpty())
      throw new IllegalStateException();

    var a = first;
    var b = first;
    for (int i = 0; i < k - 1; i++) {
      b = b.next;
      if (b == null)
        throw new IllegalArgumentException();
    }
    while (b != last) {
      a = a.next;
      b = b.next;
    }
    return a.value;
  }

  public void printMiddle() {
    if (isEmpty())
      throw new IllegalStateException();

    var a = first;
    var b = first;
    while (b != last && b.next != last) {
      b = b.next.next;
      a = a.next;
    }

    if (b == last)
      System.out.println(a.value);
    else
      System.out.println(a.value + ", " + a.next.value);
  }

  public boolean hasLoop() {
    var slow = first;
    var fast = first;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast)
        return true;
    }

    return false;
  }

  public static LinkedList createWithLoop() {
    var list = new LinkedList();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    // Get a reference to 30
    var node = list.last;

    list.addLast(40);
    list.addLast(50);

    // Create the loop
    list.last.next = node;

    return list;
  }
}

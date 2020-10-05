package com.codingwithmosh.dsaa.linkedlist;


public class LinkedListDemo {

	private SinglyLinkedList list;
	
	public static void main(String[] args) {
		
		LinkedListDemo demo = new LinkedListDemo();
		demo.createList();
		//demo.showList();
		demo.addToStart();
		demo.showList();
		//System.out.println(demo.get(2).getData());
		//System.out.println(demo.onList());
		ListNode[] nodeArray = new ListNode[4];
		nodeArray = demo.toArray(nodeArray);
		for(ListNode node : nodeArray) {
			System.out.println(node.getData());
		}
		//demo.clear();
		//demo.remove();
		//demo.showList();
		//System.out.println(demo.length());
		System.out.println(demo.indexOf("Patrick"));
		demo.add();
		demo.showList();
		System.out.println(demo.lastIndexOf("Patrick"));
		demo.set(4, "Bill");
		demo.showList();
		demo.add(3, "David");
		demo.showList();
		
		// testing my reverse method imp w/ swapped values (no copying list)
		LinkedList list = new LinkedList();
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		
		list.showList();
		list.reverse2();
		list.showList();
		
	}
		
	public void createList() {
		
		list = new SinglyLinkedList();
		
		list.add("Spongebob");
		list.add("Patrick");
		list.add("Sandy");
	}
	
	public void add() {
		list.add("Patrick");
	}
	
	public void add(int index, String data) {
		list.add(index, data);
	}
	
	public void showList() {
		list.showList();
	}
	
	public void clear() {
		list.clear();
	}
	
	public ListNode get(int index) {
		return list.get(index);
	}
	
	public String set(int index, String data) {
		return list.set(index, data);
	}
	
	public int indexOf(String data) {
		return list.indexOf(data);
	}
	
	public int lastIndexOf(String data) {
		return list.lastIndexOf(data);
	}
	
	public void remove() {
		System.out.println("Remove test");
		
		while(!list.isEmpty()) {
			//remove head
			String nData = list.remove();
			System.out.println(nData);
		}
	}
	
	public int length() {
		return list.size();
	}
	
	
	public boolean onList() {
		
		if(!list.contains("Spongebob")) {
			System.out.println("Error: Spongebob not found");
			return false;
		}
		
		if(!list.contains("Patrick")) {
			System.out.println("Error: Patrick not found");
			return false;
		}
		
		if(!list.contains("Sandy")) {
			System.out.println("Error: Sandy not found");
			return false;
		}
		
		if(list.contains("Larry")) {
			System.out.println("Error: Larry should not be found");
			return false;
		}
		
		return true;
	}
	
	public void addToStart() {
		list.addToStart("Susie");
	}
	
	public ListNode[] toArray(ListNode[] nodeArray) {
		return list.toArray(nodeArray);
	}
}
package com.codingwithmosh.dsaa.stack;

import java.util.ArrayList;

public class Stack {

	// if asked to implement a data structure, check if there are requirements of members/methods
	// ask interviewer: what is the data structure of the elements inside the Stack? Should use Generics? Or simple array of ints?
	// Java Brains used int array
	// if using array, don't need to remove item for pop, just change top
	// then next time adding element, will override
	 
	// Members:
	// array[n] or ArrayList, etc.
	// capacity (n) if using array
	// top (tracks current top of Stack and makes array function as Stack)
	
	// Methods:
	// push
	// pop
	// peek
	// empty
	// size 
	
	private ArrayList<Object> stack;
	//private int capacity;
	private int top;
	
//	public Stack(Object obj, int capacity, int top) {
//		stack = new Object[] {};
//		stack[]
//	}
//	
	public Stack() {
		stack = new ArrayList<>();
		top = -1;
	}
	
	public void push(Object obj) {
		top++;
		stack.add(top, obj);
	}
	
	public Object pop() {
		
		if(!empty()) {
			Object last = stack.get(top);
			stack.remove(top);
			top--;
			return last;
		}
		return null;	
	}
	
	public Object peek() throws RuntimeException {

		if (!empty()) {
			Object last = stack.get(top);
			return last;
		}
		// ask interviewer about handling operations on empty stack
		// this is better than returning null
		throw new RuntimeException("Stack is empty");
	}
	
	public boolean empty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return stack.size();
	}

}

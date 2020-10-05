package com.codingwithmosh.dsaa.arrays;

public class Array {
	
	private int[] items;
	private int count;
	
	
	public Array(int length) {
		
		items = new int[length];
	}
	
	public void insert(int value) {	

		if(items.length == count) {
			
			resize();
		}

		items[count++] = value;
	}
	
	
	public void removeAt(int index) {
		
		// validate index
		if(index < 0 || index >= count) { // (if count is 4, last index is 3)
			throw new IllegalArgumentException();
		}
		
		// shift items to left to fill empty slot
		// **Mosh had i < count, not count -1
		// but if I allocate the exact space I need for my array when initializing,
		// and it hasn't been resized yet - will get OOB exception
		for(int i = index; i < count - 1; i++) {
			items[i] = items[i + 1];
		}
		
		count--; // there will still be an item leftover in the array, but we won't track it
	}
	
	public int indexOf(int value) {
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	//1- Solution: Array.max() 
	// Extend the Array class and add a new method to return the largest number. 
	// What is the runtime complexity of this method? : O(n)
	public int findMax() {
		int max = items[0];
		for(int i = 0; i < count; i++) {
			if(items[i] > max) {
				max = items[i];
			}
		}
		return max;
	}
	
	public void resize() {
		
		int[] copy = new int[count * 2];
		for(int i = 0; i < count; i++) {
			copy[i] = items[i];
		}
		
		items = copy;
	}
	
	// 2- Solution: Array.intersect() 
	// Extend the Array class and add a method to return the common items in this array
	// and another array.   
	// 5, 2, 6, 4 -> 3, 6, 2, 1  RTC: O(n^2)
	// how to avoid having empty slots in intersect array? Can I use a List of Integers?
	// how to improve perf. of this one w/ manual solution?
	public int[] intersect(int[] otherItems) {
		
		int length;
		if(items.length <= otherItems.length) {
			length = items.length;
		}else {
			length = otherItems.length;
		}
		int[] intersect = new int[length];
		int index = 0;
		
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < otherItems.length; j++) {
				if(items[i] == otherItems[j]) {
					intersect[index++] = items[i];
				}
			}
		}
		return intersect;
	}
	
	// 3- Solution: Array.reverse()
	// Extend the Array class and add a method to reverse the array. 
	// For example, if the array includes [1, 2, 3, 4], after reversing and printing it, 
	// we should see [4, 3, 2, 1].  
	// Big O(n)
	public void reverse() {
		int[] copy = new int[count];
		for(int i = count - 1; i >= 0; i--) {
			copy[(count - 1) - i] = items[i];
		}
		items = copy;
	}
	
	// 4-  Solution: Array.insertAt()
	// Extend the Array class and add a new method to insert an item at a given index:
	// O(n)?
	public void insertAt(int item, int index) {
		
		// resize if there is no room left (if length == count) and shift to the right
		// 1, 2, 4, 5 -> add 3 at index 2 -> 
		// resize if full, insert 3 at index 2 and shift 4 and 5 to right
		if(items.length == count) {
			resize();
		}
		
		// just one insert; this stays outside of loop (but need to save old num)
		int temp = items[index];
		items[index] = item;
		count++;
		// shifting needs the loop
		for(int i = index + 1; i < count; i++) {
			int temp2 = items[i];
			items[i] = temp;
			temp = temp2;
		}
	}
	
	
	public void print() {

		for(int i = 0; i < count; i++) {
			System.out.println(items[i]);
		}
	}

}

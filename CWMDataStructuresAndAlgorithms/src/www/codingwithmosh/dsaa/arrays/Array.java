package www.codingwithmosh.dsaa.arrays;

public class Array {

	// this class should allow to:
	// make a new Array with new keyword, passing in a length
	// needs an internal array to store values
	// when add new items, automatically grow, when remove, automatically shrink***
	// it should have an insert method that can take any type of primitive/object? (not sure, just ints was shown) (must grow)
	// should have a removeAt method that takes an index and removes that element (must shrink)
	// print method? Mosh included it for convenience but says it wouldn't be included - prints each value
	// should have an indexOf method that returns index of value passed in, -1 if value doesn't exist
	
	private int[] internalArr;
	// this I didn't think to do on first solution:
	private int count;
	
	
	public Array(int length) {
		
		internalArr = new int[length];
//		for(int i = 0; i < internalArr.length; i++) {
//			internalArr[i] = -1;
//		}
	}
	
	// inserting at first empty slot if it exists
	// if no empty slots, need to resize/grow by one
	// can't call methods to see if empty, and can't check if equals 0
	// for now, set all to -1
	public void insert(int value) {	
		// this was first version w/ using -1 for empties
		// need to resize b/c array is full
//		if(internalArr[internalArr.length -1] != -1) {
//			internalArr = growArrayByOne(value);
//		}else {
//			
//			for(int i = 0; i < internalArr.length; i++) {
//				if(internalArr[i] == -1) {
//					internalArr[i] = value;
//					break;
//				}
//			}
//		}
		

		// count by default is 0- need to increment every time we add
		if(internalArr.length == count) {
			internalArr = growArrayByOne(value);
		}

		internalArr[count++] = value;
	}
	
	public int[] growArrayByOne(int newValue) {
		
		int[] copy = new int[internalArr.length + 1];
		for(int i = 0; i < internalArr.length; i++) {
			copy[i] = internalArr[i];
		}
		copy[copy.length - 1] = newValue;
		return copy;
	}
	
	public void removeAt(int index) {
		
		// 1, 2, 3, 4, 5 -> remove index 2 -> 1, 2, 4, 5
		// def will need to make new array with length-1 size
		// how to copy right values? - can skip iteration when on that index
		
		int[] copy = new int[internalArr.length - 1];
		int copyIndex = 0;
		for(int i = 0; i < internalArr.length; i++) {
			if(i == index) {
				continue;
			}else {
				copy[copyIndex] = internalArr[i];
				copyIndex++;
			}
		}
		// duh! don't forget these kinds of steps
		internalArr = copy;
	}
	
	public int indexOf(int value) {
		// can do binary search here if sorted- but is that faster?
//		int l = 0;
//		int u = internalArr.length -2;
//		
//		while(l <= u) {
//			int m = (l + u) / 2;
//			if(internalArr[m] == value) {
//				return m;
//			}else if(internalArr[m] > value) {
//				// search left
//			}
//		}
		
		for(int i = 0; i < internalArr.length; i++) {
			if(internalArr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public void print() {
		// first version
//		for(int val : internalArr) {
//			System.out.println(val);
//		}
		
		// using count
		for(int i = 0; i < count; i++) {
			System.out.println(internalArr[i]);
		}
	}

}

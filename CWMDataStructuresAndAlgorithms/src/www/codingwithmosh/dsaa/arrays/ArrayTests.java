package www.codingwithmosh.dsaa.arrays;

public class ArrayTests {

	public static void main(String[] args) {
		
		Array numbers = new Array(5);
		// at initialization, should all be -1
		numbers.print();
		// should be 10, followed by 4 -1's 
		// (this is for testing- his example didn't show printing empty values)
		numbers.insert(10);
		numbers.print();
		numbers.insert(20);
		numbers.print();
		
		numbers.insert(30);
		numbers.print();
		numbers.removeAt(1);
		// should be 10, 30, -1, -1
		System.out.println("Remove results:\n");
		numbers.print();
		
		System.out.println("Index of:");
		// should be 1
		System.out.println(numbers.indexOf(30));
		// should be -1
		System.out.println(numbers.indexOf(50));

	}

}

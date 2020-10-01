package www.codingwithmosh.dsaa.arrays;

public class ArrayTests {

	// Vector: grows by 100% when resized, and is synchronized
	// ArrayList: grows by 50%; not synchronized
	public static void main(String[] args) {
		
		Array numbers = new Array(5);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.insert(50);
		numbers.print();
		//numbers.removeAt(3);
		//numbers.print();

		System.out.println(numbers.indexOf(30));
		System.out.println(numbers.findMax());
		int[] otherItems = {30, 70, 50};
		int[] intersect = numbers.intersect(otherItems);
		for(int num : intersect) {
			System.out.println(num);
		}
		//numbers.reverse();
		//numbers.print();
		numbers.insertAt(25, 2);
		numbers.print();
	}

}

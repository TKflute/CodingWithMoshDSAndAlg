package com.codingwithmosh.dsaa.stack;
import java.util.Stack;

public class ReverseString {

	// should move this to diff class
	public static void main(String[] args) {
		
		//Create a method that takes a string, reverses it, and returns reversed string
		// can use built in methods
		String hello = "Hello";
		System.out.println(reverseString(hello));
		
		//Part 1: Create a second method that doesn't use built in methods to reverse string
		String world = "World";
		System.out.println(reverseString2(world));
		//Part 2: Reverse each word individually for string w/ mult words
		String helloWorld = "Hello World";
		System.out.println(reverseString3(helloWorld));
		System.out.println(reverseStringWithStack(hello));
		
		// BalancedExpression
		String exp = "([1] + <2> == {3})";

	}
	
	public static String reverseString(String str) {
		
		StringBuilder sBuild = new StringBuilder(str);
		sBuild.reverse();
		return sBuild.toString();
	}
	
	public static String reverseString2(String str) {

		StringBuilder sBuild = new StringBuilder();
		for(int i = str.length() -1; i >= 0; i--) {
			sBuild.append(str.charAt(i));
		}
		
		return sBuild.toString();
	}
	
	public static String reverseString3(String str) {
		
		String[] words = str.split(" ");
		StringBuilder sBuild1 = new StringBuilder();
		
		for(String word : words) {
			StringBuilder sBuild2 = new StringBuilder(word);
			sBuild2.reverse();
			sBuild1.append(sBuild2 + " ");
		}
		
		return sBuild1.toString().trim();
	}
	
	public static String reverseStringWithStack(String input) {
		
		if(input == null) {
			throw new IllegalArgumentException();
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : input.toCharArray()) {
			stack.push(c);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.empty()){
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}

}

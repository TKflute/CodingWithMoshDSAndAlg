package com.codingwithmosh.dsaa.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalancedExpression {

	// use a stack to determine if brackets in a string match
	// i.e. (([1] + [2]))<a>;  not )[1] + 2(;
	// add brackets to stack - ignore other chars
	
	// Use two Sets? One for kinds of opening brackets and one for closing brackets
	// then search last half of stack and do set.contains() for closing
	// set.contains for opening for remaining half
	
	@SuppressWarnings("deprecation")
	public static boolean isBalancedExpression(String exp) {
		
		Set<Character> opBrackets = new HashSet<Character>();
		opBrackets.add(new Character('<'));
		opBrackets.add(new Character('['));
		opBrackets.add(new Character('{'));
		opBrackets.add(new Character('('));
		
		Set<Character> clBrackets = new HashSet<Character>();
		clBrackets.add(new Character('>'));
		clBrackets.add(new Character(']'));
		clBrackets.add(new Character('}'));
		clBrackets.add(new Character(')'));
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : exp.toCharArray()) {
			
			if(opBrackets.contains(c) || clBrackets.contains(c)) {
				stack.push(c);
			}
		}
		
		// for now do two loops - one for last half and one for first half, for clarity
		// for odd length expressions, make sure loops are not same num of iterations
		
		int first = stack.size() / 2;  // first isn't the best name
		int second = stack.size() % 2; // first and second should match if balanced- return false if not
		if(first != second) {
			return false;
		}
		
		for(int i = 0; i < first; i++) {
			if(!clBrackets.contains(stack.pop())) {
				return false;
			}
		}
		
		for(int i = 0; i < second; i++) {  // there's no need to say second; could clean this up
			if(!opBrackets.contains(stack.pop())) {
				return false;
			}
		}
		return true;
	}
}

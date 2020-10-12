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
	// my first version- contains some good ideas but doesn't work yet 
	// (checking number of opening and closing but not order)
	public boolean isBalancedExpression(String exp) {
		
		// "([1] + <2> == {3})"
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
	
	// following along w/ Mosh's process - step 1, check cases only for parens
	// this works for both (1 + 2) and ((((1 + 2)))) b/c will simply skip a push or pop
	public boolean isBalancedStep1(String input) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch : input.toCharArray()) {
			if(ch == '(') {
				stack.push(ch);
			}
			if(ch == ')') {
				if(stack.isEmpty()) {
					return false; // to avoid an EmptyStackException
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
	
	// accounting for other types of brackets
	public boolean isBalancedStep2(String input) {
		Stack<Character> stack = new Stack<>();

		for (char ch : input.toCharArray()) {
			if (ch == '(' || ch == '<' || ch == '[' || ch == '{') {
				stack.push(ch);
			}
			if (ch == ')' || ch == '>' || ch == ']' || ch == '}') {
				if(stack.isEmpty()) {
					return false; // to avoid an EmptyStackException
				}
				var top = stack.pop();
				if(
					(ch == '(' && top != ')') ||
					(ch == '<' && top != '>') ||
					(ch == '[' && top != ']') ||
					(ch == '{' && top != '}')
				) return false;
			}
		}
		return stack.isEmpty();
	}
	
   // first refactor - using private methods to check for matches
	public boolean isBalancedStep3(String input) {
		Stack<Character> stack = new Stack<>();

		for (char ch : input.toCharArray()) {
			if (isLeftBracket(ch)) {
				stack.push(ch);
			}
			if (isRightBracket(ch)) {
				if(stack.isEmpty()) {
					return false; // to avoid an EmptyStackException
				}
				var top = stack.pop();
				if(!bracketsMatch(top, ch)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
		
	private boolean isLeftBracket(char ch) {
		return ch == '(' || ch == '<' || ch == '[' || ch == '{';
	}
	
	private boolean isRightBracket(char ch) {
		return ch == ')' || ch == '>' || ch == ']' || ch == '}';
	}
	
	// he had != instead of ==
	// that would return true when they don't match
	private boolean bracketsMatch(char left, char right) {
		return	(right == ')' && left == '(') ||
				(right == '>' && left == '<') ||
				(right == ']' && left == '[') ||
				(right == '}' && left == '{');
	}
}

package org.malibu.projecteuler;

public class Problem2 {
	public static void main(String[] args) {
		Problem2 problem2 = new Problem2();
		System.out.println("max of 4 mil: " + problem2.findFibEvenSum(4000000));
	}
	
	public int findFibEvenSum(int maxTerm) {
		int i = 1, j = 1;
		int currentTerm = 0;
		int sum = 0;
		while(currentTerm < maxTerm) {
			if(isEven(currentTerm)) {
				sum += currentTerm;
			}
			currentTerm = i + j;
			i = j;
			j = currentTerm;
		}
		return sum;
	}
	
	private boolean isEven(int number) {
		return (number & 1) == 0;
	}
}

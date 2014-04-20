package org.malibu.projecteuler;

public class Problem5 {
	public static void main(String[] args) {
		Problem5 problem5 = new Problem5();
		System.out.println("1 to 20 value: " + problem5.findSmallestNumberDivisibleByAllNumsInRange(1, 20));
	}
	
	public int findSmallestNumberDivisibleByAllNumsInRange(int startRange, int endRange) {
		int numberOfInterest = 1;
		for(int i = startRange; i <= endRange; i++) {
			if(numberOfInterest % i != 0) {
				numberOfInterest++;
				i = startRange;
			}
		}
		return numberOfInterest;
	}
}

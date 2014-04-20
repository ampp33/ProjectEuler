package org.malibu.projecteuler;

public class Problem6 {
	public static void main(String[] args) {
		Problem6 problem6 = new Problem6();
		System.out.println("Diff between sum of sqrs and sqr of sums (1-100): " + problem6.findDiffBetweenSumOfSqrsAndSqrOfSums(1, 100));
	}
	
	public int findDiffBetweenSumOfSqrsAndSqrOfSums(int startRange, int endRange) {
		int sum = 0, sumOfSquares = 0;
		for(int i = startRange; i <= endRange; i++) {
			sumOfSquares += i*i;
			sum += i;
		}
		return ((sum*sum) - sumOfSquares);
	}
}

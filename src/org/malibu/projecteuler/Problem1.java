package org.malibu.projecteuler;

public class Problem1 {
	public static void main(String[] args) {
		Problem1 problem1 = new Problem1();
		System.out.println("using 3 or 5: " + problem1.sumOfMultiples(1000, 3, 5));
	}
	
	public int sumOfMultiples(int max, int... numbers) {
		int sum = 0;
		for(int i = 1; i < max; i++) {
			for(int j = 0; j < numbers.length; j++) {
				if(isMultiple(i, numbers[j])) {
					sum += i;
					break;
				}
			}
		}
		return sum;
	}
	
	private boolean isMultiple(double x, double y) {
		double division = x/y;
		return division == (int)division;
	}
}

package org.malibu.projecteuler;


public class Problem15 {
	public static void main(String[] args) {
		Problem15 p15 = new Problem15();
		System.out.println("number of paths: " + p15.getNumberOfPathsFromTLToLR(20, 20));
	}
	
	/**
	 * Needs to use BigInt
	 * 
	 * @param arrayHeight
	 * @param arrayWidth
	 * @return
	 */
	public long getNumberOfPathsFromTLToLR(long arrayHeight, long arrayWidth) {
		return factorial(arrayHeight + arrayWidth, 20) / (factorial(arrayHeight, 1));
	}
	
	private long factorial(long startValue, long endValue) {
		long result = 1;
		while(startValue >= endValue) {
			result *= startValue--;
		}
		return result;
	}
}

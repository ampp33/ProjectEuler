package org.malibu.projecteuler;

public class Problem9 {
	public static void main(String[] args) {
		Problem9 p9 = new Problem9();
		System.out.println("Pythagorean triplet 1000 sum product: " + p9.findPythagoreanTriplet1000SumProduct());
	}
	
	public int findPythagoreanTriplet1000SumProduct() {
		int diff = 1, m = 1, n = m + diff, sum = 0;
		int[] pyTriplet = {0,0,0};
		while(sum != 1000) {
			pyTriplet = findPythagoreanTriplet(m, n);
			sum = arrayMemberSum(pyTriplet);
			if(sum > 1000) {
				diff++;
				m = 1; n = m + diff;
			} else {
				m++; n++;
			}
		}
		return pyTriplet[0] * pyTriplet[1] * pyTriplet[2];
	}
	
	private int arrayMemberSum(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) sum += array[i];
		return sum;
	}
	
	private int[] findPythagoreanTriplet(int m, int n) {
		int[] result = new int[3];
		result[0] = n*n - m*m;
		result[1] = 2*n*m;
		result[2] = n*n + m*m;
		return result;
	}
}

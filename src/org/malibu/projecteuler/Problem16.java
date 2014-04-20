package org.malibu.projecteuler;

import java.math.BigInteger;

public class Problem16 {
	public static void main(String[] args) {
		Problem16 p16 = new Problem16();
		System.out.println("sum of digits: " + p16.findSumOfDigits(new BigInteger("2").pow(1000)));
	}
	
	public int findSumOfDigits(BigInteger number) {
		int value = 0;
		String numberAsString = number.toString();
		for(int i = 0; i < numberAsString.length(); i++) {
			value += (numberAsString.charAt(i) - '0');
		}
		return value;
	}
}

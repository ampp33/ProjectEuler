package org.malibu.projecteuler;

public class Problem4 {
	public static void main(String[] args) {
		Problem4 problem4 = new Problem4();
		System.out.println("largest palindrome: " + problem4.findLargestPalindromeFromNumberProducts(3));
	}
	
	public int findLargestPalindromeFromNumberProducts(int maxDigits) {
		int maxNumber = findLargestNumberWithDigitLimit(maxDigits);
		int minNumber = findSmallestNumberWithDigitLimit(maxDigits);
		int largestPalindrome = 0;
		int product = 0;
		for(int i = maxNumber; i >= minNumber; i--) {
			for(int j = maxNumber; j >= minNumber; j--) {
				product = i*j;
				if(isPalindrome(product) && product > largestPalindrome) {
					largestPalindrome = product;
				}
			}
		}
		return largestPalindrome;
	}
	
	private boolean isPalindrome(int number) {
		if(number < 0) return false;
		String numAsString = number + "";
		int start = 0, end = numAsString.length() - 1;
		while(start <= end) {
			if(numAsString.charAt(start) != numAsString.charAt(end)) return false;
			start++; end--;
		}
		return true;
	}
	
	// find largest possible number with the digit limit
	private int findLargestNumberWithDigitLimit(int digitLimit) {
		String maxNumberString = "";
		for(;digitLimit > 0; digitLimit--) maxNumberString+="9";
		return Integer.parseInt(maxNumberString);
	}
	
	// find smallest possible number with the digit limit
	private int findSmallestNumberWithDigitLimit(int digitLimit) {
		String minNumberString = "1";
		for(;digitLimit > 1; digitLimit--) minNumberString+="0";
		return Integer.parseInt(minNumberString);
	}
}

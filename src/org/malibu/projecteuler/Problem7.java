package org.malibu.projecteuler;

public class Problem7 {
	public static void main(String[] args) {
		Problem7 problem7 = new Problem7();
		System.out.println("10001th prime: " + problem7.findNthPrime(10001));
	}
	
	public int findNthPrime(int nthPrime) {
		int prime = 1;
		for(int i = 0; i < nthPrime; i++) {
			prime = findNextPrime(prime);
		}
		return prime;
	}
	
	private int findNextPrime(int startNumber) {
		if(startNumber < 2) return 2;
		startNumber++;
		if(isEven(startNumber)) startNumber++;
		while(!isPrime2(startNumber)) startNumber+=2;
		return startNumber;
	}
	
	private boolean isPrime(int number) {
		if(number < 2) return false;
		if(number == 2) return true;
		if(isEven(number)) return false;
		for(int potentialMultiple = number - 2; potentialMultiple > 1; potentialMultiple-=2) {
			if(isFactor(number, potentialMultiple)) return false;
		}
		return true;
	}
	
	private boolean isPrime2(int number) {
		int up = (int)Math.sqrt(number);
		for(int i = 2; i < up + 1; i++) {
			if(number%i == 0) return false;
		}
		return true;
	}
	
	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
	
	private boolean isFactor(double number, double potentialFactor) {
		return number % potentialFactor == 0;
	}
}

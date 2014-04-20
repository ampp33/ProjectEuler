package org.malibu.projecteuler;

public class Problem10 {
	public static void main(String[] args) {
		Problem10 p10 = new Problem10();
		System.out.println("sum of primes less than 2mil: " + p10.calcSumOfConsecPrimes(2000000));
	}
	
	public long calcSumOfConsecPrimes(int maxPrimeLimit) {
		int prime = 1;
		long sum = 0;
		while((prime = findNextPrime(prime)) < maxPrimeLimit) {
			sum += prime;
		}
		return sum;
	}
	
	private int findNextPrime(int startNumber) {
		if(startNumber < 2) return 2;
		startNumber++;
		if(isEven(startNumber)) startNumber++;
		while(!isPrime2(startNumber)) startNumber+=2;
		return startNumber;
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
}

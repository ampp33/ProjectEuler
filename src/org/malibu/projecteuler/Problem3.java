package org.malibu.projecteuler;


public class Problem3 {
	public static void main(String[] args) {
		Problem3 problem3 = new Problem3();
		System.out.println("max prime factor of 600851475143: " + problem3.findMaxPrimeFactor(600851475143L));
	}
	
	public long findMaxPrimeFactor(long number) {
		int prime = 2;
		while(prime != number) {
			if(!isFactor(number, prime)) {
				prime = findNextPrime(prime);
			} else {
				number /= prime;
			}
		}
		return prime;
	}
	
	private int findNextPrime(int startNumber) {
		if(startNumber < 2) return 2;
		startNumber++;
		if(isEven(startNumber)) startNumber++;
		while(!isPrime(startNumber)) startNumber+=2;
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
	
	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
	
	private boolean isFactor(double number, double potentialFactor) {
		return number % potentialFactor == 0;
	}
}

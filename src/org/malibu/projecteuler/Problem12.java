package org.malibu.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem12 {
	public static void main(String[] args) {
		Problem12 p12 = new Problem12();
		System.out.println("first triangle number with over 500 divisors: " + p12.findTriangleNumberByNumberOfDivisors(500));
	}
	
	public int findTriangleNumberByNumberOfDivisors(int minNumDivisors) {
		int triangleNumber = 0;
		int numDivisors = 0;
		for(int i = 0; (numDivisors = getNumberOfDivisors(triangleNumber)) <= minNumDivisors; i++) {
			triangleNumber += i;
			//System.out.println(triangleNumber + ": " + numDivisors);
		}
		return triangleNumber;
	}
	
	private int getNumberOfDivisors(int number) {
		if(number == 0) return 0;
		int divisorCount = 0, prime = 2;
		List<Integer> primeCounterList = new ArrayList<Integer>();
		while(number != 1) {
			if(!isFactor(number, prime)) {
				if(divisorCount > 0) primeCounterList.add(divisorCount);
				divisorCount = 0;
				prime = findNextPrime(prime);
			} else {
				divisorCount++;
				number /= prime;
			}
		}
		if(divisorCount > 0) primeCounterList.add(divisorCount);
		int numOfDivisors = 1;
		for (Integer primeCounter : primeCounterList) {
			numOfDivisors *= (primeCounter + 1);
		}
		return numOfDivisors;
	}
	
	private List<Integer> primeCache = new ArrayList<Integer>();
	
	private int findNextPrime(int startNumber) {
		// check if next prime number is in the cache
		if(primeCache.indexOf(startNumber) + 1 < primeCache.size()) {
			// get next prime in the cache
			startNumber = primeCache.get(primeCache.indexOf(startNumber) + 1);
		} else {
			if(startNumber < 2) {
				primeCache.add(2);
				return 2;
			}
			startNumber++;
			if(isEven(startNumber)) startNumber++;
			while(!isPrime2(startNumber)) startNumber+=2;
			// cache prime
			primeCache.add(startNumber);
		}
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
	
	private boolean isFactor(double number, double potentialFactor) {
		return number % potentialFactor == 0;
	}
}

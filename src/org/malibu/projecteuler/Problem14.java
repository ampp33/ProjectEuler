package org.malibu.projecteuler;

public class Problem14 {
	public static void main(String[] args) {
		Problem14 p14 = new Problem14();
		System.out.println("value: " + p14.getLongestNumberChain(1000000));
	}
	
	public int getLongestNumberChain(int maxStartingPoint) {
		int maxLength = 0, maxLengthValue = 0, currentLength = 0;
		for(int i = 1; i < maxStartingPoint; i++) {
			if((currentLength = getChainLength(i)) > maxLength) {
				maxLength = currentLength;
				maxLengthValue = i;
			}
//			System.out.println(i + " : " + currentLength);
		}
		return maxLengthValue;
	}
	
	private int getChainLength(long value) {
		int length = 2;
//		System.out.print(value + ": ");
//		System.out.print(value + ", ");
		while((value = getNextChainValue(value)) != 1) {
//			System.out.print(value + ", ");
			length++;
		}
//		System.out.println(1);
		return length;
	}
	
	private long getNextChainValue(long value) {
		if(isEven(value)) {
			return value / 2;
		} else {
			return 3 * value + 1;
		}
	}
	
	private boolean isEven(long value) {
		return (value & 1) == 0;
	}
}

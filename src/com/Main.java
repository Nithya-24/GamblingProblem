package com;

public class Main {
	public static void main(String[] args) {
		Gambling gambler = new Gambling();
//		gambler.bet();
		
		while (true) {
		if(!gambler.continueNextMonth()) {
			System.out.println("Lost in gambling. So not playing next month");
			break;
			
		} else {
			System.out.println("Won the month, so playing again.");
			
		}
		}
		
	}
}


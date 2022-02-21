package com;

public class Gambling {
	int stake;
	int initialStake;
	int betAmount ;
	double winningAmount;
	double losingAmount;
	int numberOfDays = 20;
	int totalAmountWon = 0;
	int totalAmountLost = 0;
	
	void initiateBetting() {
		stake = 100;
		initialStake = stake;
		betAmount = 1;
		winningAmount = initialStake + (initialStake / 2);
		losingAmount = initialStake - (initialStake / 2);
	}
	
	void bet(){
		int winOrLoss = (int) Math.round( (Math.random() ) );
		
		if(winOrLoss == 1) {
			stake = stake + 1;
			//System.out.println( " Won the Game and Dollar Value is: " + stake);
		}
		else {
			stake = stake - 1;
			//System.out.println ( "Loss the Game and the Dollar value is: " +stake);
		}
	}
	
	boolean gamblerLeavingStage() {
		
		while(stake < winningAmount || stake > losingAmount) {
			
			bet();
			
			if(stake == winningAmount) {
				totalAmountWon = totalAmountWon + (initialStake / 2);
				return false;
			}
			else if(stake == losingAmount) {
				totalAmountLost = totalAmountLost + (initialStake / 2);
				return true;
			}
		}		
		return true;
	}
	
	boolean continueNextMonth() {
		for (int i = 1; i <= numberOfDays; i ++ ) {
			initiateBetting();
			boolean isGamblerLeft = gamblerLeavingStage();
			if(isGamblerLeft) {
				System.out.println("Day "+i+": Gambler lost 50%");
			} else {
				System.out.println("Day "+i+": Gambler won 50%");
			}
		}
		
		System.out.println("Total Winning Amount this month: " + totalAmountWon);
		System.out.println("Total Losing Amount this month: " + totalAmountLost);
		
		if(totalAmountWon > totalAmountLost) {
			return true;
		} else {
			return false;
		}
		
	}
}

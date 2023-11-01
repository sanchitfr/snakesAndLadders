package com.practice.snl.models;

import java.util.Random;

public class DiceService {
//	private static int numDice;
	
//	public DiceService(int numDice) {
//		this.numDice = numDice;
//	}
	
	public static int rollDice() {
		return new Random().nextInt(6)+1;
	}
	
}

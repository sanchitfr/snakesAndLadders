package com.practice.snl.models;

import java.util.ArrayList;
import java.util.Scanner;

import com.practice.snl.models.Snake;
import com.practice.snl.models.Ladder;
import com.practice.snl.models.Player;

public class Driver {
	
	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Snake> snakes = new ArrayList<>();
		System.out.println("Number of snakes?");
		int noOfSnakes = scanner.nextInt();
		for(int i = 0; i<noOfSnakes; i++) {
			System.out.println("enter the starting and ending position of snake number " + i);
			snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
		}
		
		ArrayList<Ladder> ladders = new ArrayList<>();
		System.out.println("Number of ladders?");
		int noOfLadders = scanner.nextInt();
		for(int i = 0; i<noOfLadders; i++) {
			System.out.println("enter the starting and ending position of ladder number " + i);
			ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
		}
		
		System.out.println("Number of players?");
		
		int noOfPlayers = scanner.nextInt();
		
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i<noOfPlayers; i++) {
			System.out.println("Write the name of player number " + i);
			players.add(new Player(scanner.next()));
		}
		
		SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService();
		snakesAndLaddersService.setLadders(ladders);
		snakesAndLaddersService.setSnakes(snakes);
		snakesAndLaddersService.setPlayers(players);
		
		snakesAndLaddersService.startGame();
		
	}

}

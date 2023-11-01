package com.practice.snl.models;

import java.util.*;

import com.practice.snl.models.*;

public class SnakesAndLaddersService {
	
	private SnakeAndLadderBoard snakeAndLadderBoard;
	private int numberOfIntitialPlayers;
	private Queue<Player> playerTurn;
	
	private static final int DEFAULT_BOARD_SIZE = 100;
	private static final int DEFAULT_NUM_DICE = 1;
	
	public SnakesAndLaddersService(int boardSize) {
		this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
		this.playerTurn = new LinkedList<Player>();
	}
	
	public SnakesAndLaddersService() {
		this.snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_BOARD_SIZE);
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.playerTurn = new LinkedList<>();
		this.numberOfIntitialPlayers = players.size();
		
		HashMap<String, Integer> playerPositions = new HashMap<>();
		for(Player player : players) {
			this.playerTurn.add(player);
			playerPositions.put(player.getPlayerName(), 0);
		}
		snakeAndLadderBoard.setPlayerPositions(playerPositions);
	}
	
	public void setSnakes(ArrayList<Snake> snakes) {
		snakeAndLadderBoard.setSnakes(snakes);
	}
	
	public void setLadders(ArrayList<Ladder> ladders) {
		snakeAndLadderBoard.setLadders(ladders);
	}
	
	private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
		int previousPosition;
		
		do {
			previousPosition = newPosition;
			
			List<Snake> snakes = snakeAndLadderBoard.getSnakes();
			for(Snake snake : snakes) {
				if(snake.getStart() == newPosition) newPosition = snake.getEnd();
			}
			
			List<Ladder> ladders = snakeAndLadderBoard.getLadders();
			for(Ladder ladder : ladders) {
				if(ladder.getStart() == newPosition) newPosition = ladder.getEnd();
			}
			
		}while(newPosition != previousPosition);
		
		return newPosition;
	}
	
	private void movePlayer(Player player, int rollCount) {
		int oldPosition = snakeAndLadderBoard.getPlayerPositions().get(player.getPlayerName());
		int newPosition = oldPosition + rollCount;
		
		int boardSize = snakeAndLadderBoard.getSize();
		
		if(newPosition > boardSize) newPosition = oldPosition;
		else {			
			newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
		}
		
		snakeAndLadderBoard.getPlayerPositions().put(player.getPlayerName(), newPosition);
		
		System.out.println(player.getPlayerName() + " has rolled a " + rollCount + " and has moved from " + oldPosition + " to " + newPosition);
	}
	
	private int getDiceRollNum() {
		return DiceService.rollDice();
	}
	
	private boolean hasPlayerWon(Player player) {
		int currentPosition = snakeAndLadderBoard.getPlayerPositions().get(player.getPlayerName());
		int boardSize = snakeAndLadderBoard.getSize();
		return currentPosition == boardSize;

	}
	
	private boolean isGameComplete() {
		return playerTurn.size() < numberOfIntitialPlayers;
	}
	
	public void startGame() {
		while(!isGameComplete()) {
			Player player = playerTurn.poll();
			int rollCount = getDiceRollNum();
			movePlayer(player, rollCount);
			if(hasPlayerWon(player)) {
				System.out.println(player.getPlayerName() + " has won the game.");
				snakeAndLadderBoard.getPlayerPositions().remove(player.getPlayerName());
			}
			else {
				playerTurn.add(player);
			}
		}
	}

}

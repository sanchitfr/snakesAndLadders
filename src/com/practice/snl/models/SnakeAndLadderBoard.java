package com.practice.snl.models;

import java.util.*;

public class SnakeAndLadderBoard {
	
	private int size;
	private List<Snake> snakes;
	private List<Ladder> ladders;
	private Map<String, Integer> playerPositions;
	
	public SnakeAndLadderBoard(int size) {
		this.size = size;
		this.snakes = new ArrayList<Snake>();
		this.ladders = new ArrayList<Ladder>();
		this.playerPositions = new HashMap<String,Integer>();
	}
	
	public int getSize() {
		return size;
	}
	
	public List<Snake> getSnakes(){
		return snakes;
	}
	
	public void setSnakes(ArrayList<Snake> snakes) {
		this.snakes = snakes;
	}
	
	public List<Ladder> getLadders(){
		return ladders;
	}
	
	public void setLadders(ArrayList<Ladder> ladders) {
		this.ladders = ladders;
	}
	
	public Map<String,Integer> getPlayerPositions(){
		return playerPositions;
	}
	
	public void setPlayerPositions(HashMap<String,Integer> players) {
		this.playerPositions = players;
	}
	
}

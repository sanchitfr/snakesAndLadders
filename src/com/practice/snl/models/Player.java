package com.practice.snl.models;

import java.util.UUID;

public class Player {
	
	private String name;
	private UUID id;
	
	public Player(String name) {
		this.name = name;
		this.id = UUID.randomUUID();
	}
	
	public String getPlayerName() {
		return name;
	}
	
	public UUID getPlayerID() {
		return id;
	}

}

package tests;
import static org.junit.Assert.fail;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Assassin;

 class TestMovingPieces {
	
	
	@Test
	public void testDeathSnailMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		int[] locations = {3, 10, 17};
		for (int i : locations)
			gameBoard[i] = new NPC(i);
		Player Player1 = new Player(13);
		DeathSnail Deathsnail1 = new DeathSnail(7);
		Deathsnail1.move(gameBoard, Player1.getLocation());
		assert(Deathsnail1.getLocation() == 8);
		Deathsnail1.move(gameBoard, Player1.getLocation());
		assert(Deathsnail1.getLocation() == 8);
		Deathsnail1.move(gameBoard, Player1.getLocation());
		assert(Deathsnail1.getLocation() == 9);
		Deathsnail1.move(gameBoard, Player1.getLocation());
		assert(Deathsnail1.getLocation() == 9);
		Deathsnail1.move(gameBoard, Player1.getLocation());
		assert(Deathsnail1.getLocation() == 9);
	}
	
	@Test
	public void testAssassinMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i=1;i<=5; i++)
			gameBoard[i] = new NPC(i);
		for (int i=7; i<=11; i++)
			gameBoard[i] = new NPC(i);
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new NPC(i);
		// Place Assassin1 in an open space - 6
		// Note that Assassin1 location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		Assassin Assassin1  = new Assassin(6);
		gameBoard[6] = Assassin1;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			gameBoard = Assassin1.move(gameBoard, 13);
			int loc = Assassin1.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 0);
		assert(count6 > 0);
		assert(count12 > 0);
		assert(count20 > 0);		
	}
	
 }

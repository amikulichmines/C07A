package tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Assassin;


import static org.junit.Assert.*;
import gameEngine.*;
import levelPieces.*;




import static org.junit.jupiter.api.Assertions.*;





class TestInteractions {
	int spot = 10;
	Drawable[] gameboard;
	

	public TestInteractions() {
		
	}
	@Test
	public void testAssassinInteraction() {
		gameboard = new Drawable[GameEngine.BOARD_SIZE];
		Assassin a = new Assassin(spot);
		gameboard[spot]= a;
		assert(InteractionResult.KILL== a.interact(gameboard, spot));
		
		for(int i=0; i<spot; i++) {
			assert(InteractionResult.NONE== a.interact(gameboard, i));
		}
		for (int i=spot+1; i<GameEngine.BOARD_SIZE; i++) {
			assert(InteractionResult.NONE== a.interact(gameboard, i));
		}
	}
	
	@Test
	public void testCatapultInteraction() {
		gameboard = new Drawable[GameEngine.BOARD_SIZE];
		Catapult c = new Catapult(spot);
		int count6 = 0;
		int count7 = 0;
		int count13 = 0;
		int count14 = 0;
		for(int i=0; i<50; i++) { //arbitrary large number to run many times
			switch( c.take_a_pot_shot()) {
			case 6:
				count6++;
			case 7:
				count7++;
			case 13:
				count13++;
			case 14:
				count14++;
			}
		}
		assert(count6 > 0);
		assert(count7 > 0);
		assert(count14 > 0);
		assert(count13 >0);
	}
	
	@Test
	public void testDeathSnailInteraction() { //check??
		gameboard = new Drawable[GameEngine.BOARD_SIZE];
		DeathSnail ds = new DeathSnail(spot);
		gameboard[spot]= ds;
		assert(InteractionResult.KILL== ds.interact(gameboard, spot));
		
		for(int i=0; i<spot; i++) {
			assert(InteractionResult.NONE== ds.interact(gameboard, i));
		}
		for (int i=spot+1; i<GameEngine.BOARD_SIZE; i++) {
			assert(InteractionResult.NONE== ds.interact(gameboard, i));
		}
	}
	
	@Test
	public void testImposterInteraction() {
		gameboard = new Drawable[GameEngine.BOARD_SIZE];
		Imposter imp = new Imposter(spot);
		gameboard[spot]= imp;
		assert(InteractionResult.ADVANCE== imp.interact(gameboard, spot));
		
		for(int i=0; i<spot; i++) {
			assert(InteractionResult.NONE== imp.interact(gameboard, i));
		}
		for (int i=spot+1; i<GameEngine.BOARD_SIZE; i++) {
			assert(InteractionResult.NONE== imp.interact(gameboard, i));
		}
	}
	
	@Test
	public void testTrophyInteraction() {
		gameboard = new Drawable[GameEngine.BOARD_SIZE];
		Trophy t = new Trophy(spot);
		gameboard[spot]= t;
		assert(InteractionResult.GET_POINT== t.interact(gameboard, spot));
		
		for(int i=0; i<spot; i++) {
			assert(InteractionResult.NONE== t.interact(gameboard, i));
		}
		for (int i=spot+1; i<GameEngine.BOARD_SIZE; i++) {
			assert(InteractionResult.NONE== t.interact(gameboard, i));
		}
	}
}

package gameEngine;

import gameEngine.*;
import levelPieces.*;


public class TestInteractions {
	int spot = 10;
	Drawable[] gameboard;
	
	public TestInteractions() {
		
	}
	
	void testAssassinInteraction() {
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
	
	void testCatapultInteraction() {
		
	}
	
	void testDeathSnailInteraction() { //check??
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
	
	void testImposterInteraction() {
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
	
	void testTrophyInteraction() {
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

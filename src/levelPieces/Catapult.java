package levelPieces;
//Author Alex Mikulich
import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import java.util.Random;

import gameEngine.InteractionResult;

public class Catapult extends GamePiece implements Drawable {
	static InteractionResult result = InteractionResult.NONE;
	int _target = 0;
	int _location = 0;
	
	public Catapult(int newLocation) { //catapult constructor
		super('C', "Catapult", newLocation);
		this._location = newLocation;
	}
	
	public void draw() { //draws catapult symbol
		System.out.print("C");
	}
	
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		_target = take_a_pot_shot(); //sets where the shot is landing
		if (playerLocation == _target) {
			return InteractionResult.HIT; //hits the player if it lands on them
		}
		return InteractionResult.NONE;
	}
	
	public int take_a_pot_shot() { //randomly launches somewhere within four spaces
		Random rand = new Random();
		int randomSpot = rand.nextInt(4);
		if (randomSpot == 0) {
			return _location - 3;
		}
		if (randomSpot == 1) {
			return _location - 4;
		}
		if (randomSpot == 2) {
			return _location + 3;
		}
		if (randomSpot == 3) {
			return _location + 4;
		}
		return 0; // Won't return 0, since the above return statements will do it.
	}
}

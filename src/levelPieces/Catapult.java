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
	
	public Catapult(int newLocation) {
		super('C', "Catapult", newLocation);
		this._location = newLocation;
	}
	
	public void draw() {
		System.out.print("C");
	}
	
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		_target = _take_a_pot_shot();
		if (playerLocation == _target) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
	
	private int _take_a_pot_shot() {
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
			return _location + 3;
		}
		return 0; // Won't return 0, since the above return statements will do it.
	}
}

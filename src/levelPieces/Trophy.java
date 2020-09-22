package levelPieces;
//author Chantal Wang
import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class Trophy extends GamePiece implements Drawable {

	int location_=0;
	
	public Trophy(int newLocation) {
		super('T', "Trophy", newLocation);
		this.location_ = newLocation;
	}
	public void draw() {
		System.out.print('X');
		
	}
	public InteractionResult interact(Drawable[] newGameBoard, int playerLocation) {
		if(playerLocation == this.location_) {
			return InteractionResult.GET_POINT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
	
	
}

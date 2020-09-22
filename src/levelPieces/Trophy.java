package levelPieces;
//author Chantal Wang
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Trophy extends GamePiece implements Drawable { //Trophy is the prize/gives points

	int location_=0;
	
	public Trophy(int newLocation) { //trophy constructor
		super('T', "Trophy", newLocation);
		this.location_ = newLocation;
	}
	public void draw() { //draws trophy
		System.out.print('X');
		
	}
	public InteractionResult interact(Drawable[] newGameBoard, int playerLocation) {
		if(playerLocation == this.location_) {
			return InteractionResult.GET_POINT; //gives points if player lands on it
		}
		else {
			return InteractionResult.NONE;
		}
	}
	
	
}

package levelPieces;

import gameEngine.Drawable;

public class NPC implements Drawable {
	int location_ = 0;
	
	public NPC(int newLocation) {
		this.location_= newLocation;
	}
	
	public void draw () {
		System.out.print("N");
	}
}

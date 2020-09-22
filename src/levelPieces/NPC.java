package levelPieces;

import gameEngine.Drawable;

public class NPC implements Drawable { //NPC is our one drawable only character
	int location_ = 0;
	
	public NPC(int newLocation) {
		this.location_= newLocation; //npc constructor
	}
	
	public void draw () {
		System.out.print("N"); //draws the symbol for npc
	}
}

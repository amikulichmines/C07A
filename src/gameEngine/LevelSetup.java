package gameEngine;
import java.util.ArrayList;

public class LevelSetup {
	Drawable[] drawableArray = {};
	ArrayList<Moveable> moveableArray = new ArrayList<Moveable>();
	ArrayList<GamePiece>gamePieceArray = new ArrayList<GamePiece>();
	
	public LevelSetup() {
		
		gamePieceArray.add(S);
		

	}
	public void createLevel(int newLevelNumber) {
		//this will setup the level for the number specified
		if (newLevelNumber == 1) {
			
		}
		
		if (newLevelNumber == 2) {
			
		}
		
		if (newLevelNumber == 3) {
			
		}
	}
	public GamePiece[] get_board() {
		
	}
	
	public void draw(char character){
		System.out.println(character);
	}
	
}

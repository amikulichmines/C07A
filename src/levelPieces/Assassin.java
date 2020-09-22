package levelPieces;
//author Chantal Wang
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.Random;
import gameEngine.InteractionResult;


public class Assassin extends GamePiece implements Moveable, Drawable {
	Drawable[] newGameBoard= {};
	int location_ = 0;
	boolean valid = false;
	
	public Assassin(int initialLocation) {
		super('A', "Assassin", initialLocation);
		this.location_ = initialLocation;
	}
	
	public Drawable[] move(Drawable[] gameBoard, int playerLocation) {
		do {
			newGameBoard = gameBoard;
			Random rand = new Random();
			int randomSpot = rand.nextInt(GameEngine.BOARD_SIZE);
			if(newGameBoard[randomSpot] == null) {
				valid = true;
				newGameBoard[randomSpot] = newGameBoard[location_];
				newGameBoard[location_] = null;
				location_ = randomSpot;
			}
		}while(!valid);	
		return newGameBoard;
	}
	public void draw() {
		System.out.print("A");
	}
	
	public InteractionResult interact(Drawable[] newGameBoard, int playerLocation) {
		if(playerLocation == this.location_) {
			System.out.println("Assassin strikes!");
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE;
		}
	}
}

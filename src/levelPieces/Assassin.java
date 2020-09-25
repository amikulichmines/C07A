package levelPieces;
//author Chantal Wang and Alex Mikulich
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.Random;
import gameEngine.InteractionResult;


public class Assassin extends GamePiece implements Moveable, Drawable {
	Drawable[] newGameBoard= {};
	int location_ = 0;
	boolean valid = false;
	
	public Assassin(int initialLocation) { //Assassing class constructor
		super('A', "Assassin", initialLocation);
		this.location_ = initialLocation;
	}
	
	public Drawable[] move(Drawable[] gameBoard, int playerLocation) { 
		do {
			newGameBoard = gameBoard;
			Random rand = new Random(); //moves randomly around the game board
			int randomSpot = rand.nextInt(GameEngine.BOARD_SIZE);
			if(newGameBoard[randomSpot] == null) { //makes sure it lands on a valid spot
				valid = true;
				newGameBoard[randomSpot] = newGameBoard[location_];
				newGameBoard[location_] = null;
				location_ = randomSpot;
			}
		}while(!valid);	
		return newGameBoard;
	}
	public void draw() { //draws symbol for assassin
		System.out.print("A");
	}
	
	public int getLocation() {
		return location_;
	}
	
	public InteractionResult interact(Drawable[] newGameBoard, int playerLocation) {
		if(playerLocation == this.location_) {
			System.out.println("Assassin strikes!");
			return InteractionResult.KILL; //if you land on the assassin it kills you
		}
		else {
			return InteractionResult.NONE;
		}
	}
}

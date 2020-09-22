package levelPieces;
//author Chantal Wang
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Imposter extends GamePiece implements Drawable {
	char symbol = randomizeSymbol(); //randomizes the icon that the imposter takes
	int location_ =0;
	
	public Imposter(int setLocation){ //Imposter constructor
		super('I', "Imposter", setLocation);
		this.location_= setLocation;
	}

	
	public char randomizeSymbol() { //Sets imposter symbol as a random other symbol from one of the other pieces
		//so it is an imposter of another piece
		Random rand = new Random();
		char [] possibleSymbols = {'A', 'C', 'D', 'N', 'P', 'X'};
		int randomInt = rand.nextInt(6);
		return possibleSymbols[randomInt];
	}
	
	public void draw() { //prints imposter symbol
		System.out.print(symbol);
	}

	
	public InteractionResult interact(Drawable[] newGameBoard, int playerLocation) {
		if(playerLocation == this.location_) {
			return InteractionResult.ADVANCE; //the imposter lets you advance to the next level 
			//if you successfully find and land on it
		}
		else {
			return InteractionResult.NONE;
		}
	}
	

}

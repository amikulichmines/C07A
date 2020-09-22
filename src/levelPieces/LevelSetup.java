package levelPieces;
import java.util.ArrayList;
import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.GameEngine;

public class LevelSetup {
	Drawable[] drawableArray = {}; //creating all the arrays we will need to fill
	ArrayList<Moveable> moveableArray = new ArrayList<Moveable>();
	ArrayList<levelPieces.GamePiece> gamePieceArray = new ArrayList<levelPieces.GamePiece>();
	Drawable [] gameboard1= new Drawable[GameEngine.BOARD_SIZE];
	
	Imposter imposter1;  //creating pieces we will need to have in the game
	Player player1;
	Trophy trophy1;
	Catapult catapult1;
	DeathSnail deathSnail1;
	Assassin assassin1;
	
	public LevelSetup() {
		

	}
	public void createLevel(int newLevelNumber) { //chooses which level to start
		//this will setup the level for the number specified
		if (newLevelNumber == 1) {
			levelOne();
		}
		if (newLevelNumber == 2) {
			levelTwo();
		}
		
	}
	
	
	public void levelOne() { //Starts level 1
		
		System.out.println("Player: P (You)");
		System.out.println("Imposter: ? (Can take the form of others, and advances level)");
		System.out.println("Trophy: X (Your goal! Gives you points)");
		System.out.println("Catapult: C  (Throws pot shots randomly towards you, ouch!)");
		System.out.println("Useless NPC: N (Completely useless)");
		
		int t= 11; //starting positions of each object in level 1
		int p = 9;
		int i = 5;
		int c = 18;
		int n = 13;
		player1 = new Player(p); //creation of objects in level 1
		imposter1 = new Imposter(i);
		trophy1 = new Trophy(t);
		catapult1 = new Catapult(18);
		
		
		
		gameboard1[i]= imposter1; //set gameboard for level 1
		gameboard1[n]= new NPC(n);
		gameboard1[t] = trophy1;
		gameboard1[c]= catapult1;
		
		gamePieceArray.add((GamePiece) imposter1); //set interacting pieces for level 1
		gamePieceArray.add((GamePiece)trophy1);
		gamePieceArray.add((GamePiece) catapult1);
		
		//level 1 does not have moving pieces other than player, only level 2 does
		
		
		
		
	}
	public void levelTwo() { //creates board and pieces ofr level 2
		System.out.println("Player: P (You)");
		System.out.println("Imposter: ? (Can take the form of others, and advances level");
		System.out.println("Trophy: X (Your goal! Gives you points)");
		System.out.println("Catapult: C  (Throws pot shots randomly towards you, ouch!)");
		System.out.println("Useless NPC: N (Completely useless)");
		System.out.println("Assassin: A  (Moves around randomly, will kill you if you land on it!)");
		System.out.println("Death Snail: D  (Advances slowly towards you. Poisonous, will kill you!)");
		
		gameboard1= new Drawable[GameEngine.BOARD_SIZE]; //clears board and array from level 1
		moveableArray = new ArrayList<Moveable>();
		gamePieceArray = new ArrayList<levelPieces.GamePiece>();
		
		int t= 7; //sets locations used for level 2
		int p = 9;
		int i = 15;
		int c = 18;
		int n = 17;
		int a= 2;
		int d = 13;
		
		player1 = new Player(p); //sets pieces used in level 2
		imposter1 = new Imposter(i);
		assassin1 = new Assassin(a);
		catapult1 = new Catapult(c);
		deathSnail1 = new DeathSnail(d);
		trophy1 = new Trophy(t);
				
		gameboard1[a] = assassin1; //fills gameboard
		gameboard1[c] = catapult1;
		gameboard1[d] = deathSnail1;
		gameboard1[i] = imposter1;
		gameboard1[n] = new NPC(n);
		gameboard1[t] = trophy1;
		
		gamePieceArray.add((GamePiece) assassin1); //fills interacting pieces for level 2
		gamePieceArray.add((GamePiece) deathSnail1);
		gamePieceArray.add((GamePiece) imposter1);
		gamePieceArray.add((GamePiece)trophy1);
		gamePieceArray.add((GamePiece) catapult1);
		
		moveableArray.add((Moveable) assassin1); //fills moving pieces for level 2
		moveableArray.add((Moveable) deathSnail1);

		

	}
	
	
	public Drawable[] getBoard() { //setter for gameboard
		return gameboard1;
	}
	
	public ArrayList<Moveable> getMovingPieces(){ //setter for moveable pieces array
		return moveableArray;
	}
	
	public ArrayList<levelPieces.GamePiece> getInteractingPieces(){ //setter for interacting pieces array
		return gamePieceArray;
	}
	

	public int getPlayerStartLoc() { //getter for player location
		return player1.getLocation();
	}
	
}

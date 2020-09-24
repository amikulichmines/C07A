package levelPieces;
//Author Alex Mikulich
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class DeathSnail extends GamePiece implements Moveable, Drawable {
	private int _location = 0;
	private int _count = 0;
	private Drawable[] newGameboard = {};
	
	
	
	public DeathSnail(int newLocation) { //death snail constructor
		super('D', "Death Snail", newLocation);
		this._location = newLocation;
	}

	public Drawable[] move(Drawable[] gameBoard, int playerLocation) { 
		if (_count%2 == 0) { //makes sure death snail moves slowly (every other turn)
			newGameboard = gameBoard;
			if (playerLocation < _location) { //moves towards the player
				_move_left();
			}
			if (playerLocation > _location) {
				_move_right();
			}
		}
		_count++;
		return newGameboard;
	}
	
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == _location) {
			return InteractionResult.KILL; //kills player if it lands on them
		}
		return InteractionResult.NONE;
	}
	
	public void _move_left() { //moves snail to the left on the gameboard
		if (_location != 0) {
			if (newGameboard[_location-1] == null) {
				newGameboard[_location-1] = newGameboard[_location];
				newGameboard[_location] = null; //deletes old snail icon
				_location--;
			}
		}
	}
	
	public void _move_right() { //moves snail to the right on the gameboard
		if (_location != newGameboard.length-1) {
			if (newGameboard[_location+1] == null) {
				newGameboard[_location+1] = newGameboard[_location];
				newGameboard[_location] = null;
				_location++;
			}
		}
	}
	
	public void draw() { //draws snail in its position
		System.out.print("D");
	}
	
	public int getLocation() {
		return _location;
	}

	
	
}


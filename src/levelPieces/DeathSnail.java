package levelPieces;
//Author Alex Mikulich
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class DeathSnail extends GamePiece implements Moveable, Drawable {
	private int _location = 0;
	private int _count = 0;
	private Drawable[] newGameboard = {};
	
	
	
	public DeathSnail(int newLocation) {
		super('D', "Death Snail", newLocation);
		this._location = newLocation;
	}

	public Drawable[] move(Drawable[] gameBoard, int playerLocation) {
		if (_count%2 == 0) {
			newGameboard = gameBoard;
			if (playerLocation < _location) {
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
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
	private void _move_left() {
		if (_location != 0) {
			if (newGameboard[_location-1] == null) {
				newGameboard[_location-1] = newGameboard[_location];
				newGameboard[_location] = null;
				_location--;
			}
		}
	}
	
	private void _move_right() {
		if (_location != newGameboard.length-1) {
			if (newGameboard[_location+1] == null) {
				newGameboard[_location+1] = newGameboard[_location];
				newGameboard[_location] = null;
				_location++;
			}
		}
	}
	
	public void draw() {
		System.out.print("D");
	}
	
	private void set_location(int _location) {
		this._location = _location;
	}
	
	
	
}


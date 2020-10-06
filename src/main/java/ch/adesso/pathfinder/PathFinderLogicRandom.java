package ch.adesso.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Diese triviale Methode kann sogar von einem sehr einfachen Roboter durchgeführt werden.
Sie besteht einfach darin, so lange geradeaus zu gehen, bis man eine Kreuzung erreicht.
Dort entscheidet man sich zufällig für eine Richtung, in die man weitergeht.
Weil man bei dieser Methode Wege möglicherweise mehrmals beschreitet, dauert es im Allgemeinen sehr lange, bis man zum Ausgang kommt.
Dennoch erreicht man diesen immer.
 */
public class PathFinderLogicRandom implements PathFinderLogic {

	Random random = new Random();

	@Override
	public DIRECTIONS getNewDirection(Labyrinth labyrinth, Point position, DIRECTIONS oldDirection) {
		DIRECTIONS backward = DIRECTIONS.UP;
		if (oldDirection == DIRECTIONS.RIGHT) {
			backward = DIRECTIONS.LEFT;
		} else if (oldDirection == DIRECTIONS.LEFT) {
			backward = DIRECTIONS.RIGHT;
		} else if (oldDirection == DIRECTIONS.UP) {
			backward = DIRECTIONS.DOWN;
		}
		List<DIRECTIONS> directions = new ArrayList<>();
		addIfEmpty(labyrinth, position, directions, backward, DIRECTIONS.UP);
		addIfEmpty(labyrinth, position, directions, backward, DIRECTIONS.RIGHT);
		addIfEmpty(labyrinth, position, directions, backward, DIRECTIONS.DOWN);
		addIfEmpty(labyrinth, position, directions, backward, DIRECTIONS.LEFT);
		if (directions.size() == 0) {
			return backward;
		} else {
			int randomDirection = random.nextInt(directions.size());
			return directions.get(randomDirection);
		}
	}

	private void addIfEmpty(Labyrinth labyrinth, Point position, List<DIRECTIONS> directions, DIRECTIONS backward, DIRECTIONS direction) {
		if (backward != direction) {
			if (labyrinth.isEmpty(getNewPosition(position, direction))) {
				directions.add(direction);
			}
		}
	}

}

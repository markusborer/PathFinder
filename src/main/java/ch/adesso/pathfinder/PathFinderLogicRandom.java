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
		List<DIRECTIONS> directions = new ArrayList<>();
		DIRECTIONS backward = null;
		switch (oldDirection) {
			case RIGHT:
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.UP);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.RIGHT);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.DOWN);
				backward = DIRECTIONS.LEFT;
				break;
			case LEFT:
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.DOWN);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.LEFT);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.UP);
				backward = DIRECTIONS.RIGHT;
				break;
			case UP:
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.LEFT);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.UP);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.RIGHT);
				backward = DIRECTIONS.DOWN;
				break;
			case DOWN:
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.RIGHT);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.DOWN);
				addIfEmpty(labyrinth, position, directions, DIRECTIONS.LEFT);
				backward = DIRECTIONS.UP;
				break;
		}
		if (directions.size() == 0) {
			return backward;
		} else if (directions.size() == 1) {
			return directions.get(0);
		} else {
			int randomDirection = random.nextInt(directions.size());
			return directions.get(randomDirection);
		}
	}

	private void addIfEmpty(Labyrinth labyrinth, Point position, List<DIRECTIONS> directions, DIRECTIONS direction) {
		if (labyrinth.isEmpty(getNewPosition(position, direction))) {
			directions.add(direction);
		}
	}

}

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
		DIRECTIONS backward = getBackwardDirection(oldDirection);
		List<DIRECTIONS> directions = getPossibleDirections(labyrinth, position, backward);
		if (directions.size() == 0) {
			return backward;
		} else {
			int randomDirection = random.nextInt(directions.size());
			return directions.get(randomDirection);
		}
	}

	private DIRECTIONS getBackwardDirection(DIRECTIONS oldDirection) {
		DIRECTIONS backward = DIRECTIONS.UP;
		if (oldDirection == DIRECTIONS.RIGHT) {
			backward = DIRECTIONS.LEFT;
		} else if (oldDirection == DIRECTIONS.LEFT) {
			backward = DIRECTIONS.RIGHT;
		} else if (oldDirection == DIRECTIONS.UP) {
			backward = DIRECTIONS.DOWN;
		}
		return backward;
	}

	private List<DIRECTIONS> getPossibleDirections(Labyrinth labyrinth, Point position, DIRECTIONS backward) {
		List<DIRECTIONS> directions = new ArrayList<>();
		if (backward != DIRECTIONS.UP && labyrinth.isEmpty(getNewPosition(position, DIRECTIONS.UP))) {
			directions.add(DIRECTIONS.UP);
		}
		if (backward != DIRECTIONS.RIGHT && labyrinth.isEmpty(getNewPosition(position, DIRECTIONS.RIGHT))) {
			directions.add(DIRECTIONS.RIGHT);
		}
		if (backward != DIRECTIONS.DOWN && labyrinth.isEmpty(getNewPosition(position, DIRECTIONS.DOWN))) {
			directions.add(DIRECTIONS.DOWN);
		}
		if (backward != DIRECTIONS.LEFT && labyrinth.isEmpty(getNewPosition(position, DIRECTIONS.LEFT))) {
			directions.add(DIRECTIONS.LEFT);
		}
		return directions;
	}

}

package ch.adesso.pathfinder;

import java.awt.Point;
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
		DIRECTIONS left = null;
		DIRECTIONS forward = null;
		DIRECTIONS right = null;
		DIRECTIONS backward = null;
		switch (oldDirection) {
			case RIGHT:
				left = DIRECTIONS.UP;
				forward = DIRECTIONS.RIGHT;
				right = DIRECTIONS.DOWN;
				backward = DIRECTIONS.LEFT;
				break;
			case LEFT:
				left = DIRECTIONS.DOWN;
				forward = DIRECTIONS.LEFT;
				right = DIRECTIONS.UP;
				backward = DIRECTIONS.RIGHT;
				break;
			case UP:
				left = DIRECTIONS.LEFT;
				forward = DIRECTIONS.UP;
				right = DIRECTIONS.RIGHT;
				backward = DIRECTIONS.DOWN;
				break;
			case DOWN:
				left = DIRECTIONS.RIGHT;
				forward = DIRECTIONS.DOWN;
				right = DIRECTIONS.LEFT;
				backward = DIRECTIONS.UP;
				break;
		}
		boolean leftIsEmpty = labyrinth.isEmpty(getNewPosition(position, left));
		boolean forwardIsEmpty = labyrinth.isEmpty(getNewPosition(position, forward));
		boolean rightIsEmpty = labyrinth.isEmpty(getNewPosition(position, right));
		if (!leftIsEmpty && !forwardIsEmpty && !rightIsEmpty) {
			return backward;
		}
		if (!leftIsEmpty && forwardIsEmpty && !rightIsEmpty) {
			return forward;
		}
		while (true) {
			int randomDirection = random.nextInt(3);
			if (randomDirection == 0 && leftIsEmpty) {
				return left;
			}
			if (randomDirection == 1 && forwardIsEmpty) {
				return forward;
			}
			if (randomDirection == 2 && rightIsEmpty) {
				return right;
			}
		}
	}

}

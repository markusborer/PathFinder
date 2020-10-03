package ch.adesso.pathfinder;

import java.awt.Point;

public interface PathFinderLogic {

	enum DIRECTIONS {
		RIGHT, LEFT, UP, DOWN
	}

	/**
	 * Returns the new direction to go
	 * @param labyrinth The labyrinth
	 * @param position The actual position
	 * @param oldDirection The direction how you got to the actual position (for example if you came from the left the oldDirection is RIGHT)
	 * @return The new direction to go
	 */
	DIRECTIONS getNewDirection(Labyrinth labyrinth, Point position, DIRECTIONS oldDirection);

	/**
	 * Returns the new position if you go from the given position in the given direction
	 * @param position The start-position
	 * @param direction The direction to go
	 * @return The new position
	 */
	default Point getNewPosition(Point position, DIRECTIONS direction) {
		switch (direction) {
			case RIGHT:
				return new Point(position.x + 1, position.y);
			case LEFT:
				return new Point(position.x - 1, position.y);
			case UP:
				return new Point(position.x, position.y - 1);
			case DOWN:
				return new Point(position.x, position.y + 1);
			default:
				return new Point(position.x, position.y);
		}
	}

}

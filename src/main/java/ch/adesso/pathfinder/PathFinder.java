package ch.adesso.pathfinder;

import java.awt.Point;

import ch.adesso.pathfinder.PathFinderLogic.DIRECTIONS;

public class PathFinder {

	private static final int STEP_IN_MILLIS = 1;

	private Labyrinth labyrinth;

	public PathFinder(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}

	public void findPath(PathFinderLogic pathFinderLogic) {
		DIRECTIONS direction = DIRECTIONS.RIGHT;
		Point position = new Point(labyrinth.getStart());
		do {
			direction = pathFinderLogic.getNewDirection(labyrinth, position, direction);
			position = setNewPosition(position, direction);
			labyrinth.paintLine(position);
			try {
				Thread.sleep(STEP_IN_MILLIS);
			} catch (InterruptedException e) {
			}
		} while (!position.equals(labyrinth.getEnd()));
	}

	private Point setNewPosition(Point position, DIRECTIONS direction) {
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
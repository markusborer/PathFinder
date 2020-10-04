package ch.adesso.pathfinder;

import java.awt.Point;

import ch.adesso.pathfinder.PathFinderLogic.DIRECTIONS;

class PathFinder {

	private static final int STEP_IN_MILLIS = 1;

	private Labyrinth labyrinth;

	PathFinder(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}

	void findPath(PathFinderLogic pathFinderLogic) {
		int steps = 0;
		DIRECTIONS direction = DIRECTIONS.RIGHT;
		Point position = new Point(labyrinth.getStart());
		do {
			steps++;
			labyrinth.setTitle("Searching " + steps + " steps");
			direction = pathFinderLogic.getNewDirection(labyrinth, position, direction);
			position = pathFinderLogic.getNewPosition(position, direction);
			labyrinth.paintLine(position);
			try {
				Thread.sleep(STEP_IN_MILLIS);
			} catch (InterruptedException e) {
				// Do nothing
			}
		} while (!position.equals(labyrinth.getEnd()));
		labyrinth.setTitle("Solved after " + steps + " steps");
	}

}
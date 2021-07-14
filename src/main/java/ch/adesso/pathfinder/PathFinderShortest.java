package ch.adesso.pathfinder;

import ch.adesso.pathfinder.PathFinderLogic.DIRECTIONS;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class PathFinderShortest {

	private static final int STEP_IN_MILLIS = 10;

	private Labyrinth labyrinth;

	PathFinderShortest(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}

	void findPath() {
		int steps = 0;
		DIRECTIONS direction = DIRECTIONS.RIGHT;
		Point position = new Point(labyrinth.getStart());
		List<Point> oldPoints = new ArrayList<>();
		oldPoints.add(position);
		boolean finished = false;
		do {
			steps++;
			labyrinth.setTitle("Searching " + steps + " steps");

			List<Point> newPoints = new ArrayList<>();
			for (Point point : oldPoints) {
				Point newPoint = new Point(point.x + 1, point.y);
				if (labyrinth.isEmpty(newPoint)) {
					labyrinth.paintLine(newPoint);
					labyrinth.setNotEmpty(newPoint);
					newPoints.add(newPoint);
					finished |= newPoint.equals(labyrinth.getEnd());
				}
				newPoint = new Point(point.x, point.y + 1);
				if (labyrinth.isEmpty(newPoint)) {
					labyrinth.paintLine(newPoint);
					labyrinth.setNotEmpty(newPoint);
					newPoints.add(newPoint);
					finished |= newPoint.equals(labyrinth.getEnd());
				}
				newPoint = new Point(point.x - 1, point.y);
				if (labyrinth.isEmpty(newPoint)) {
					labyrinth.paintLine(newPoint);
					labyrinth.setNotEmpty(newPoint);
					newPoints.add(newPoint);
					finished |= newPoint.equals(labyrinth.getEnd());
				}
				newPoint = new Point(point.x, point.y - 1);
				if (labyrinth.isEmpty(newPoint)) {
					labyrinth.paintLine(newPoint);
					labyrinth.setNotEmpty(newPoint);
					newPoints.add(newPoint);
					finished |= newPoint.equals(labyrinth.getEnd());
				}
			}
			oldPoints = newPoints;

			labyrinth.paintLine(position);
			try {
				Thread.sleep(STEP_IN_MILLIS);
			} catch (InterruptedException e) {
				// Do nothing
			}
		} while (!finished);
		labyrinth.setTitle("Solved after " + steps + " steps");
	}

}
package ch.adesso.pathfinder;

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
		Ant firstAnt = new Ant(labyrinth);
		List<Ant> oldAnts = new ArrayList<>();
		oldAnts.add(firstAnt);
		boolean finished = false;
		do {
			steps++;
			labyrinth.setTitle("Searching " + steps + " steps");
			System.out.println("Ants: " + oldAnts.size());
			List<Ant> newAnts = new ArrayList<>();
			for (Ant oldAnt : oldAnts) {
				List<Ant> antsToAdd = oldAnt.goOneStep();
				newAnts.addAll(antsToAdd);
				for (Ant antToAdd : antsToAdd) {
					Point lastPoint = antToAdd.getLastPoint();
					labyrinth.paintLine(lastPoint);
					labyrinth.setNotEmpty(lastPoint);
					boolean isFinished = lastPoint.equals(labyrinth.getEnd());
					if (isFinished) {
						List<Point> path = antToAdd.getPath();
						for (Point point : path) {
							labyrinth.paintSolutionLine(point);
						}
					}
					finished |= isFinished;
				}
			}
			oldAnts = newAnts;
			try {
				Thread.sleep(STEP_IN_MILLIS);
			} catch (InterruptedException e) {
				// Do nothing
			}
		} while (!finished);
		labyrinth.setTitle("Solved after " + steps + " steps");
	}

}
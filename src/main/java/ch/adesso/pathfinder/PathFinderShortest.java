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
		List<Ant> ants = new ArrayList<>();
		ants.add(firstAnt);
		boolean finished = false;
		do {
			steps++;
			labyrinth.setTitle("Searching " + steps + " steps");
			System.out.println("Ants: " + ants.size());
			ants = goOneStep(ants);
			finished = isFinished(ants);
			try {
				Thread.sleep(STEP_IN_MILLIS);
			} catch (InterruptedException e) {
				// Do nothing
			}
		} while (!finished);
		labyrinth.setTitle("Solved after " + steps + " steps");
	}

	private List<Ant> goOneStep(List<Ant> ants) {
		List<Ant> newAnts = new ArrayList<>();
		for (Ant ant : ants) {
			List<Ant> antsToAdd = ant.goOneStep();
			newAnts.addAll(antsToAdd);
			for (Ant antToAdd : antsToAdd) {
				paintLineAndMarkField(antToAdd);
			}
		}
		return newAnts;
	}

	private void paintLineAndMarkField(Ant antToAdd) {
		Point lastPoint = antToAdd.getLastPoint();
		labyrinth.paintLine(lastPoint);
		labyrinth.setNotEmpty(lastPoint);
	}

	private boolean isFinished(List<Ant> ants) {
		boolean finished = false;
		for (Ant ant : ants) {
			Point lastPoint = ant.getLastPoint();
			boolean isFinished = lastPoint.equals(labyrinth.getEnd());
			if (isFinished) {
				paintSolutionLine(ant);
				finished = true;
			}
		}
		return finished;
	}

	private void paintSolutionLine(Ant ant) {
		List<Point> path = ant.getPath();
		for (Point point : path) {
			labyrinth.paintSolutionLine(point);
		}
	}

}
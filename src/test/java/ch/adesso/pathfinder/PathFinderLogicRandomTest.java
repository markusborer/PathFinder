package ch.adesso.pathfinder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.awt.Point;
import java.util.Random;

import org.junit.Test;

import ch.adesso.pathfinder.PathFinderLogic.DIRECTIONS;

public class PathFinderLogicRandomTest {

	@Test
	public void getNewDirection_Right_Right() {
		String labyrinth =
			"XXX" +
			"S  " +
			"XXX";
		assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
	}

	@Test
	public void getNewDirection_Right_Up() {
		String labyrinth =
			"X X" +
			"S X" +
			"XXX";
		assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
	}

	@Test
	public void getNewDirection_Right_Down() {
		String labyrinth =
			"XXX" +
			"S X" +
			"X X";
		assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
	}

	@Test
	public void getNewDirection_Right_Left() {
		String labyrinth =
			"XXX" +
			"S X" +
			"XXX";
		assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
	}

	@Test
	public void getNewDirection_Right_RandomUp() {
		String labyrinth =
			"X X" +
			"S  " +
			"X X";
		assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth, 0));
	}

	@Test
	public void getNewDirection_Right_RandomRight() {
		String labyrinth =
			"X X" +
			"S  " +
			"X X";
		assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth, 1));
	}

	@Test
	public void getNewDirection_Right_RandomDown() {
		String labyrinth =
			"X X" +
			"S  " +
			"X X";
		assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth, 2));
	}

	private DIRECTIONS getNewDirection(String labyrinthString) {
		PathFinderLogicRandom pathFinder = new PathFinderLogicRandom();
		Labyrinth labyrinth = new Labyrinth(mock(Window.class));
		labyrinth.initLabyrinth(labyrinthString, 3, 3);
		Point position = new Point(1, 1);
		DIRECTIONS oldDirection = null;
		if (labyrinthString.charAt(1) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.DOWN;
		} else if (labyrinthString.charAt(3) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.RIGHT;
		} else if (labyrinthString.charAt(5) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.LEFT;
		} else if (labyrinthString.charAt(7) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.UP;
		}
		return pathFinder.getNewDirection(labyrinth, position , oldDirection);
	}

	private DIRECTIONS getNewDirection(String labyrinthString, int randomResult) {
		PathFinderLogicRandom pathFinder = new PathFinderLogicRandom();
		Random random = mock(Random.class);
		when(random.nextInt(3)).thenReturn(randomResult);
		pathFinder.random = random;
		Labyrinth labyrinth = new Labyrinth(mock(Window.class));
		labyrinth.initLabyrinth(labyrinthString, 3, 3);
		Point position = new Point(1, 1);
		DIRECTIONS oldDirection = null;
		if (labyrinthString.charAt(1) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.DOWN;
		} else if (labyrinthString.charAt(3) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.RIGHT;
		} else if (labyrinthString.charAt(5) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.LEFT;
		} else if (labyrinthString.charAt(7) == Labyrinth.START_CHARACTER) {
			oldDirection = DIRECTIONS.UP;
		}
		return pathFinder.getNewDirection(labyrinth, position , oldDirection);
	}

}

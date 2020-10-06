package ch.adesso.pathfinder;

import java.awt.*;

public class Labyrinth {

	private static final char BORDER_CHARACTER = 'X';
	static final char START_CHARACTER = 'S';
	private static final char END_CHARACTER = 'E';

	private static final int[] EMPTY_COLOR = new int[] { 0xFF, 0xFF, 0xFF };
	private static final int[] BORDER_COLOR = new int[] { 0x00, 0x00, 0x00 };
	private static final int[] START_COLOR = new int[] { 0x00, 0x00, 0xFF };
	private static final int[] END_COLOR = new int[] { 0xFF, 0x00, 0x00 };
	private static final int[] LINE_COLOR = new int[] { 0x00, 0xFF, 0x00 };

	private static final int EMPTY = 0;
	private static final int NOT_EMPTY = 1;

	private Point start;
	private Point end;
	private Window window;
	private int[][] labyrinth;

	public Labyrinth(Window window) {
		this.window = window;
	}

	void initLabyrinth(String pattern, int width, int height) {
		labyrinth = new int[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				char character = pattern.charAt(x + y * width);
				if (character == START_CHARACTER) {
					start = new Point(x, y);
					labyrinth[x][y] = EMPTY;
					window.setColor(start, START_COLOR);
				} else if (character == END_CHARACTER) {
					end = new Point(x, y);
					labyrinth[x][y] = EMPTY;
					window.setColor(end, END_COLOR);
				} else if (character == BORDER_CHARACTER) {
					labyrinth[x][y] = NOT_EMPTY;
					window.setColor(new Point(x, y), BORDER_COLOR);
				} else {
					labyrinth[x][y] = EMPTY;
					window.setColor(new Point(x, y), EMPTY_COLOR);
				}
			}
		}
		window.repaint();
	}

	Point getStart() {
		return start;
	}

	Point getEnd() {
		return end;
	}

	boolean isEmpty(Point point) {
		return labyrinth[point.x][point.y] == EMPTY;
	}

	void paintLine(Point position) {
		window.setColor(position, Labyrinth.LINE_COLOR);
		window.repaint();
	}

	void setTitle(String title) {
		window.setTitle(title);
	}

}

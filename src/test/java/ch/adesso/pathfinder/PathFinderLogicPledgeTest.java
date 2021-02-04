package ch.adesso.pathfinder;

import ch.adesso.pathfinder.PathFinderLogic.DIRECTIONS;
import org.junit.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PathFinderLogicPledgeTest {

    private Random random = new Random();

    @Test
    public void test11() {
        String labyrinth =
                "X X" +
                "-  " +
                "X X";
        doTest(labyrinth, 0, DIRECTIONS.RIGHT, 0);
    }

    @Test
    public void test12() {
        String labyrinth =
                "X X" +
                "- X" +
                "X X";
        doTest(labyrinth, 0, DIRECTIONS.DOWN, 1);
    }

    @Test
    public void test13() {
        String labyrinth =
                "X X" +
                "- X" +
                "XXX";
        doTest(labyrinth, 0, DIRECTIONS.LEFT, 2);
    }

    @Test
    public void test14() {
        String labyrinth =
                "X X" +
                "-  " +
                "X X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.UP, -1);
    }

    @Test
    public void test15() {
        String labyrinth =
                "XXX" +
                "-  " +
                "X X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.RIGHT, 0);
    }

    @Test
    public void test16() {
        String labyrinth =
                "XXX" +
                "- X" +
                "X X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.DOWN, 1);
    }

    @Test
    public void test17() {
        String labyrinth =
                "XXX" +
                "- X" +
                "XXX";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.LEFT, 2);
    }

    @Test
    public void test21() {
        String labyrinth =
                "X-X" +
                "   " +
                "X X";
        doTest(labyrinth, 0, DIRECTIONS.DOWN, 0);
    }

    @Test
    public void test22() {
        String labyrinth =
                "X-X" +
                "   " +
                "XXX";
        doTest(labyrinth, 0, DIRECTIONS.LEFT, 1);
    }

    @Test
    public void test23() {
        String labyrinth =
                "X-X" +
                "X  " +
                "XXX";
        doTest(labyrinth, 0, DIRECTIONS.UP, 2);
    }

    @Test
    public void test24() {
        String labyrinth =
                "X-X" +
                "   " +
                "X X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.RIGHT, -1);
    }

    @Test
    public void test25() {
        String labyrinth =
                "X-X" +
                "  X" +
                "X X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.DOWN, 0);
    }

    @Test
    public void test26() {
        String labyrinth =
                "X-X" +
                "  X" +
                "XXX";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.LEFT, 1);
    }

    @Test
    public void test27() {
        String labyrinth =
                "X-X" +
                "X X" +
                "XXX";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.UP, 2);
    }

    @Test
    public void test31() {
        String labyrinth =
                "X X" +
                "  -" +
                "X X";
        doTest(labyrinth, 0, DIRECTIONS.LEFT, 0);
    }

    @Test
    public void test32() {
        String labyrinth =
                "X X" +
                "X -" +
                "X X";
        doTest(labyrinth, 0, DIRECTIONS.UP, 1);
    }

    @Test
    public void test33() {
        String labyrinth =
                "XXX" +
                "X -" +
                "X X";
        doTest(labyrinth, 0, DIRECTIONS.RIGHT, 2);
    }

    @Test
    public void test34() {
        String labyrinth =
                "X X" +
                "  -" +
                "X X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.DOWN, -1);
    }

    @Test
    public void test35() {
        String labyrinth =
                "X X" +
                "  -" +
                "XXX";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.LEFT, 0);
    }

    @Test
    public void test36() {
        String labyrinth =
                "X X" +
                "X -" +
                "XXX";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.UP, 1);
    }

    @Test
    public void test37() {
        String labyrinth =
                "XXX" +
                "X -" +
                "XXX";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.RIGHT, 2);
    }

    @Test
    public void test41() {
        String labyrinth =
                "X X" +
                "   " +
                "X-X";
        doTest(labyrinth, 0, DIRECTIONS.UP, 0);
    }

    @Test
    public void test42() {
        String labyrinth =
                "XXX" +
                "   " +
                "X-X";
        doTest(labyrinth, 0, DIRECTIONS.RIGHT, 1);
    }

    @Test
    public void test43() {
        String labyrinth =
                "XXX" +
                "  X" +
                "X-X";
        doTest(labyrinth, 0, DIRECTIONS.DOWN, 2);
    }

    @Test
    public void test44() {
        String labyrinth =
                "X X" +
                "   " +
                "X-X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.LEFT, -1);
    }

    @Test
    public void test45() {
        String labyrinth =
                "X X" +
                "X  " +
                "X-X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.UP, 0);
    }

    @Test
    public void test46() {
        String labyrinth =
                "XXX" +
                "X  " +
                "X-X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.RIGHT, 1);
    }

    @Test
    public void test47() {
        String labyrinth =
                "XXX" +
                "X X" +
                "X-X";
        doTestWithRandomRotation(labyrinth, DIRECTIONS.DOWN, 2);
    }

    private void doTestWithRandomRotation(String labyrinth, DIRECTIONS expectedNewDirection, int expectedRotationChange) {
        int startRotation = 0;
        while (startRotation == 0) {
            startRotation = random.nextInt(21) - 10;
        }
        doTest(labyrinth, startRotation, expectedNewDirection, startRotation + expectedRotationChange);
    }

    private void doTest(String labyrinthString, int startRotation, DIRECTIONS expectedNewDirection, int expectedEndRotation) {
        Labyrinth labyrinth = new Labyrinth(mock(Window.class));
        labyrinth.initLabyrinth(labyrinthString, 3, 3);
        PathFinderLogicPledge pathFinder = new PathFinderLogicPledge();
        pathFinder.setRotation(startRotation);
        Point position = new Point(1, 1);
        DIRECTIONS oldDirection = null;
        if (labyrinthString.charAt(1) == '-') {
            oldDirection = DIRECTIONS.DOWN;
        } else if (labyrinthString.charAt(3) == '-') {
            oldDirection = DIRECTIONS.RIGHT;
        } else if (labyrinthString.charAt(5) == '-') {
            oldDirection = DIRECTIONS.LEFT;
        } else if (labyrinthString.charAt(7) == '-') {
            oldDirection = DIRECTIONS.UP;
        }
        DIRECTIONS newDirection = pathFinder.getNewDirection(labyrinth, position, oldDirection);
        assertEquals(expectedNewDirection, newDirection);
        assertEquals(expectedEndRotation, pathFinder.getRotation());
    }

    @Test
    public void testUltimative() {
        String labyrinthString =
                "             " +
                "  XXXXXXXXX  " +
                "  X       X  " +
                "..........X  " +
                "         .X  " +
                " ....... .X  " +
                " .XXXXX. .X  " +
                " .X...X. .X  " +
                " .X. ... .X  " +
                " .X.     .X  " +
                " .X.......X  " +
                " .XXXXXXXXX  " +
                " ............" +
                "             ";
        Labyrinth labyrinth = new Labyrinth(mock(Window.class));
        labyrinth.initLabyrinth(labyrinthString, 13, 14);
        PathFinderLogicPledge pathFinder = new PathFinderLogicPledge();
        Point position = new Point(0, 3);
        DIRECTIONS direction = DIRECTIONS.RIGHT;
        for (int i = 0; i < 57; i++) {
            direction = pathFinder.getNewDirection(labyrinth, position, direction);
            position = pathFinder.getNewPosition(position, direction);
            assertEquals('.', labyrinthString.charAt(position.y * 13 + position.x));
        }
        assertEquals(new Point(12, 12), position);
    }

}

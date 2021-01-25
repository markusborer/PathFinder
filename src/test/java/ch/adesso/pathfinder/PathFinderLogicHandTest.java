package ch.adesso.pathfinder;

import ch.adesso.pathfinder.PathFinderLogic.DIRECTIONS;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PathFinderLogicHandTest {

    @Test
    public void test1() {
        String labyrinth =
                "X X" +
                "-  " +
                "X X";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test2() {
        String labyrinth =
                "X X" +
                "- X" +
                "X X";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test3() {
        String labyrinth =
                "X X" +
                "-  " +
                "XXX";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test4() {
        String labyrinth =
                "X X" +
                "- X" +
                "XXX";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test5() {
        String labyrinth =
                "XXX" +
                "-  " +
                "X X";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test6() {
        String labyrinth =
                "XXX" +
                "-  " +
                "XXX";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test7() {
        String labyrinth =
                "XXX" +
                "- X" +
                "X X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    @Test
    public void test8() {
        String labyrinth =
                "XXX" +
                "- X" +
                "XXX";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test11() {
        String labyrinth =
                "X-X" +
                "   " +
                "X X";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test12() {
        String labyrinth =
                "X-X" +
                "   " +
                "XXX";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test13() {
        String labyrinth =
                "X-X" +
                "X  " +
                "X X";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test14() {
        String labyrinth =
                "X-X" +
                "X  " +
                "XXX";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test15() {
        String labyrinth =
                "X-X" +
                "  X" +
                "X X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    @Test
    public void test16() {
        String labyrinth =
                "X-X" +
                "X X" +
                "X X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    @Test
    public void test17() {
        String labyrinth =
                "X-X" +
                "  X" +
                "XXX";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test18() {
        String labyrinth =
                "X-X" +
                "X X" +
                "XXX";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test21() {
        String labyrinth =
                "X X" +
                "  -" +
                "X X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    @Test
    public void test22() {
        String labyrinth =
                "X X" +
                "X -" +
                "X X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    @Test
    public void test23() {
        String labyrinth =
                "XXX" +
                "  -" +
                "X X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    @Test
    public void test24() {
        String labyrinth =
                "XXX" +
                "X -" +
                "X X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    @Test
    public void test25() {
        String labyrinth =
                "X X" +
                "  -" +
                "XXX";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test26() {
        String labyrinth =
                "XXX" +
                "  -" +
                "XXX";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test27() {
        String labyrinth =
                "X X" +
                "X -" +
                "XXX";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test28() {
        String labyrinth =
                "XXX" +
                "X -" +
                "XXX";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test31() {
        String labyrinth =
                "X X" +
                "   " +
                "X-X";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test32() {
        String labyrinth =
                "XXX" +
                "   " +
                "X-X";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test33() {
        String labyrinth =
                "X X" +
                "  X" +
                "X-X";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test34() {
        String labyrinth =
                "XXX" +
                "  X" +
                "X-X";
        assertEquals(DIRECTIONS.LEFT, getNewDirection(labyrinth));
    }

    @Test
    public void test35() {
        String labyrinth =
                "X X" +
                "X  " +
                "X-X";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test36() {
        String labyrinth =
                "X X" +
                "X X" +
                "X-X";
        assertEquals(DIRECTIONS.UP, getNewDirection(labyrinth));
    }

    @Test
    public void test37() {
        String labyrinth =
                "XXX" +
                "X  " +
                "X-X";
        assertEquals(DIRECTIONS.RIGHT, getNewDirection(labyrinth));
    }

    @Test
    public void test38() {
        String labyrinth =
                "XXX" +
                "X X" +
                "X-X";
        assertEquals(DIRECTIONS.DOWN, getNewDirection(labyrinth));
    }

    private DIRECTIONS getNewDirection(String labyrinthString) {
        Labyrinth labyrinth = new Labyrinth(mock(Window.class));
        labyrinth.initLabyrinth(labyrinthString, 3, 3);
        PathFinderLogic pathFinder = new PathFinderLogicHand();
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
        return pathFinder.getNewDirection(labyrinth, position, oldDirection);
    }

}

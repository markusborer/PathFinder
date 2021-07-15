package ch.adesso.pathfinder;

import org.junit.Test;

import java.awt.Point;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class AntTest {

    /*

    Path = List<Point>
    public List<Path> goOneStep()
    public List<List<Point>> goOneStep()

       1
    XXX*2
       3

    =========
    XXX*1
       2

    =========
    XXX*1
    =========

    public Point getLastPoint()

    public List<Point> getAllPoints()

     */

    @Test
    public void deadEnd() {
        String labyrinthString =
                "XXXX" +
                "XXSX" +
                "XXXX";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertTrue(paths.isEmpty());
    }

    @Test
    public void onlyRight() {
        String labyrinthString =
                "XXXX" +
                "XXS " +
                "XXXX";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertEquals(1, paths.size());
        Point lastPoint = paths.get(0).getLastPoint();
        assertEquals(3, lastPoint.x);
        assertEquals(1, lastPoint.y);
    }

    @Test
    public void onlyRight2() {
        String labyrinthString =
                "XXXX" +
                "XS  " +
                "XXXX";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertEquals(1, paths.size());
        Point lastPoint = paths.get(0).getLastPoint();
        assertEquals(2, lastPoint.x);
        assertEquals(1, lastPoint.y);
    }

    @Test
    public void onlyDown() {
        String labyrinthString =
                "XXXX" +
                "XXSX" +
                "XX X";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertEquals(1, paths.size());
        Point lastPoint = paths.get(0).getLastPoint();
        assertEquals(2, lastPoint.x);
        assertEquals(2, lastPoint.y);
    }

    @Test
    public void onlyUp() {
        String labyrinthString =
                "XX X" +
                "XXSX" +
                "XXXX";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertEquals(1, paths.size());
        Point lastPoint = paths.get(0).getLastPoint();
        assertEquals(2, lastPoint.x);
        assertEquals(0, lastPoint.y);
    }

    @Test
    public void onlyLeft() {
        String labyrinthString =
                "XXXX" +
                "  SX" +
                "XXXX";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertEquals(1, paths.size());
        Point lastPoint = paths.get(0).getLastPoint();
        assertEquals(1, lastPoint.x);
        assertEquals(1, lastPoint.y);
    }

    @Test
    public void onlyLeft2() {
        String labyrinthString =
                "XXXX" +
                " SXX" +
                "XXXX";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertEquals(1, paths.size());
        Point lastPoint = paths.get(0).getLastPoint();
        assertEquals(0, lastPoint.x);
        assertEquals(1, lastPoint.y);
    }

    @Test
    public void getTwo() {
        String labyrinthString =
                "XX X" +
                "XXSX" +
                "XX X";
        Ant pathFinder = getPathFinderLogicShortest(labyrinthString);
        List<Ant> paths = pathFinder.goOneStep();
        assertEquals(2, paths.size());
        Point point1 = paths.get(0).getLastPoint();
        assertEquals(2, point1.x);
        assertEquals(2, point1.y);
        Point point2 = paths.get(1).getLastPoint();
        assertEquals(2, point2.x);
        assertEquals(0, point2.y);
    }

    private Ant getPathFinderLogicShortest(String labyrinthString) {
        Labyrinth labyrinth = new Labyrinth(mock(Window.class));
        labyrinth.initLabyrinth(labyrinthString, 4, 3);
        return new Ant(labyrinth);
    }

}

package ch.adesso.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Ant {

    private Labyrinth labyrinth;
    private List<Point> path;

    public Ant(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        path = new ArrayList<>();
        path.add(labyrinth.getStart());
    }

    public Ant(Labyrinth labyrinth, List<Point> path) {
        this.labyrinth = labyrinth;
        this.path = path;
    }

    public List<Point> getPath() {
        return path;
    }

    public Point getLastPoint() {
        return path.get(path.size() - 1);
    }

    public List<Ant> goOneStep() {
        ArrayList<Ant> ants = new ArrayList<>();
        addAntIfPointIsFree(ants, getRightPoint());
        addAntIfPointIsFree(ants, getDownPoint());
        addAntIfPointIsFree(ants, getUpPoint());
        addAntIfPointIsFree(ants, getLeftPoint());
        return ants;
    }

    private void addAntIfPointIsFree(ArrayList<Ant> ants, Point point) {
        boolean isPointFree = labyrinth.isEmpty(point);
        if (isPointFree) {
            ants.add(cloneAntWithNewPoint(point));
        }
    }

    private Point getRightPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x + 1, lastPoint.y);
    }

    private Point getDownPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x, lastPoint.y + 1);
    }

    private Point getUpPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x, lastPoint.y - 1);
    }

    private Point getLeftPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x - 1, lastPoint.y);
    }

    private Ant cloneAntWithNewPoint(Point point) {
        List<Point> newPath = new ArrayList<>(this.path);
        newPath.add(point);
        return new Ant(labyrinth, newPath);
    }

}

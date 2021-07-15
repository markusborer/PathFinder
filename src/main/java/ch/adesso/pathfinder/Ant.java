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

    public List<Ant> goOneStep() {
        ArrayList<Ant> paths = new ArrayList<>();
        if (isRightFree()) {
            paths.add(cloneAntWithNewPoint(getRightPoint()));
        }
        if (isDownFree()) {
            paths.add(cloneAntWithNewPoint(getDownPoint()));
        }
        if (isUpFree()) {
            paths.add(cloneAntWithNewPoint(getUpPoint()));
        }
        if (isLeftFree()) {
            paths.add(cloneAntWithNewPoint(getLeftPoint()));
        }
        return paths;
    }

    public Point getLastPoint() {
        return path.get(path.size() - 1);
    }


    public List<Point> getPath() {
        return path;
    }

    private boolean isRightFree() {
        Point rightPoint = getRightPoint();
        return labyrinth.isEmpty(rightPoint);
    }

    private boolean isDownFree() {
        Point downPoint = getDownPoint();
        return labyrinth.isEmpty(downPoint);
    }

    private boolean isUpFree() {
        Point lastPoint = getLastPoint();
        Point upPoint = new Point(lastPoint.x, lastPoint.y - 1);
        return labyrinth.isEmpty(upPoint);
    }

    private boolean isLeftFree() {
        Point leftPoint = getLeftPoint();
        return labyrinth.isEmpty(leftPoint);
    }

    private Point getUpPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x, lastPoint.y - 1);
    }

    private Point getRightPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x + 1, lastPoint.y);
    }

    private Point getDownPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x, lastPoint.y + 1);
    }

    private Point getLeftPoint() {
        Point lastPoint = getLastPoint();
        return new Point(lastPoint.x - 1, lastPoint.y);
    }

    private Ant cloneAntWithNewPoint(Point point) {
        Ant newPath = new Ant(labyrinth);
        newPath.path = new ArrayList<>(this.path);
        newPath.path.add(point);
        return newPath;
    }

}

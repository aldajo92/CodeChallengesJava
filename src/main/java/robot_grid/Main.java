package robot_grid;

import java.awt.Point;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean[][] array = {
                {true, true, true, false},
                {true, true, false, true},
                {true, false, true, true},
                {true, true, true, true}
        };

        ArrayList<Point> path = getPath(array);
        for (Point point : path) {
            System.out.println(point.x + ", " + point.y);
        }
    }

    static ArrayList<Point> getPath(boolean[][] array) {
        int r = array.length - 1;
        int c = array[0].length - 1;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(array, r, c, path)) {
            return path;
        }
        return null;
    }

    static boolean getPath(boolean[][] array, int r, int c, ArrayList<Point> path) {

        if (r < 0 || c < 0) {
            return false;
        } else if (!array[r][c]) {
            return false;
        }

        boolean isAtOrigin = r == 0 && c == 0;
        if (isAtOrigin || getPath(array, r - 1, c, path) || getPath(array, r, c - 1, path)) {
            path.add(new Point(r, c));
            return true;
        }

        return false;
    }
}

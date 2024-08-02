import java.util.ArrayList;
import java.util.List;

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class FlightPath {
    List<Coordinate> path;

    public FlightPath() {
        path = new ArrayList<>();
    }

    public void addCoordinate(int x, int y) {
        path.add(new Coordinate(x, y));
    }

    public List<Coordinate> getPath() {
        return path;
    }
}

class NoAccident {

    public static boolean doIntersect(Coordinate p1, Coordinate q1, Coordinate p2, Coordinate q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) {
            return true;
        }

        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }

    private static int orientation(Coordinate p, Coordinate q, Coordinate r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : 2; // clock or counterclockwise
    }

    private static boolean onSegment(Coordinate p, Coordinate q, Coordinate r) {
        return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
               q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }

    public static boolean isValidFlightPath(List<FlightPath> flights) {
        for (int i = 0; i < flights.size(); i++) {
            for (int j = i + 1; j < flights.size(); j++) {
                List<Coordinate> path1 = flights.get(i).getPath();
                List<Coordinate> path2 = flights.get(j).getPath();

                for (int k = 0; k < path1.size() - 1; k++) {
                    for (int l = 0; l < path2.size() - 1; l++) {
                        if (doIntersect(path1.get(k), path1.get(k + 1), path2.get(l), path2.get(l + 1))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FlightPath flight1 = new FlightPath();
        flight1.addCoordinate(1, 1);
        flight1.addCoordinate(2, 2);
        flight1.addCoordinate(3, 3);

        FlightPath flight2 = new FlightPath();
        flight2.addCoordinate(1, 1);
        flight2.addCoordinate(2, 4);
        flight2.addCoordinate(3, 2);

        FlightPath flight3 = new FlightPath();
        flight3.addCoordinate(1, 1);
        flight3.addCoordinate(4, 2);
        flight3.addCoordinate(3, 4);

        List<FlightPath> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        System.out.println("Are the flight paths valid? " + isValidFlightPath(flights));

        for (int i = 0; i < flights.size(); i++) {
            System.out.println("Flight " + (i + 1) + " path:");
            for (Coordinate coord : flights.get(i).getPath()) {
                System.out.println("(" + coord.x + ", " + coord.y + ")");
            }
        }
    }
}

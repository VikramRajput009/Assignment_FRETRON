import java.util.*;

public class SoldierCastle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of soldiers: ");
        int numSoldiers = scanner.nextInt();

        Map<String, Integer> soldiers = new HashMap<>();
        for (int i = 1; i <= numSoldiers; i++) {
            System.out.print("Enter coordinates for soldier " + i + ": ");
            String input = scanner.next();
            String[] coordinates = input.split(",");
            soldiers.put(coordinates[0] + "," + coordinates[1], 1);
        }

        System.out.print("Enter the coordinates for your specialized castle: ");
        String castleInput = scanner.next();
        String[] castleCoordinates = castleInput.split(",");
        int startX = Integer.parseInt(castleCoordinates[0]);
        int startY = Integer.parseInt(castleCoordinates[1]);

        List<String> uniquePaths = findUniquePaths(startX, startY, soldiers);
        System.out.println("Thanks. There are " + uniquePaths.size() + " unique paths for your2 'special_castle'\n");

        int pathNum = 1;
        for (String path : uniquePaths) {
            System.out.println("Path " + pathNum + ":");
            System.out.println("=======\n" + path + "Arrive (" + startX + "," + startY + ")\n");
            pathNum++;
        }
    }

    public static List<String> findUniquePaths(int startX, int startY, Map<String, Integer> soldiers) {
        List<String> uniquePaths = new ArrayList<>();
        findPaths(startX, startY, "", soldiers, uniquePaths);
        return uniquePaths;
    }

    public static void findPaths(int x, int y, String pathSoFar, Map<String, Integer> remainingSoldiers, List<String> uniquePaths) {
        if (remainingSoldiers.isEmpty()) {
            uniquePaths.add(pathSoFar);
            return;
        }

        if (x > 8 || y > 9 || x < 1 || y < 1) {
            return;
        }

        String currentCell = x + "," + y;
        if (remainingSoldiers.containsKey(currentCell)) {
            remainingSoldiers.remove(currentCell);
        }

        findPaths(x, y + 1, pathSoFar + "Kill (" + x + "," + (y + 1) + "). Turn Left\n", new HashMap<>(remainingSoldiers), uniquePaths);
        findPaths(x + 1, y, pathSoFar + "Jump (" + (x + 1) + "," + y + ")\n", remainingSoldiers, uniquePaths);
    }
}

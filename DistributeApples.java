import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DistributeApples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> apples = new ArrayList<>();

        System.out.println("Enter apple weight in grams (-1 to stop): ");
        while (true) {
            int weight = scanner.nextInt();
            if (weight == -1) {
                break;
            }
            apples.add(weight);
        }

        // Sort apples in descending order
        Collections.sort(apples, Collections.reverseOrder());

        List<Integer> ramApples = new ArrayList<>();
        List<Integer> shamApples = new ArrayList<>();
        List<Integer> rahimApples = new ArrayList<>();

        int totalWeight = apples.stream().mapToInt(Integer::intValue).sum();
        int ramTarget = 50 * totalWeight / 100;
        int shamTarget = 30 * totalWeight / 100;
        int rahimTarget = 20 * totalWeight / 100;

        int ramWeight = 0, shamWeight = 0, rahimWeight = 0;

        for (int weight : apples) {
            if (ramWeight < ramTarget) {
                if (ramWeight + weight <= ramTarget) {
                    ramApples.add(weight);
                    ramWeight += weight;
                } else {
                    // Allocate the apple to the next person if it would exceed Ram's target
                    if (shamWeight + weight <= shamTarget) {
                        shamApples.add(weight);
                        shamWeight += weight;
                    } else if (rahimWeight + weight <= rahimTarget) {
                        rahimApples.add(weight);
                        rahimWeight += weight;
                    }
                }
            } else if (shamWeight < shamTarget) {
                if (shamWeight + weight <= shamTarget) {
                    shamApples.add(weight);
                    shamWeight += weight;
                } else if (rahimWeight + weight <= rahimTarget) {
                    rahimApples.add(weight);
                    rahimWeight += weight;
                }
            } else {
                rahimApples.add(weight);
                rahimWeight += weight;
            }
        }

        // Handle any remaining apples if there are discrepancies
        for (int weight : apples) {
            if (ramWeight < ramTarget && !ramApples.contains(weight)) {
                ramApples.add(weight);
                ramWeight += weight;
            } else if (shamWeight < shamTarget && !shamApples.contains(weight)) {
                shamApples.add(weight);
                shamWeight += weight;
            } else if (rahimWeight < rahimTarget && !rahimApples.contains(weight)) {
                rahimApples.add(weight);
                rahimWeight += weight;
            }
        }

        // Output the distribution result
        System.out.println("Distribution Result: ");
        System.out.println("Ram: " + ramApples);
        System.out.println("Sham: " + shamApples);
        System.out.println("Rahim: " + rahimApples);
    }
}

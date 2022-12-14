import java.util.*;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Instant> instantList = createInstantList(scanner);

        long result = getMaxMinusMin(instantList);

        System.out.println(result);
    }

    public static List<Instant> createInstantList(Scanner scanner) {
        List<Instant> instantList = new ArrayList<>();
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));

        return instantList;
    }

    private static long getMaxMinusMin(List<Instant> instantList) {
        Instant min = Instant.MAX;
        Instant max = Instant.MIN;
        for (Instant instant : instantList) {
            if (instant.compareTo(min) < 0) {
                min = instant;
            } else {
                if (instant.compareTo(max) > 0) {
                    max = instant;
                }
            }
        }
        return max.minusSeconds(min.getEpochSecond()).getEpochSecond();
    }
}
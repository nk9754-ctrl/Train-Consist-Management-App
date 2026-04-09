import java.util.*;
import java.util.stream.Collectors;

class PassengerBogie {
    private String type;     // e.g., Sleeper, AC Chair, First Class
    private int capacity;    // seat capacity

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" + "type='" + type + '\'' + ", capacity=" + capacity + '}';
    }
}

public class TrainConsistManagementApp{

    // Loop-based filtering
    public static List<PassengerBogie> filterByLoop(List<PassengerBogie> bogies) {
        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<PassengerBogie> filterByStream(List<PassengerBogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Prepare dataset
        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogies.add(new PassengerBogie("Sleeper", i % 100)); // capacities vary 0–99
        }

        // Loop-based timing
        long startLoop = System.nanoTime();
        List<PassengerBogie> loopResult = filterByLoop(bogies);
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream-based timing
        long startStream = System.nanoTime();
        List<PassengerBogie> streamResult = filterByStream(bogies);
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Results
        System.out.println("Loop result size: " + loopResult.size());
        System.out.println("Stream result size: " + streamResult.size());
        System.out.println("Loop execution time (ns): " + loopTime);
        System.out.println("Stream execution time (ns): " + streamTime);
    }
}
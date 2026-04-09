import java.util.*;
import java.util.stream.Collectors;

// Passenger Bogie class
class PassengerBogie {
    private String type;
    private int capacity;

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
        return "PassengerBogie{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Original bogie list (reused from UC7)
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("Sleeper", 50),
                new PassengerBogie("AC Chair", 80),
                new PassengerBogie("First Class", 100),
                new PassengerBogie("Economy", 60)
        );

        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // Stream filtering: capacity > 60
        List<PassengerBogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (capacity > 60):");
        filteredBogies.forEach(System.out::println);

        // Program continues...
        System.out.println("\nProgram continues with other operations...");
    }
}
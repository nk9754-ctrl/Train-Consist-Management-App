import static org.junit.jupiter.api.Assertions.*;

// File: TrainConsistManagement.java
import java.util.*;

    public class TrainConsistManagementAppTest {
        public static void main(String[] args) {
            List<Bogie> bogies = new ArrayList<>();
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));

            // Sort using Comparator
            bogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

            System.out.println("Sorted Bogies by Capacity:");
            for (Bogie b : bogies) {
                System.out.println(b);
            }
        }
    }


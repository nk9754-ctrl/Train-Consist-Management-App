import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==================================\n");

        // Initialize train formation using LinkedHashSet
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to attach duplicate bogie
        trainFormation.add("Sleeper"); // ignored automatically

        // Display final formation
        System.out.println("Final Train Formation (in order): " + trainFormation);

        System.out.println("\nSystem ready for further operations...");
    }
}






import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==================================\n");

        // Initialize train consist using LinkedList
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies in order
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist: " + trainConsist);

        // Insert Pantry Car at position 2 (index starts at 0)
        trainConsist.add(2, "Pantry Car");
        System.out.println("\nInserted 'Pantry Car' at position 2.");
        System.out.println("Updated Train Consist: " + trainConsist);

        // Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("\nRemoved first and last bogie.");
        System.out.println("Final Train Consist: " + trainConsist);

        System.out.println("\nSystem ready for further operations...");
    }
}






import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("==================================\n");

        // Initialize bogie-capacity mapping using HashMap
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert bogies with their capacities
        bogieCapacityMap.put("Sleeper", 72);       // 72 seats
        bogieCapacityMap.put("AC Chair", 56);      // 56 seats
        bogieCapacityMap.put("First Class", 24);   // 24 seats
        bogieCapacityMap.put("Rectangular Cargo", 10000); // load capacity in kg
        bogieCapacityMap.put("Cylindrical Cargo", 8000);  // load capacity in kg

        // Display bogie-capacity details
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        System.out.println("\nSystem ready for further operations...");
    }
}






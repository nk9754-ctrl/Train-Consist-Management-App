
import java.util.*;


public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("UC2- Track Unique Bogie IDs");
        System.out.println("===============================\n");

        HashSet<String> bogies = new HashSet<>();
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogies IDs After Insertion:");
        System.out.println("Passenger Boggies: " + bogies);


    }
}






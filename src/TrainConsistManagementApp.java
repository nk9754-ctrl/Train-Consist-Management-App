import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("UC2-Add Passenger Bogies to Train");
        System.out.println("===============================\n");
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("Ac Chair");
        passengerBogies.add("First Class");

        System.out.println("Ater Adding Bogies :");
        System.out.println("Passenger Boggies: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("Ater Removing Bogie");
        System.out.println("Passenger Boggies: " + passengerBogies);

        passengerBogies.add("Second Class");
        System.out.println("Ater Adding Bogies :");
        System.out.println("Passenger Boggies: " + passengerBogies);

        System.out.println("Checking if Sleeper exis");
        boolean isPresent = passengerBogies.contains("Sleeper");

        System.out.println("Final Train Passenger Consist: ");
        System.out.println("Passenger Boggies: " + passengerBogies);
    }
}






import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // Regex patterns
    private static final String TRAIN_ID_PATTERN = "TRN-\\d{4}";
    private static final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    public static boolean validateTrainID(String trainID) {
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainID = scanner.nextLine();
        if (validateTrainID(trainID)) {
            System.out.println("✅ Valid Train ID");
        } else {
            System.out.println("❌ Invalid Train ID");
        }

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();
        if (validateCargoCode(cargoCode)) {
            System.out.println("✅ Valid Cargo Code");
        } else {
            System.out.println("❌ Invalid Cargo Code");
        }

        scanner.close();
    }
}
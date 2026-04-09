import java.util.Arrays;

public class TrainConsistManagementApp {

    public static String[] sortBogieNames(String[] bogies) {
        String[] result = bogies.clone();
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        String[] bogies = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] sorted = sortBogieNames(bogies);
        System.out.println(Arrays.toString(sorted));
    }
}
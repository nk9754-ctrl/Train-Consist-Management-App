import java.util.Arrays;

public class TrainConsistManagementApp {

    public static boolean binarySearchBogie(String[] bogies, String key) {
        if (bogies.length == 0) return false;

        String[] arr = bogies.clone();
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) return true;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        System.out.println(binarySearchBogie(bogies, "BG309"));
        System.out.println(binarySearchBogie(bogies, "BG999"));
    }
}
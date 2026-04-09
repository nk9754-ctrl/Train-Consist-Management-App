public class TrainConsistManagementApp {

    public static boolean searchBogie(String[] bogies, String key) {
        for (String b : bogies) {
            if (b.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        System.out.println(searchBogie(bogies, "BG309"));
        System.out.println(searchBogie(bogies, "BG999"));
    }
}
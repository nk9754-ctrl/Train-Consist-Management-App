public class TrainConsistManagementApp {

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int[] result = arr.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] sorted = bubbleSort(capacities);

        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }
}
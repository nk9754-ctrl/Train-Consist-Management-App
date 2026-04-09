import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(input, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(TrainConsistManagementApp.binarySearchBogie(input, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(input, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(input, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] input = {"BG101"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(input, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] input = {};
        assertFalse(TrainConsistManagementApp.binarySearchBogie(input, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] input = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(input, "BG205"));
    }
}
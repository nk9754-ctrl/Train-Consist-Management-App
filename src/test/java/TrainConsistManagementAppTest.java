import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_BogieFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.searchBogie(input, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(TrainConsistManagementApp.searchBogie(input, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.searchBogie(input, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.searchBogie(input, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] input = {"BG101"};
        assertTrue(TrainConsistManagementApp.searchBogie(input, "BG101"));
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] input = {};
        assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagementApp.searchBogie(input, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] input = {"BG101","BG205"};
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.searchBogie(input, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] input = {"BG101","BG205","BG309"};
        assertTrue(TrainConsistManagementApp.searchBogie(input, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] input = {"BG101","BG205","BG309"};
        assertFalse(TrainConsistManagementApp.searchBogie(input, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] input = {"BG101"};
        assertTrue(TrainConsistManagementApp.searchBogie(input, "BG101"));
    }
}
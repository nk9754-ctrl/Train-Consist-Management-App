import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagementApp.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagementApp.validateTrainID("TRAIN12"));
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN12A"));
        assertFalse(TrainConsistManagementApp.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-123"));
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagementApp.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET123"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-aa"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagementApp.validateTrainID(""));
        assertFalse(TrainConsistManagementApp.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-1234X"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-AB1"));
    }
}
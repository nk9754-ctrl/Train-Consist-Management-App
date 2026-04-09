import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 50);
        assertNotNull(bogie);
        assertEquals(50, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC Chair", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("First Class", 0);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -5);
        });
        assertTrue(exception.getMessage().contains("Capacity must be greater than zero"));
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 70);
        assertEquals("Sleeper", bogie.getType());
        assertEquals(70, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie bogie1 = new PassengerBogie("Sleeper", 40);
        PassengerBogie bogie2 = new PassengerBogie("AC Chair", 80);
        PassengerBogie bogie3 = new PassengerBogie("First Class", 100);

        assertEquals(40, bogie1.getCapacity());
        assertEquals(80, bogie2.getCapacity());
        assertEquals(100, bogie3.getCapacity());
    }
}
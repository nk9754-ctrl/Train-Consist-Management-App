import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementAppTest {

    private List<PassengerBogie> sampleBogies() {
        return Arrays.asList(
                new PassengerBogie("Sleeper", 50),
                new PassengerBogie("AC Chair", 70),
                new PassengerBogie("First Class", 80)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<PassengerBogie> result = TrainConsistManagementApp.filterByLoop(sampleBogies());
        assertEquals(2, result.size()); // only 70 and 80 pass
    }

    @Test
    void testStreamFilteringLogic() {
        List<PassengerBogie> result = TrainConsistManagementApp.filterByStream(sampleBogies());
        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<PassengerBogie> loopResult = TrainConsistManagementApp.filterByLoop(sampleBogies());
        List<PassengerBogie> streamResult = TrainConsistManagementApp.filterByStream(sampleBogies());
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<PassengerBogie> bogies = sampleBogies();
        long start = System.nanoTime();
        TrainConsistManagementApp.filterByLoop(bogies);
        long end = System.nanoTime();
        long elapsed = end - start;
        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            bogies.add(new PassengerBogie("Sleeper", i % 100));
        }
        List<PassengerBogie> loopResult = TrainConsistManagementApp.filterByLoop(bogies);
        List<PassengerBogie> streamResult = TrainConsistManagementApp.filterByStream(bogies);
        assertEquals(loopResult.size(), streamResult.size());
    }
}
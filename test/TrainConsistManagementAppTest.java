import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private List<PassengerBogie> createBogies() {
        return Arrays.asList(
                new PassengerBogie("Sleeper", 50),
                new PassengerBogie("AC Chair", 80),
                new PassengerBogie("First Class", 100),
                new PassengerBogie("Economy", 60)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<PassengerBogie> bogies = createBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<PassengerBogie> bogies = createBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 60));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<PassengerBogie> bogies = createBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.stream().noneMatch(b -> b.getCapacity() < 60));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<PassengerBogie> bogies = createBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<PassengerBogie> bogies = createBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 150)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("Luxury", 200),
                new PassengerBogie("Super AC", 180)
        );

        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<PassengerBogie> bogies = Collections.emptyList();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<PassengerBogie> bogies = createBogies();
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(4, bogies.size()); // original list unchanged
    }
}
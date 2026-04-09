import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppUC9Test {

    private List<Bogie> createBogies() {
        return Arrays.asList(
                new PassengerBogie("Sleeper", 50),
                new PassengerBogie("AC Chair", 80),
                new PassengerBogie("First Class", 100),
                new PassengerBogie("Sleeper", 60),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Cylindrical", "Oil"),
                new GoodsBogie("Rectangular", "Grain")
        );
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("Rectangular"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("Rectangular").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(5, grouped.keySet().size()); // Sleeper, AC Chair, First Class, Rectangular, Cylindrical
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = Collections.emptyList();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(
                new PassengerBogie("Sleeper", 70),
                new PassengerBogie("Sleeper", 80)
        );

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(1, grouped.keySet().size());
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class", "Rectangular", "Cylindrical")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("Rectangular").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = createBogies();
        int originalSize = bogies.size();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(originalSize, bogies.size());
    }
}
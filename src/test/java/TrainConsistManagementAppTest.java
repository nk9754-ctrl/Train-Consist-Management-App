import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("GB201", BogieShape.CYLINDRICAL);
        boolean result = bogie.assignCargo("Petroleum");
        assertTrue(result);
        assertEquals("Petroleum", bogie.getCargoType());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("GB202", BogieShape.RECTANGULAR);
        boolean result = bogie.assignCargo("Petroleum");
        assertFalse(result);
        assertNull(bogie.getCargoType());
        assertTrue(
            bogie.getLogs().stream().anyMatch(log ->
                log.contains("Unsafe cargo assignment: Petroleum cannot be assigned to a Rectangular bogie."))
        );
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("GB203", BogieShape.RECTANGULAR);
        bogie.assignCargo("Petroleum");
        assertNull(bogie.getCargoType());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("GB204", BogieShape.RECTANGULAR);
        GoodsBogie bogie2 = new GoodsBogie("GB205", BogieShape.CYLINDRICAL);

        boolean first = bogie1.assignCargo("Petroleum");
        boolean second = bogie2.assignCargo("Petroleum");

        assertFalse(first);
        assertTrue(second);
        assertEquals("Petroleum", bogie2.getCargoType());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie1 = new GoodsBogie("GB206", BogieShape.RECTANGULAR);
        GoodsBogie bogie2 = new GoodsBogie("GB207", BogieShape.CYLINDRICAL);

        bogie1.assignCargo("Petroleum");
        bogie2.assignCargo("Coal");

        assertTrue(
            bogie1.getLogs().stream().anyMatch(log ->
                log.equals("Cargo assignment process completed for GB206"))
        );
        assertTrue(
            bogie2.getLogs().stream().anyMatch(log ->
                log.equals("Cargo assignment process completed for GB207"))
        );
    }
}
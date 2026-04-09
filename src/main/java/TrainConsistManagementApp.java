import java.util.ArrayList;
import java.util.List;

class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

enum BogieShape {
    RECTANGULAR,
    CYLINDRICAL
}

class GoodsBogie {
    private final String bogieId;
    private final BogieShape shape;
    private String cargoType;
    private final List<String> logs = new ArrayList<>();

    public GoodsBogie(String bogieId, BogieShape shape) {
        this.bogieId = bogieId;
        this.shape = shape;
    }

    public boolean assignCargo(String cargoType) {
        boolean assigned = false;
        try {
            validateCargoCompatibility(cargoType);
            this.cargoType = cargoType;
            logs.add("Cargo assigned successfully: " + cargoType);
            System.out.println("Cargo assigned successfully to " + bogieId + ": " + cargoType);
            assigned = true;
        } catch (CargoSafetyException e) {
            logs.add("Error: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        } finally {
            logs.add("Cargo assignment process completed for " + bogieId);
            System.out.println("Cargo assignment process completed for " + bogieId);
        }
        return assigned;
    }

    private void validateCargoCompatibility(String cargoType) {
        if (shape == BogieShape.RECTANGULAR && cargoType.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("Unsafe cargo assignment: Petroleum cannot be assigned to a Rectangular bogie.");
        }
    }

    public String getBogieId() {
        return bogieId;
    }

    public BogieShape getShape() {
        return shape;
    }

    public String getCargoType() {
        return cargoType;
    }

    public List<String> getLogs() {
        return logs;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        GoodsBogie bogie1 = new GoodsBogie("GB101", BogieShape.CYLINDRICAL);
        GoodsBogie bogie2 = new GoodsBogie("GB102", BogieShape.RECTANGULAR);
        GoodsBogie bogie3 = new GoodsBogie("GB103", BogieShape.RECTANGULAR);

        bogie1.assignCargo("Petroleum");
        bogie2.assignCargo("Petroleum");
        bogie3.assignCargo("Coal");

        System.out.println("Application continued safely after cargo validation.");
    }
}

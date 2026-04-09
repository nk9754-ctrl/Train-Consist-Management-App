import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    private String type;   // e.g., Cylindrical, Rectangular, Box
    private String cargo;  // e.g., Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "GoodsBogie{" + "type='" + type + '\'' + ", cargo='" + cargo + '\'' + '}';
    }
}

public class TrainConsistManagementApp{

    public static boolean validateSafety(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> {
                    if (b.getType().equalsIgnoreCase("Cylindrical")) {
                        return b.getCargo().equalsIgnoreCase("Petroleum");
                    }
                    return true; // Non-cylindrical bogies can carry any cargo
                });
    }

    public static void main(String[] args) {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        boolean isSafe = validateSafety(bogies);

        if (isSafe) {
            System.out.println("✅ Train formation is SAFE.");
        } else {
            System.out.println("❌ Train formation is UNSAFE.");
        }
    }
}
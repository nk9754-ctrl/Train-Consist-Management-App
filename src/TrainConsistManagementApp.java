// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" + "type='" + type + '\'' + ", capacity=" + capacity + '}';
    }
}

// Main Application
public class TrainConsistManagementApp{
    public static void main(String[] args) {
        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 50);
            System.out.println("✅ Created: " + bogie1);

            PassengerBogie bogie2 = new PassengerBogie("AC Chair", 0); // invalid
            System.out.println("✅ Created: " + bogie2);

        } catch (InvalidCapacityException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
public class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 2, 550.0, 300.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Type: " + getName() + " | Beds: " + getNumberOfBeds() + " | Price: $" + getPrice());
    }
}

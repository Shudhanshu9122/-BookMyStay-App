public class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 350.0, 150.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Type: " + getName() + " | Beds: " + getNumberOfBeds() + " | Price: $" + getPrice());
    }
}

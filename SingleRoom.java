public class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 200.0, 100.0);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Type: " + getName() + " | Beds: " + getNumberOfBeds() + " | Price: $" + getPrice());
    }
}

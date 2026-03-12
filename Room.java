public abstract class Room {
    private String name;
    private int numberOfBeds;
    private double size;
    private double price;

    public Room(String name, int numberOfBeds, double size, double price) {
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.price = price;
    }

    public String getName() { return name; }
    public int getNumberOfBeds() { return numberOfBeds; }
    public double getSize() { return size; }
    public double getPrice() { return price; }

    public abstract void displayDetails();
}

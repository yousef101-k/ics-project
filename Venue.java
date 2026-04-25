public class Venue {
    String name;
    String type;
    int capacity;

    public Venue(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " (" + type + ", cap=" + capacity + ")";
    }
}

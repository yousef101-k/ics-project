public class Event {
    String name;
    String type;
    DateTime start;
    DateTime end;
    Venue venue;
    Department dept;

    public Event(String name, String type, DateTime start,
                 DateTime end, Venue venue, Department dept)
            throws InvalidTimeException {

        if (!start.isBefore(end)) {
            throw new InvalidTimeException("Start must be before end");
        }

        this.name = name;
        this.type = type;
        this.start = start;
        this.end = end;
        this.venue = venue;
        this.dept = dept;
    }

    // Check overlap
    public boolean overlaps(Event other) {
        return !(this.end.isBefore(other.start) || this.start.isAfter(other.end));
    }

    public String toString() {
        return name + " | " + type + " | " + start + " -> " + end + " | " + venue;
    }
}

public class DateTime {
    int day, month, year, hour, minute;

    public DateTime(int d, int m, int y, int h, int min) {
        day = d;
        month = m;
        year = y;
        hour = h;
        minute = min;
    }

    // Compare this < other
    public boolean isBefore(DateTime other) {
        if (year != other.year) return year < other.year;
        if (month != other.month) return month < other.month;
        if (day != other.day) return day < other.day;
        if (hour != other.hour) return hour < other.hour;
        return minute < other.minute;
    }

    public boolean isAfter(DateTime other) {
        return !isBefore(other) && !equals(other);
    }

    public String toString() {
        return day + "/" + month + "/" + year + " " + hour + ":" + minute;
    }
}

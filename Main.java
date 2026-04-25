//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Event\n2. View Events\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // fix input bug

            if (choice == 1) {
                try {
                    System.out.print("Event name: ");
                    String name = sc.nextLine();

                    System.out.print("Type: ");
                    String type = sc.nextLine();

                    System.out.println("Start (d m y h min): ");
                    DateTime start = new DateTime(
                            sc.nextInt(), sc.nextInt(), sc.nextInt(),
                            sc.nextInt(), sc.nextInt()
                    );

                    System.out.println("End (d m y h min): ");
                    DateTime end = new DateTime(
                            sc.nextInt(), sc.nextInt(), sc.nextInt(),
                            sc.nextInt(), sc.nextInt()
                    );
                    sc.nextLine(); // clear buffer

                    System.out.print("Venue name: ");
                    String vname = sc.nextLine();

                    System.out.print("Venue type: ");
                    String vtype = sc.nextLine();

                    System.out.print("Capacity: ");
                    int cap = sc.nextInt();
                    sc.nextLine();

                    Venue v = new Venue(vname, vtype, cap);

                    System.out.print("Department: ");
                    String dname = sc.nextLine();

                    System.out.print("Responsible: ");
                    String resp = sc.nextLine();

                    Department d = new Department(dname, resp);

                    Event newEvent = new Event(name, type, start, end, v, d);

                    // 🔥 OVERLAP CHECK
                    for (Event e : events) {
                        if (e.venue.name.equals(v.name) && e.overlaps(newEvent)) {
                            throw new OverlapException("Another event already exists at this venue during this time!");
                        }
                    }

                    events.add(newEvent);
                    System.out.println("Event added successfully.");

                } catch (InvalidTimeException | OverlapException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            else if (choice == 2) {
                for (Event e : events) {
                    System.out.println(e);
                }
            }

            else if (choice == 3) {
                break;
            }
        }

        sc.close();
    }
}

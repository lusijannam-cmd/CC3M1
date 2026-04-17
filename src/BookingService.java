import java.util.*;

public class BookingService {
    private static BookingDAO bookingDAO = new BookingDAO();
    private static ExhibitDAO exhibitDAO = new ExhibitDAO();

    public static void create(Scanner sc, User u) {
        ArrayList<String> ex = exhibitDAO.getAll();
        System.out.println("\n--- SELECT EXHIBIT ---");
        for (int i = 0; i < ex.size(); i++)
            System.out.println("[" + (i + 1) + "] " + ex.get(i));
            System.out.println("[0] Back");
        System.out.print("Choice: ");
        int choice = Main.getIntInput();
        if (choice > 0 && choice <= ex.size()) {
            System.out.print("Date (YYYY-MM-DD): ");
            String d = sc.next();
            System.out.print("Time: ");
            sc.nextLine();
            String t = sc.nextLine();
            System.out.print("Pax: ");
            int p = Main.getIntInput();
            bookingDAO.save(new Booking.Builder().setUserName(u.getName()).setExhibitName(ex.get(choice - 1)).setDate(d)
                    .setTime(t).setPax(p).build());
            System.out.println("Booking submitted for approval.");
        }
    }

    public static void viewMine(User u) {
        System.out.println("\n--- MY BOOKINGS ---");
        System.out.printf("%-5s | %-15s | %-12s | %-10s\n", "ID", "Exhibit", "Date", "Status");
        for (Booking b : bookingDAO.getAll()) {
            if (b.getUserName().equals(u.getName()))
                System.out.printf("%-5d | %-15s | %-12s | %-10s\n", b.getId(), b.getExhibitName(), b.getDate(),
                        b.getStatus());
        }
    }

    public static void adminManage() {
        System.out.println("\n--- ALL PENDING/PROCESSED BOOKINGS ---");
        for (Booking b : bookingDAO.getAll())
            System.out.printf("ID:%d | User:%s | Exhibit:%s | Status:%s\n", b.getId(), b.getUserName(),
                    b.getExhibitName(), b.getStatus());
        System.out.print("ID to update (0 to back): ");
        int id = Main.getIntInput();
        if (id > 0) {
            System.out.print("[1] Approve [2] Reject: ");
            int act = Main.getIntInput();
            bookingDAO.updateStatus(id, act == 1 ? "Approved" : "Rejected");
            System.out.println("Status Updated!");
        }
    }
}
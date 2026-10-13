class Booking {
    String movie, customer;
    double price;
    int tickets;

    // Constructors
    Booking() { this("Unknown", 0, 0, "Pawan"); }
    Booking(String movie, String customer) { this(movie, 0, 0, customer); }
    Booking(String movie, double price, int tickets, String customer) {
        this.movie = movie.trim();
        this.customer = customer.trim();
        this.price = price;
        this.tickets = tickets;
    }

    // Overloaded booking methods
    boolean book(int tickets) {
        if (tickets < 1 || tickets > 10) {
            System.out.println("Invalid ticket count: " + tickets);
            return false;
        }
        this.tickets = tickets;
        return true;
    }

    boolean book(int tickets, double price) {
        this.price = price;
        return book(tickets);
    }

    boolean book(String movie, int tickets, double price) {
        this.movie = movie.trim();
        return book(tickets, price);
    }

    // Calculation: 10% discount for 5+ tickets
    double finalAmount() {
        double total = price * tickets;
        return tickets >= 5 ? total * 0.90 : total;
    }

    // String comparison
    boolean sameCustomer(Booking b) {
        return customer.equalsIgnoreCase(b.customer);
    }

    void display() {
        System.out.println("Customer : " + customer.toUpperCase());
        System.out.println("Movie    : " + movie.toUpperCase());
        System.out.println("Tickets  : " + tickets + " x Rs." + price);
        System.out.println("Final    : Rs." + finalAmount());
        System.out.println("-----------------------");
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Booking b1 = new Booking("Inception", 250, 5, " Ishita Sharma ");
        Booking b2 = new Booking("Interstellar", "ishita sharma");
        b2.book(3, 300);
        Booking b3 = new Booking();
        b3.book("Dune", 2, 280);
        b3.book(15);  // invalid

        b1.display();
        b2.display();
        b3.display();

        System.out.println("b1 and b2 same customer? " + b1.sameCustomer(b2));
    }
}

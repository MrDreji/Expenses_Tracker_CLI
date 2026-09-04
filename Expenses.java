import java.time.LocalDateTime;

public class Expenses {

    private String name;
    private double amount;
    private String category;
    private LocalDateTime dateTime;


    // Constructor
    public Expenses(String name, double amount, String category, LocalDateTime dateTime) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.dateTime = dateTime;
        }
        // Getters
        public String getName() {
            return name;
        }

        public double getAmount() {
            return amount;
        }

        public String getCategory() {
            return category;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseManager {

    private ArrayList<Expenses> expenses = new ArrayList<>();

    public void addExpense() {
        System.out.print("Enter expense Name: ");
        String name = System.console().readLine().toLowerCase();
        
        double amount = 0;

        while (true) {
            System.out.print("Enter expense Amount: ");
            String amountInput = System.console().readLine();
            try {
                amount = Double.parseDouble(amountInput);
                break; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the amount. \n");
            }
        }

        String category;
        while (true) {
            System.out.print("Enter expense Category (1-Food, 2-Transportation, 3-Entertainment, 4-Bills, 5-Other): ");
            String input = System.console().readLine();
            switch (input) {
                case "1": category = "Food"; break;
                case "2": category = "Transportation"; break;
                case "3": category = "Entertainment"; break;
                case "4": category = "Bills"; break;
                case "5": category = "Other"; break;
                default:
                    System.out.println("Invalid choice. Please enter a number 1-5.");
                    continue; // re-prompt, skip the break below
            }
            break; // valid choice made, exit the while loop
        }
        
        Expenses expense = new Expenses(name, amount, category, java.time.LocalDateTime.now());
        expenses.add(expense);

        System.out.println("\nExpense added successfully! \n");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet. \n");
            return;
        }

        System.out.println("=====List of Expenses=====");
        for (Expenses expense : expenses) {
            System.out.println("Expense Number: " + (expenses.indexOf(expense) + 1));
            System.out.println("Name: " + expense.getName());
            System.out.println("Amount: $" + expense.getAmount());
            System.out.println("Category: " + expense.getCategory());
            System.out.println("Date and Time: " + expense.getDateTime());
            System.out.println("---------------------------");
        }
    }

    public void deleteExpenses(Scanner scanner) {
        if (expenses.isEmpty()) {
            System.out.println("Nothing to delete — the list is empty.\n");
            return;
        }
 
        viewExpenses();
        System.out.print("Enter the number of the expense to delete (0 to cancel): ");
 
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Deletion cancelled.\n");
            return;
        }
 
        if (choice == 0) {
            System.out.println("Deletion cancelled.\n");
            return;
        }
 
        // Convert the 1-based number the user sees back to a 0-based index
        int index = choice - 1;
        if (index < 0 || index >= expenses.size()) {
            System.out.println("No expense with that number.\n");
            return;
        }
 
        Expenses removed = expenses.remove(index);
        System.out.println("Deleted expense:");
        System.out.println("  Name:   " + removed.getName());
        System.out.printf( "  Amount: $%.2f%n", removed.getAmount());
        System.out.println("  Date:   " + removed.getDateTime());
        System.out.println();
    }

    public void summaryOfExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize yet.\n");
            return;
        }
 
        double total = 0;
        Map<String, Double> byCategory = new HashMap<>();
 
        for (Expenses expense : expenses) {
            total += expense.getAmount();
            // merge(): if the category exists, add to it; otherwise start it at this amount
            byCategory.merge(expense.getCategory(), expense.getAmount(), Double::sum);
        }
 
        System.out.println("\n--- Expense Summary ---");
        System.out.printf("Total spent: $%.2f%n", total);
        System.out.println("By category:");
        for (Map.Entry<String, Double> entry : byCategory.entrySet()) {
            System.out.printf("  %-12s $%.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
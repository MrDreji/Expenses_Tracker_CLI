import java.util.Scanner;

public class Main {
    // Universal Scanner
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ExpenseManager expenseManager = new ExpenseManager();

        boolean exit = true;

        while(exit){
            System.out.println("=====Expense Tracker=====\n 1 Add Expense\n 2 View Expenses\n 3 Delete Expenses\n 4 Summary Of Expenses\n 5 Exit");
            System.out.print("Please Enter a Number to perform a task: ");

            // Checks User Input
            if (input.hasNextInt()) {
                int num = input.nextInt();

                input.nextLine();

                switch (num) {
                case 1:
                    System.out.println("You have choosen 1 Add Expenses \n");
                    expenseManager.addExpense();
                    break;
                case 2:
                    System.out.println("You have choosen 2 View Expenses \n");
                    expenseManager.viewExpenses();
                    break;
                case 3:
                    System.out.println("You have choosen 3 Delete Expenses \n");
                    expenseManager.deleteExpenses(input);
                    break;
                case 4:
                    System.out.println("You have choosen 4 View Summary of the Expenses \n");
                    expenseManager.summaryOfExpenses();
                    break;
                case 5:
                    System.out.print("Thank you, exiting programm......... \n ");
                    exit = false;
                    return;
                default:
                    System.out.println("Incorrect Input Please Try Again! \n");
                }
                
            } else {
                System.err.println("Incorrect Input Please Try Again! \n");
                input.next();
            }    
        }
        

    }
}
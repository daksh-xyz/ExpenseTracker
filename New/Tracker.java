package New;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Tracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = ExpenseStorage.loadExpenses();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete an Expense");
            System.out.println("4. Clear Expenses");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Item name: ");
                    String Name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    String Quantity = sc.nextLine();
                    System.out.print("Enter price of item: ");
                    String amount = sc.nextLine();
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    String time = currentDateTime.toString();
                    expenses.add(new Expense(Name, Quantity, amount, time));
                    ExpenseStorage.saveExpenses(expenses);
                    break;
                case 2:
                    for (Expense e : expenses) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter id: ");
                    int id = sc.nextInt();
                    ExpenseStorage.DeleteExpenses(expenses, id);
                    break;

                case 4:
                    ExpenseStorage.Clear();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        }
    }
}
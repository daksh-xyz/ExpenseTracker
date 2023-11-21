package Main;

import java.util.ArrayList;
import java.util.Scanner;

import StorageAndServices.*;
import Utils.*;

public class Tracker {
    static float budget;
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Services> expenses = ExpenseStorage.loadExpenses();
            while (true) {
                if(Budget.getFlag() == 0){
                    System.out.println("Welcome to my Expense Tracker !");
                    System.out.print("Enter budget amount: ");
                    budget = sc.nextFloat();
                    Budget.setBudget(budget);
                    Budget.setFlag(1);
                }
                System.out.println("\nExpense Tracker Menu:");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. Delete an Expense");
                System.out.println("4. Clear Expenses");
                System.out.println("5. Edit budget");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        if(Total.getTotal() >= Budget.getBudget()){
                            System.out.println("\nError: YOU CANNOT EXCEED THE SPECIFIED BUDGET: " + Budget.getBudget());
                            return;
                        }
                        sc.nextLine();
                        System.out.print("\nEnter Item name: ");
                        String Name = sc.nextLine();
                        System.out.print("Enter quantity: ");
                        String Quantity = sc.nextLine();
                        System.out.print("Enter price of item: ");
                        String amount = sc.nextLine();
                        int amt = Integer.parseInt(amount);
                        if((amt + Total.getTotal()) >= Budget.getBudget()){
                            System.out.println("\nError: YOU CANNOT EXCEED THE SPECIFIED BUDGET: " + Budget.getBudget());
                            break;
                        }
                        String time = Date.getDate();
                        expenses.add(new Services(Name, Quantity, amount, time));
                        ExpenseStorage.saveExpenses(expenses);
                        if((Budget.getBudget() * 0.50) < Total.getTotal()){
                            System.out.println("\n WARNING: YOU HAVE SPENT 50% OF YOUR EXPENSE LIMIT !");
                        }else if((Budget.getBudget() * 0.75) < Total.getTotal()){
                            System.out.println("\n WARNING: YOU ARE APPROACHING YOUR EXPENSE LIMIT !");
                        }
                        break;
                    case 2:
                        int ID = 1;
                        System.out.println();
                        if(expenses.size() == 0){
                            System.out.println("\nNo data found, add new data...");
                        }else{
                            System.out.println(Table.HeaderCol());
                            for (Services e : expenses) {
                                System.out.println("|\t" + ID + " " + e);
                                System.out.println(Table.Lines());
                                ID++;
                            }
                            System.out.println(Table.TotalCol());
                        }
                        break;
                    
                    case 3:
                        sc.nextLine();
                        System.out.print("\nEnter id: ");
                        int DelId = sc.nextInt();
                        ExpenseStorage.DeleteExpenses(expenses, DelId);
                        break;

                    case 4:
                        ExpenseStorage.Clear();
                        Budget.setFlag(0);
                        Budget.setBudget(0);
                        System.out.println("\nExpenses cleared successfully !\n");
                        break;
                    case 5:
                        System.out.print("Enter new budget: ");
                        int newBuddget = sc.nextInt();
                        Budget.setBudget(newBuddget);
                        break;
                    case 6:
                        System.out.println("\nGoodbye!");
                        return;
                    
                    default:
                        System.out.println("\nInvalid choice. Please select from the menu.");
                }
            }
        }
    }
}

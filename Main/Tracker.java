package Main;

import java.util.ArrayList;
import java.util.Scanner;

import StorageAndServices.*;
import Utils.*;

public class Tracker {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Services> expenses = ExpenseStorage.loadExpenses();

            while (true) {
                System.out.println("\nExpense Tracker Menu:");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. Delete an Expense");
                System.out.println("4. Clear Expenses");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.print("\nEnter Item name: ");
                        String Name = sc.nextLine();
                        System.out.print("Enter quantity: ");
                        String Quantity = sc.nextLine();
                        System.out.print("Enter price of item: ");
                        String amount = sc.nextLine();
                        String time = Date.getDate();
                        expenses.add(new Services(Name, Quantity, amount, time));
                        ExpenseStorage.saveExpenses(expenses);
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
                        ID = 1;
                        System.out.println("\nExpenses cleared successfully !\n");
                        break;
        
                    case 5:
                        System.out.println("\nGoodbye!");
                        return;
                    
                    default:
                        System.out.println("\nInvalid choice. Please select from the menu.");
                }
            }
        }
    }
}
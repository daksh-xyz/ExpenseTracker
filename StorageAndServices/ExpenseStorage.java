package StorageAndServices;
import java.io.*;
import java.util.ArrayList;

public class ExpenseStorage{
    static File FILE = new File("./DataBase/Data.csv");
    public static ArrayList<Services> expenses = new ArrayList<>();

    public static void saveExpenses(ArrayList<Services> expenses){
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE))) {
            for (Services e : expenses) {
                writer.println(e.getName() + "," + e.getQuantity() + "," + e.getAmount() + "," + e.getDateTime());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("\nError saving expenses: " + e.getMessage());
        }
    }

    public static ArrayList<Services> loadExpenses(){
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                expenses.add(new Services(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (IOException e) {
            System.out.println("\nError loading expenses: " + e.getMessage());
        }
        return expenses;
    }

    public static void DeleteExpenses(ArrayList<Services> expensed, int rowIndex){
        if (rowIndex >= 0 && rowIndex <= expenses.size()) {
            expenses.remove(rowIndex - 1);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
                for (Services expense : expenses) {
                    writer.write(expense.getName() + "," + expense.getQuantity() + "," + expense.getAmount() + "," + expense.getDateTime());
                    writer.newLine();
                }
                writer.close();
                System.out.println("\nExpense deleted successfully.");
            } catch (IOException e) {
                System.out.println("\nError writing expenses: " + e.getMessage());
            }
        } else if (expensed.size() == 0){
            System.out.println("\nNo data found.");
        }
        else {
            System.out.println("\nInvalid id");
        }
    }

    public static void Clear(){
        if(expenses.size() == 0){
            System.out.println("\nNo data found, please enter new data before clearing !");
        }
        expenses.clear();
        try (FileWriter fileWriter = new FileWriter(FILE, false)) {
        } catch (IOException e) {
            System.out.println("\nError clearing the CSV file: " + e.getMessage());
        }
    }
    
}
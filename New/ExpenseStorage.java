package New;
import java.io.*;
import java.util.ArrayList;

public class ExpenseStorage{
    private static final String FILENAME = "Data.csv";
    public static ArrayList<Expense> expenses = new ArrayList<>();

    public static void saveExpenses(ArrayList<Expense> expenses) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Expense e : expenses) {
                writer.println(e.getName() + "," + e.getQuantity() + "," + e.getAmount() + "," + e.getDateTime());
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    public static ArrayList<Expense> loadExpenses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                expenses.add(new Expense(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
        return expenses;
    }

    public static void DeleteExpenses(ArrayList<Expense> expensed, int rowIndex) {
        if (rowIndex >= 0 && rowIndex < expenses.size()) {
            expenses.remove(rowIndex);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
                for (Expense expense : expenses) {
                    writer.write(expense.getName() + "," + expense.getQuantity() + "," + expense.getAmount() + "," + expense.getDateTime());
                    writer.newLine();
                }
                System.out.println("Expense deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error writing expenses: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid row index");
        }
    }

    public static void Clear() {
        expenses.clear(); // This will clear the "expenses" ArrayList.
        try (FileWriter fileWriter = new FileWriter(FILENAME, false)) {
            // Clear the CSV file as you previously intended.
        } catch (IOException e) {
            System.out.println("Error clearing the CSV file: " + e.getMessage());
        }
    }
    
}
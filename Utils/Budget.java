package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Budget{
    private static float mybudget;
    private static int flag;
    static File FILE = new File("./DataBase/Budget.txt");
    static File FlagFile = new File("./DataBase/Flag.txt");
    
    public static void setBudget(float budget){
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE))) {
            writer.println("Budget: " + budget);
            writer.close();
        } catch (IOException e) {
            System.out.println("\nError saving budget: " + e.getMessage());
        }
    }

    public static float getBudget(){
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            String[] parts;
            while ((line = reader.readLine()) != null) {
                parts = line.split("Budget: ");
                mybudget = Float.parseFloat(parts[1]);
            }
        } catch (IOException e) {
            System.out.println("\nError loading expenses: " + e.getMessage());
        }
        return mybudget;
    }

    public static void setFlag(int myflag){
        try (PrintWriter writer = new PrintWriter(new FileWriter(FlagFile))) {
            writer.println("Flag: " + myflag);
            writer.close();
        } catch (IOException e) {
            System.out.println("\nError saving budget: " + e.getMessage());
        }
    }

    public static float getFlag(){
        try (BufferedReader reader = new BufferedReader(new FileReader(FlagFile))) {
            String line;
            String[] parts;
            while ((line = reader.readLine()) != null) {
                parts = line.split("Flag: ");
                flag = Integer.parseInt(parts[1]);
            }
        } catch (IOException e) {
            System.out.println("\nError loading expenses: " + e.getMessage());
        }
        return flag;
    }
}

package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Total {
    public static int getTotal(){
        int total = 0;
        File FILE = new File("./DataBase/Data.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
                String line;
                int i = 3;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    int temp = Integer.parseInt(parts[i]);
                    total += temp;
                }
            } catch (IOException e) {
                System.out.println("\nError loading expenses: " + e.getMessage());
        }
        return total;
    }
}

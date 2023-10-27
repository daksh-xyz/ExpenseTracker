package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date{
    public static String getDate(){
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define a custom date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");

        // Format the current date using the custom format
        String formattedDate = currentDate.format(formatter);

        //return the formatted date to be used in Tracker file
        return formattedDate;
    }
}
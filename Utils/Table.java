package Utils;

public class Table{
    public static String HeaderCol(){
        String x = "+---------------+-----------------------+-----------------------+-----------------------+-----------------------+\n|\tID\t|\tName\t\t|\tQuantity\t|\tAmount\t\t|\t  Date\t\t|\n+---------------+-----------------------+-----------------------+-----------------------+-----------------------+";
        return x;
    }
    public static String Lines(){
        String line = "+---------------+-----------------------+-----------------------+-----------------------+-----------------------+";
        return line;
    }
    public static String TotalCol(){
        String TLine = "\t\t\t\t\t\t\t\t|\tTotal: " + Total.getTotal() + "\t|\n\t\t\t\t\t\t\t\t+-----------------------+";
        return TLine;
    }
}

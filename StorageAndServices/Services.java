package StorageAndServices;

public class Services {
    private String ItemQuantity;
    private String ItemName;
    private String ItemPrice;
    private String currentDateTime;

    public Services(String Name, String Quantity, String amount, String currDateTime) {
        this.ItemQuantity = Quantity;
        this.ItemName = Name;
        this.ItemPrice = amount;
        this.currentDateTime = currDateTime;
    }

    public String getDateTime(){
        return currentDateTime;
    }

    public String getQuantity() {
        return ItemQuantity;
    }

    public String getName() {
        return ItemName;
    }

    public String getAmount() {
        return ItemPrice;
    }

    // public String getTotal(){
        
    // }

    @Override
    public String toString() {
        return "Item= " + ItemName + ", Quantity= " + ItemQuantity +  ", amount=" + ItemPrice + ", Date = " + currentDateTime;
    }
}
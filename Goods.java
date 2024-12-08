public class Goods {
    
    // Attributes
    private String name;
    private int remainingAmount;
    private float price;


    // Constructor
    public Goods(String name, int amount, float price) {
        this.name = name;
        this.remainingAmount = amount;
        this.price = price;
    }


    // Accessors
    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.remainingAmount;
    }

    public float getPrice() {
        return this.price;
    }


    // Methods
    public void addAmount(int amount) {
        this.remainingAmount += amount;
    }

    public void removeAmount(int amount) {
        if ((this.remainingAmount - amount) < 0) {
            throw new RuntimeException("There are not enough goods to sell.");
        } else {
            this.remainingAmount -= amount;
        }
    }
}

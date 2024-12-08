import java.util.Hashtable;

public class Dish {

    // Attributes
    private String name;
    private Hashtable<String, Integer> ingredients;
    private int price;


    // Constructor
    public Dish(String name, Hashtable<String, Integer> ingredients, int price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }


    // Accessor
    public String getName() {
        return this.name;
    }

    public Hashtable<String, Integer> getIngredients() {
        return this.ingredients;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }


    // Method
    public void printIngredients() {
        System.out.println(ingredients.toString());
    }
}

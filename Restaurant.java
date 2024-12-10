import java.util.Hashtable;
import java.util.Enumeration;

public class Restaurant extends Building{

    // Attributes
    private Hashtable<String, Object> menu;
    //private Hashtable<String, Integer> stock;


    // Constructor
    public Restaurant(String name, String address, Hashtable<String, Object> menu) {
        super(name, address);
        this.menu = menu;
        //this.stock = stock;
    }


    // Methods
    // public void sell(String dishName, int amount) {
    //     if (menu.containsKey(dishName)) {
    //         Object dish = menu.get(dishName);
    //         Enumeration<String> keys = ingredients.keys();
    //         while (keys.hasMoreElements()) {
    //             String key = keys.nextElement();
    //             int value = ingredients.get(key);
    //             int stockValue = stock.get(key);
    //             if ((stockValue-value*amount) < 0) {
    //                 throw new RuntimeException("There are not enough ingredients to make the dishes.");
    //             }
    //         }
    //         keys = ingredients.keys();
    //         while (keys.hasMoreElements()) {
    //             String key = keys.nextElement();
    //             int value = ingredients.get(key);
    //             int stockValue = stock.get(key);
    //             stock.put(key, (stockValue-value*amount));
    //         }
    //     }
    // }

    // public void addstock(String ingredient, int amount) {
    //     stock.put(ingredient, (stock.get(ingredient)+amount));
    // }

    public void printMenu() {
        System.out.println(menu.toString());
    }

    // public void printStock() {
    //     System.out.println(stock.toString());
    // }


}

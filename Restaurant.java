import java.util.Hashtable;
import java.util.Enumeration;

public class Restaurant extends Building{

    // Attributes
    private Hashtable<String, Dish> menu;
    private Hashtable<String, Integer> stock;


    // Constructor
    //Comment from Victoria: super constructor not working, not sure what's wrong :(
    public Restaurant(String name, String address, int nFloors, int locationX, int locationY, boolean elevator, Hashtable<String, Dish> menu, Hashtable<String, Integer> stock) {
        super(name, address, nFloors, locationX, locationY, elevator);
        this.menu = menu;
        this.stock = stock;
    }


    // Methods
    public void sell(String dishName, int amount) {
        if (menu.containsKey(dishName)) {
            Dish dish = menu.get(dishName);
            Hashtable<String, Integer> ingredients = dish.getIngredients();
            Enumeration<String> keys = ingredients.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                int value = ingredients.get(key);
                int stockValue = stock.get(key);
                if ((stockValue-value*amount) < 0) {
                    throw new RuntimeException("There are not enough ingredients to make the dishes.");
                }
            }
            keys = ingredients.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                int value = ingredients.get(key);
                int stockValue = stock.get(key);
                stock.put(key, (stockValue-value*amount));
            }
        }
    }

    public void addstock(String ingredient, int amount) {
        stock.put(ingredient, (stock.get(ingredient)+amount));
    }

    public void printMenu() {
        System.out.println(menu.toString());
    }

    public void printStock() {
        System.out.println(stock.toString());
    }
}


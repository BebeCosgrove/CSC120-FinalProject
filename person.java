import java.util.ArrayList;

public class Person {
    private int money;
    private ArrayList<Object> inventory;
    private int x; // x for coordinate
    private int y; // y for coordinate


    /**
     * Constructor for person class 
     * @param x x coordinate of person's location
     * @param y y coordinate of person's location
     */
    public Person(int money, int x, int y){
        this.money = money;
        this.x = x;
        this.y = y;
        this.inventory= new ArrayList<Object>();
    }

    /**
     * Allows user to grab object that costs no money and adds the object to their inventory if it is not already in inventory
     * @param object object to be grabbed
     * @return object grabbed 
     */
    public Object grab(Object object){
        if (inventory.contains(object)){
            throw new RuntimeException("You already have this object and cannot grab it.");
        } else{
            if (object.getPrice() == 0){
                inventory.add(object);
                System.out.println("You have grabbed" + object.getName());
                return object;
            } else {
                throw new RuntimeException("This object costs money so you need to buy it.");
            }
        }

        
    }

    /**
     * Allows user to buy an object that costs money and adds it to their inventory
     * @param object 
     * @param price
     * @return the amount of money user has after buying object
     */
    public int buy(Object object){
        if (inventory.contains(object)){
            throw new RuntimeException("You already have this object and cannot buy it.");
        } else{
            if (object.getPrice() != 0){
                inventory.add(object);
                System.out.println("You have bought " + object.getName());
                this.money = this.money - object.getPrice();
                System.out.println("You now have $" + this.money + " left after purchasing " + object.getName());
                return this.money;
            } else {
                throw new RuntimeException("This object is free and you can just grab it.");
            }
        }
    }

    /**
     * Allows user to drop an object as long as it is in their inventory
     * @param object object to be dropped
     * @return object
     */
    public Object drop(Object object){
        if (inventory.contains(object)){
            inventory.remove(object);
            return object;
        } else{
            throw new RuntimeException("You do not have object in your inventory.");
        }
    }

    public static void main(String[] args) {
        Person Bebe = new Person(50, 0, 0);
        Object gum = new Object("gum", 3);
        Bebe.buy(gum);
        Bebe.grab(gum);
    }
    
}

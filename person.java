import java.util.ArrayList;

public class person {
    private String name;
    private int money;
    private ArrayList<String> inventory;
    private int x; // x for coordinate
    private int y; // y for coordinate


    /**
     * Constructor for person class
     * @param name name of person 
     * @param x x coordinate of person's location
     * @param y y coordinate of person's location
     */
    public person(String name, int money, int x, int y){
        this.name = name;
        this.money = money;
        this.x = x;
        this.y = y;
        this.inventory= new ArrayList<>();
    }

    /**
     * Allows person to grab object and adds the object to their inventory if it is not already in inventory
     * @param object object to be grabbed
     * @return object
     */
    public String grab(String object){
        if (inventory.contains(object)){
            throw new RuntimeException("You already have this object and cannot grab it");
        } else{
            inventory.add(object);
            return object;
        }

        
    }
    /**
     * Allows person to drop an object as long as it is in their inventory
     * @param object object to be dropped
     * @return object
     */
    public String drop(String object){
        if (inventory.contains(object)){
            inventory.remove(object);
            return object;
        } else{
            throw new RuntimeException("You do not have object in your inventory");
        }
    }
    
}

import java.util.Hashtable;
import java.util.ArrayList;

public class Store extends Building{

    // Attributes
    // private Hashtable<String, Goods> inventory;
    private ArrayList<Object> goodsInventory;
    // i think we need just an arraylist of the objects because they have a name already and a hashtable just complicates it 

    
    // Constructor
    public Store(String name, String address, int nFloors, int locationX, int locationY, boolean elevator) {
        super(name, address, nFloors, locationX, locationY, elevator);
        // this.inventory = new Hashtable<String, Goods> ();
        this.goodsInventory = new ArrayList<Object>();
    }


    // Accessors

    /**
     * Getter for goods inventory
     * @return inventory of items store has
     */
    public ArrayList<Object> getInventory(){
        return this.goodsInventory;

    }


    // Methods

    /**
     * Adds items to store's inventory
     * @param goods
     */
    public Object addGoods(Object object) {
        if (goodsInventory.contains(object)){
            throw new RuntimeException("Store already has this object and cannot add it.");
        } else{
            goodsInventory.add(object);
            return object;
        }
    
    }

    // run this in while loop if user puts buy "object" and we can check if the store has this object
    /**
     * Removes items from store's inventory when they are sold
     * @param object
     * @return
     */
    public Object sellGoods(Object object) {
        if (goodsInventory.contains(object)){
            goodsInventory.remove(object);
            return object;
        } else{
            throw new RuntimeException("Store does not have this item and cannot sell it.");
        }
    }

    



    

    
}

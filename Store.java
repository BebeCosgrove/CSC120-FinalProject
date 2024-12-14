import java.util.ArrayList;
/**
 * Store Class
 */
public class Store extends Building {

  // Attributes
  private ArrayList < Object > goodsInventory;

  /**
   * Constructor
   * @param name name of store
   * @param address address of store
   */
  public Store(String name, String address) {
    super(name, address);

    this.goodsInventory = new ArrayList < Object > ();
  }

  // Accessors

  /**
   * Getter for goods inventory
   * @return inventory of items store has
   */
  public ArrayList < Object > getInventory() {
    return this.goodsInventory;

  }

  // Methods

  /**
   * Adds items to store's inventory
   * @param object object to be added 
   * @return 
   */
  public Object addGoods(Object object) {
    if (goodsInventory.contains(object)) {
      throw new RuntimeException("Store already has this object and cannot add it.");
    } else {
      goodsInventory.add(object);
      return object;
    }

  }

  /**
   * Removes items from store's inventory when they are sold
   * @param object object to be sold
   * @return object that is sold
   */
  public Object sellGoods(Object object) {
    if (goodsInventory.contains(object)) {
      goodsInventory.remove(object);
      return object;
    } else {
      throw new RuntimeException("Store does not have this item and cannot sell it.");
    }
  }

}
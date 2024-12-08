import java.util.Hashtable;

public class Store extends Building{

    // Attributes
    private Hashtable<String, Goods> inventory;

    
    // Constructor
    public Store(String name, String address, int nFloors, int locationX, int locationY, boolean elevator) {
        super(name, address, nFloors, locationX, locationY, elevator);
        this.inventory = new Hashtable<String, Goods> ();
    }


    // Accessors
    public Goods getGoods(String goodsName) {
        return this.inventory.get(goodsName);
    }


    // Methods
    public void addGoods(Goods goods) {
        String goodsName = goods.getName();
        if (inventory.containsKey(goodsName)) {
            inventory.get(goodsName).addAmount(goods.getAmount());
        } else {
            inventory.put(goodsName, goods);
        }
    }

    public void sellGoods(String goodsName, int amount) {
        if (inventory.containsKey(goodsName)) {
            try {
                inventory.get(goodsName).removeAmount(amount);
                System.out.println("There are " + inventory.get(goodsName).getAmount() + " " + goodsName + " left in the store.");
            } catch (RuntimeException e) {
                System.out.println(e);;
            }
        } else {
            System.out.println("There's no such item sold in this store.");
        }
    }
}


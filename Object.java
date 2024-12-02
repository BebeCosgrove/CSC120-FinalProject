public class Object {
    private String name; // name of object
    private int price; // price of object 
    
    /**
     * Overloaded Constructor that only takes name as input
     * @param name name of object
     */
    public Object(String name){
        this.name = name;
        this.price = 0; // sets object price to 0 if not inputted
    }

    /**
     * Full Constructor
     * @param name name of object
     * @param price price of object
     */
    public Object(String name, int price){
        this.name = name;
        this.price = price;
    }
    /**
     * Getter for name of object
     * @return returns name of object
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for price of object
     * @return price of object
     */
    public int getPrice(){
        return this.price;
    }


}

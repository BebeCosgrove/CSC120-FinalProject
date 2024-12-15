/**
 * Building class
 */
public class Building {
  /* Attributes */
  protected String name;
  protected String address;
  protected int nFloors;
  protected int activeFloor = -1; // Default value indicating we are not inside this building
  protected boolean elevator;
  protected Object object;

  /**
   * Overloaded constructor for map game class
   * @param name name of building
   * @param address address of building
   */
  public Building(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /* Constructor */
  /**
   * Constructor
   * @param name name of building
   * @param address address of building
   * @param nFloors number of floors
   * @param elevator whether or not there is an elevator
   */
  public Building(String name, String address, int nFloors, boolean elevator) {
    if (name != null) {
      this.name = name;
    }
    if (address != null) {
      this.address = address;
    }
    if (nFloors < 1) {
      throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
    }
    this.nFloors = nFloors;
    this.elevator = elevator;
  }

  /* Accessors */

  /**
   * Getter for name
   * @return name 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Getter for address
   * @return address 
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Getter for number of floors
   * @return number of floors 
   */
  public int getFloors() {
    return this.nFloors;
  }

  /**
   * Getter for whether or not there is an elevator
   * @return whether or not there is an elevator
   */
  public boolean getElevator() {
    return this.elevator;
  }

  /* Navigation methods */
  /**
   * Lets user enter building
   * @return building user is in
   */
  public Building enter() {
    if (activeFloor != -1) {
      throw new RuntimeException("You are already inside this Building.");
    }
    this.activeFloor = 1;
    System.out.println("You are now inside " + this.name + " on the ground floor.");
    return this; // Return a pointer to the current building
  }

  /**
   * Lets user exit building
   * @return building user exited
   */
  public Building exit() {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
    }
    if (this.activeFloor > 1) {
      throw new RuntimeException("You have fallen out a window from floor #" + this.activeFloor + "!");
    }
    System.out.println("You have left " + this.name + ".");
    this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
    return null; // We're outside now, so the building is null
  }

  /**
   * Lets user go to floor
   * @param floorNum floor number
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /**
   * Lets user go up
   */
  public void goUp() {
    this.goToFloor(this.activeFloor + 1);
  }

  /**
   * Lets user go down
   */
  public void goDown() {
    this.goToFloor(this.activeFloor - 1);
  }

  /**
   * Prints options at that building
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
  }

  /**
   * Returns the string of name
   * @return name
   */
  public String toString() {
    return this.name;
  }

  /**
   * Main Method
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("------------------------------------");
    System.out.println("Test of Building constructor/methods");
    System.out.println("------------------------------------");

    Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 20, true);
    System.out.println(fordHall);
    fordHall.showOptions();

    System.out.println("-----------------------------------");
    System.out.println("Demonstrating enter/exit/navigation");
    System.out.println("-----------------------------------");
    fordHall.enter();
    fordHall.goUp();
    fordHall.goDown();
    fordHall.exit();
  }

}
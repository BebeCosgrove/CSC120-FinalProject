import java.util.ArrayList;
import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{
 
  // Attributes
  private Hashtable<String, Boolean> collection;


  // Constructor
  public Library(String name, String address, int nFloors, int locationX, int locationY, boolean elevator) {
    super(name, address, nFloors, locationX, locationY, elevator);
    collection = new Hashtable<String, Boolean> ();
  }
  

  // Methods
  /**
   * This an overloaded method(addTittle) to add one book to the collection each time we call it.
   * @param title the title of the book we want to add
   */
  public void addTitle(String title) {
    collection.put(title, true);
  }


  /**
   * This an overloaded method(addTittle) to add a list of books to the collection each time we call it.
   * @param titles the lists of books we want to add
   */
  public void addTitle(ArrayList<String> titles) {
    for (int i = 0; i < titles.size(); i++){
      collection.put(titles.get(i), true);
    }
  }


  /**
   * This method removes books from the collection
   * @param title the title of the book we want to remove
   * @return string, the title that we removed
   */
  public String removeTitle(String title) {
    collection.remove(title);
    return title;
  }

  /**
   * This method modify the value associated with the given key (he title) to false when a book is checked out.
   * @param title the book that is checked out
   */
  public void checkOut(String title) {
    collection.replace(title, false);
  }

  /**
   * This method modify the value associated with the given key (he title) to true when a book is returned.
   * @param title the book that is returned
   */
  public void returnBook(String title) {
    collection.replace(title, true);
  }

  /**
   * This method checks whether a book is in the collection.
   * @param title the book we want to check
   * @return boolean, true if the title appears as a key in the Libary's collection, false otherwise
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * This method checks whether a book is available.
   * @param title the book we want to check
   * @return boolean, true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title) {
    return collection.get(title);
  }

  /**
   * This method prints out the entire collection in an easy-to-read way (including checkout status).
   */
  public void printCollection() {
    System.out.println(collection.toString());
  }


  /**
   * This method overrides the showOptions() method in the parent class(Building) to reflect the subclass-specific options for Library class.
   */
  @Override
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()");
  }

  /**
   * This method overrides the goToFloor() method in the parent class(Building) to allow movement between non-adjacent floors.
   */
  @Override
  public void goToFloor(int n) {
    super.goToFloor(n);
  }





  public static void main(String[] args) {
    Library library = new Library("Neilson", "7 Neilson Drive", 4);
    System.out.println(library.getAddress());
    library.addTitle("Beginning Korean I by Suk Massey");
    library.addTitle("Intermediate Korean I by Suk Massey");
    library.addTitle("STAT 2 by Ann R. Cannon");
    library.printCollection();
    System.out.println(library.removeTitle("STAT 2 by Ann R. Cannon"));
    library.printCollection();
    library.checkOut("Beginning Korean I by Suk Massey");
    library.printCollection();
    System.out.println(library.isAvailable("Beginning Korean I by Suk Massey"));
    library.returnBook("Beginning Korean I by Suk Massey");
    library.printCollection();
    System.out.println(library.containsTitle("STAT 2 by Ann R. Cannon"));
    Building building = library;
    building.showOptions();
  }
  
}
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Library Class
 */
public class Library extends Building{
 
  // Attributes
  private Hashtable<Object, Boolean> collection;


  /**
   * Constructor
   * @param name name of library
   * @param address address of library
   */
  public Library(String name, String address) {
    super(name, address);
    collection = new Hashtable<Object, Boolean> ();
  }
  

  // Methods
  /**
   * This an overloaded method(addTittle) to add one book to the collection each time we call it.
   * @param title the title of the book we want to add
   */
  public void addTitle(Object title) {
    collection.put(title, true);
  }


  /**
   * This an overloaded method(addTittle) to add a list of books to the collection each time we call it.
   * @param titles the lists of books we want to add
   */
  public void addTitle(ArrayList<Object> titles) {
    for (int i = 0; i < titles.size(); i++){
      collection.put(titles.get(i), true);
    }
  }


  /**
   * This method removes books from the collection
   * @param title the title of the book we want to remove
   * @return string, the title that we removed
   */
  public Object removeTitle(Object title) {
    collection.remove(title);
    return title;
  }

  /**
   * This method modify the value associated with the given key (he title) to false when a book is checked out.
   * @param title the book that is checked out
   */
  public void checkOut(Object title) {
    collection.replace(title, false);
    System.out.println("Borrrowed "+ title.getName() );
  }

  /**
   * This method modify the value associated with the given key (he title) to true when a book is returned.
   * @param title the book that is returned
   */
  public void returnBook(Object title) {
    collection.replace(title, true);
  }

  /**
   * This method checks whether a book is in the collection.
   * @param title the book we want to check
   * @return boolean, true if the title appears as a key in the Libary's collection, false otherwise
   */
  public boolean containsTitle(Object title) {
    return collection.containsKey(title);
  }

  /**
   * This method checks whether a book is available.
   * @param title the book we want to check
   * @return boolean, true if the title is currently available, false otherwise
   */
  public boolean isAvailable(Object title) {
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
   * @param n floor number
   */
  @Override
  public void goToFloor(int n) {
    super.goToFloor(n);
  }



  
  
}
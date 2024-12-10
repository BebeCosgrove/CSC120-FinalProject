import java.util.ArrayList;
import java.util.Collections;
/**
 * BingoCard class creates a random bingo card for a user
 */
public class BingoCard {
  ArrayList < Task > tasks;
  private Person owner;
  private boolean bingo;
  private MapGame map;
  Task task1 = new Task("Borrow 'Macbeth' from Forbes Library");
  Task task2 = new Task("Buy Uggs at Synergy                 ");
  Task task3 = new Task("Buy a coffee at Woodstar            ");
  Task task4 = new Task("Buy a top at Urban Outfitters       ");
  Task task5 = new Task("Buy a loaf of bread at Hungry Ghost ");
  Task task6 = new Task("Find a ticket at Academy of Music   ");
  Task task7 = new Task("Get a plant from Botanic Garden     ");
  Task task8 = new Task("Get a postcard from the SCAM        ");
  Task task9 = new Task("Buy Dumplings from T.ROOTS          ");


  /**
   * Constructor for BingoCard class
   * @param owner Person, the owner of the bingo card
   */
  public BingoCard(Person owner) {
    this.owner = owner;
    tasks = new ArrayList < > ();
    map = new MapGame();
    //format the tasks so that the strings are all the same length
    //add tasks to arraylist
    tasks.add(task1);
    tasks.add(task2);
    tasks.add(task3);
    tasks.add(task4);
    tasks.add(task5);
    tasks.add(task6);
    tasks.add(task7);
    tasks.add(task8);
    tasks.add(task9);
    //shuffle the arraylist of tasks
    Collections.shuffle(tasks);
    bingo = false;
    System.out.println("You have made a bingo card!");

  }
  /**
   * Prints the bingo card in a 3x3 grid with a check or an x next to each task description indicating the completion status
   */
  public void printBingoCard() {
    System.out.println("       -----------BINGO CARD-----------");
    System.out.println(tasks.get(0).getDescription() + "   " + tasks.get(0).printStatus() + "   |   " + tasks.get(1).getDescription() + "   " + tasks.get(1).printStatus() + "   |   " + tasks.get(2).getDescription() + "   " + tasks.get(2).printStatus());
    System.out.println(tasks.get(3).getDescription() + "   " + tasks.get(3).printStatus() + "   |   " + tasks.get(4).getDescription() + "   " + tasks.get(4).printStatus() + "   |   " + tasks.get(5).getDescription() + "   " + tasks.get(5).printStatus());
    System.out.println(tasks.get(6).getDescription() + "   " + tasks.get(6).printStatus() + "   |   " + tasks.get(7).getDescription() + "   " + tasks.get(7).printStatus() + "   |   " + tasks.get(8).getDescription() + "   " + tasks.get(8).printStatus());
  }

  /**
   * Prints the descriptions of each task in the arraylist of tasks
   */
  public void printTasks() {
    for (int i = 0; i < 9; i++) {
      System.out.println(tasks.get(i).getDescription());
    }
  }
  /**
   * Checks if the person has socred a bingo based on whether or not they have completed tasks that make three in a row for their bingo card
   * @return boolean bingo, true if the owner of the card has scored a bingo and false if not
   */
  public boolean checkBingo() {
    // if (owner.getInventory().contains(map.macbeth)) {
    //   this.task1.setCompletedTrue();
    // }
    // if (owner.getInventory().contains(map.uggs)) {
    //   this.task2.setCompletedTrue();
    // }
    // if (owner.getInventory().contains(map.coffee)) {
    //   this.task3.setCompletedTrue();
    // }
    // if (owner.getInventory().contains("object")) {
    //   this.task4.setCompletedTrue();
    // }
    // if (owner.getInventory().contains("object")) {
    //   this.task5.setCompletedTrue();
    // }
    // if (owner.getInventory().contains("object")) {
    //   this.task6.setCompletedTrue();
    // }

    // if (owner.getInventory().contains("object")) {
    //   this.task7.setCompletedTrue();
    // }
    // if (owner.getInventory().contains("object")) {
    //   this.task8.setCompletedTrue();
    // }
    // if (owner.getInventory().contains("object")) {
    //   this.task9.setCompletedTrue();
    // }

    //now check all possible bingo wins
    //first row
    if (tasks.get(0).getCompletionStatus() == true && tasks.get(1).getCompletionStatus() == true && tasks.get(2).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking first row... " + this.bingo);
      //second row
    } else if (tasks.get(3).getCompletionStatus() == true && tasks.get(4).getCompletionStatus() == true && tasks.get(5).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking second row... " + this.bingo);
      //third row
    } else if (tasks.get(6).getCompletionStatus() == true && tasks.get(7).getCompletionStatus() == true && tasks.get(8).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking third row... " + this.bingo);
      //first column
    } else if (tasks.get(0).getCompletionStatus() == true && tasks.get(3).getCompletionStatus() == true && tasks.get(6).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking first column... " + this.bingo);
      //second column
    } else if (tasks.get(1).getCompletionStatus() == true && tasks.get(4).getCompletionStatus() == true && tasks.get(7).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking second column... " + this.bingo);
      //third column
    } else if (tasks.get(2).getCompletionStatus() == true && tasks.get(5).getCompletionStatus() == true && tasks.get(8).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking third column... " + this.bingo);
      //diagonal from left to right
    } else if (tasks.get(0).getCompletionStatus() == true && tasks.get(4).getCompletionStatus() == true && tasks.get(8).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking first diagonal... " + this.bingo);
      //diagonal from right to left
    } else if (tasks.get(2).getCompletionStatus() == true && tasks.get(4).getCompletionStatus() == true && tasks.get(6).getCompletionStatus() == true) {
      this.bingo = true;
      System.out.println("Checking second diagonal... " + this.bingo);
      //else no bingo
    } else {
      this.bingo = false;
    }
    if(this.bingo){
      System.out.println("BINGO! You win!");
      //end game
    } //else{
      // System.out.println("No bingo yet, keep trying.");
    
    return this.bingo;
  }


  public static void main(String args[]) {
    Person victoria = new Person(20);
    BingoCard myCard = new BingoCard(victoria);
    myCard.task1.setCompletedTrue();
    myCard.task2.setCompletedTrue();
    myCard.task3.setCompletedTrue();
    myCard.task4.setCompletedTrue();
    myCard.task5.setCompletedTrue();
    myCard.printTasks();
    myCard.printBingoCard();
    System.out.println(myCard.checkBingo());
  }

}


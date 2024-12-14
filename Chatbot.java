import java.util.Scanner;
import java.util.ArrayList;

/**
 * stub for chatbot class
 */
public class Chatbot {
  //attributes
  String responseString;
  Scanner userResponseScanner;
  int numWordsReplaced;
  String userInputString;
  ArrayList < String > wordArrayList;
  String[] wordArray;
  Person chatter;
  MapGame map;
  BingoCard card;

  /**
   * Constructor for chatbot class
   * @param chatter person to whom the chatbot belongs
   * @param map map to which the chatbot belongs
   * @param card bingo card that belongs to the chatbot's owner
   */
  public Chatbot(Person chatter, MapGame map, BingoCard card) {
    this.responseString = "";
    userResponseScanner = new Scanner(System.in);
    numWordsReplaced = 0;
    this.chatter = chatter;
    this.map = map;
    this.card = card;
    wordArrayList = new ArrayList < > ();
  }

  /**
   * Method to print a greeting to welcome the character when they spawn on the map
   */
  public void printGreeting() {
    System.out.println("Welcome to Northampton!");
    System.out.println("You are currently at the PVTA bus stop outside of JMG at Smith College. There is a bus driver in front of you holding a letter, and town lies to the north of you.");
    System.out.println("Here is your bingo card... you must buy items to get you bingo on your card, with a limited amount of money...");
    System.out.println("Enter a command to make your next move. May the odds be ever in your favor...");
  }

  /**
   * Method to get the user's input
   * @return the user's input as a string
   */
  public String getInput() {
    return this.userInputString = userResponseScanner.nextLine();
  }

  /**
   * Method to make a response based on what the user input. Evaluates a series of if statements to decide what to do, and calls methods based on recognized words.
   * @return a response to what the person entered
   */
  public String makeResponse() {
    wordArray = this.userInputString.split(" ");
    for (String a: wordArray) {
      //remove spaces and line returns and turn it all into lowercase
      a.trim();
      a.toLowerCase();
      wordArrayList.add(a);
    }
    //evaluate if the word in the array matches one of the hit words
    if (wordArrayList.contains("walk") && wordArrayList.contains("north")) { //check for walk north
      map.move("North");
      this.responseString = "Done!";
    } else if (wordArrayList.contains("walk") && wordArrayList.contains("south")) { //check for north
      //walk method with south direction
      this.map.move("South");
      this.responseString = "Done!";
    } else if (wordArrayList.contains("walk") && wordArrayList.contains("east")) { //check for east
      //walk method with east direction
      this.map.move("East");
      this.responseString = "Done!";
    } else if (wordArrayList.contains("walk") && wordArrayList.contains("west")) { //check for west
      //walk method with west direction
      this.map.move("West");
      this.responseString = "Done!";
    } else if (wordArrayList.contains("walk")) { //check for just walk with no direction
      this.responseString = "What direction would you like to walk in? Please enter 'walk' and the direction.";

    } else if (wordArrayList.contains("grab") && wordArrayList.contains("uggs")) { //check grab on obj 1
      //call grab on uggs if at appropriate location
      if (map.getCurrentLocation() == map.synergy) {
        chatter.grab(map.uggs);
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at synergy";
      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("coffee")) { //call grab on the appropriate object
      //call grab on coffee
      if (map.getCurrentLocation() == map.woodstar) {
        chatter.grab(map.coffee);
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at woodstar";
      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("top")) { //call grab on the appropriate object
      //call grab on top
      if (map.getCurrentLocation() == map.uo) {
        chatter.grab(map.top);
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Urban Outfitters";
      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("loaf") || wordArrayList.contains("grab") && wordArrayList.contains("bread")) { //call grab on the appropriate object
      //call grab on loaf
      if (map.getCurrentLocation() == map.bread) {
        chatter.grab(map.loaf);
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Hungry Ghost Bread";

      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("ticket")) { //call grab on the appropriate object
      //call grab on obj 5
      if (map.getCurrentLocation() == map.music) {
        chatter.grab(map.ticket);
        card.task6.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Academy of Music";
      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("plant")) { //call grab on the appropriate object
      //call grab on obj 6
      if (map.getCurrentLocation() == map.garden) {
        chatter.grab(map.plant);
        card.task7.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Botanic Garden";
      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("postcard")) { //call grab on the appropriate object
      // call grab on postcard
      if (map.getCurrentLocation() == map.scam) {
        chatter.grab(map.postcard);
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at SCAM";

      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("dumplings")) { //call grab on the appropriate object
      //call grab on dumplings
      if (map.getCurrentLocation() == map.troots) {
        chatter.grab(map.dumplings);
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at T.ROOTS";

      }
    } else if (wordArrayList.contains("grab") && wordArrayList.contains("macbeth")) { //call grab on the appropriate object
      //call grab on macbeth
      if (map.getCurrentLocation() == map.forbes) {
        this.responseString = "You need to borrow it not grab it";
      } else {
        this.responseString = "You aren't at Forbes";

      }
    } else if (wordArrayList.contains("grab")) { //check for grab without a specified object
      this.responseString = "What object would you like to grab?";

      //buy branch
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("uggs")) { //check for buy uggs
      //call buy on uggs
      if (map.getCurrentLocation() == map.synergy) {
        map.synergy.sellGoods(map.uggs);
        chatter.buy(map.uggs);
        card.task2.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at synnergy";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("coffee")) { //call buy on the appropriate object
      //call buy on coffee
      if (map.getCurrentLocation() == map.woodstar) {
        map.woodstar.sellGoods(map.coffee);
        chatter.buy(map.coffee);
        card.task3.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at woodstar";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("top")) { //call buy on the appropriate object
      //call buy on top
      if (map.getCurrentLocation() == map.uo) {
        map.uo.sellGoods(map.top);
        chatter.buy(map.top);
        card.task4.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Urban Outfitters";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("loaf") || wordArrayList.contains("buy") && wordArrayList.contains("bread")) { //call buy on the appropriate object
      //call buy on loaf
      if (map.getCurrentLocation() == map.bread) {
        map.bread.sellGoods(map.loaf);
        chatter.buy(map.loaf);
        card.task5.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Urban Outfitters";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("ticket")) { //call buy on the appropriate object
      //call buy on ticket
      if (map.getCurrentLocation() == map.music) {
        map.bread.sellGoods(map.ticket);
        chatter.buy(map.ticket);
        card.task5.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at the Academy of Music";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("plant")) { //call buy on the appropriate object
      //call buy on plant
      if (map.getCurrentLocation() == map.garden) {
        map.bread.sellGoods(map.plant);
        chatter.buy(map.plant);
        card.task5.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at the Botanic Garden";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("macbeth")) { //call buy on the appropriate object
      //call buy on macbeth
      if (map.getCurrentLocation() == map.forbes) {
        map.bread.sellGoods(map.macbeth);
        chatter.buy(map.macbeth);
        card.task5.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Forbes";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("postcard")) { //call buy on the appropriate object
      //call buy on postcard
      if (map.getCurrentLocation() == map.scam) {
        map.scam.sellGoods(map.postcard);
        chatter.buy(map.postcard);
        card.task8.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at Smith College Art Museum";
      }
    } else if (wordArrayList.contains("buy") && wordArrayList.contains("dumplings")) { //call buy on the appropriate object
      //call buy on dumplings
      if (map.getCurrentLocation() == map.troots) {
        map.troots.sellGoods(map.dumplings);
        chatter.buy(map.dumplings);
        card.task9.setCompletedTrue();
        this.responseString = "...";
      } else {
        this.responseString = "You aren't at T. Roots";
      }
    } else if (wordArrayList.contains("buy")) { //check for buy without a specified object
      this.responseString = "What would you like to buy?";

      //check bingo branch
    } else if (wordArrayList.contains("check") && wordArrayList.contains("bingo")) { //check to see if they want to check their bingo
      this.card.checkBingo();
      this.card.printBingoCard();
      this.responseString = "Done!";

      //borrow/return book branch
    } else if (wordArrayList.contains("borrow") && wordArrayList.contains("macbeth")) { //check to see if they want to borrow a library book
      if (map.getCurrentLocation() == map.forbes) {
        this.map.forbes.checkOut(map.macbeth);
        this.chatter.getInventory().add(map.macbeth);
        card.task1.setCompletedTrue();
        this.responseString = "Done!";
      } else {
        this.responseString = "You aren't at the library!";
      }

    } else if (wordArrayList.contains("borrow")) {
      this.responseString = "What title would you like to borrow? Please enter 'borrow' followed by the title.";
    } else if (wordArrayList.contains("return") && wordArrayList.contains("macbeth")) { //check to see if they want to return a library book
      //call return on the title
      if (map.getCurrentLocation() == map.forbes) {
        this.map.forbes.returnBook(map.macbeth);
        this.responseString = "Done!";
      } else {
        this.responseString = "You aren't at the library!";
      }
      this.responseString = "Done!";

    } else if (wordArrayList.contains("return")) {
      this.responseString = "What title would you like to return?";

      //help branch
    } else if (wordArrayList.contains("help")) {
      this.responseString = "Commands\n- walk (direction)\n" + //
        "- buy (object)\n" + //
        "- grab (object)\n" + //
        "- check bingo\n" + //
        "- borrow (book title)\n" + //
        "- return (book title)\n- end game";

      //end game branch
    } else if (wordArrayList.contains("end") && wordArrayList.contains("game")) {
      card.setBingoTrue();
      this.responseString = "goodbye!";
    } else {
      this.responseString = "I don't know that word";
    }
    wordArrayList.clear();

    return this.responseString;

  }

  /**
   * Main Method
   * @param arguments
   */
  public static void main(String[] arguments) {
    boolean play = true;
    Person victoria = new Person(0);
    BingoCard myCard = new BingoCard(victoria);
    MapGame map = new MapGame();
    Chatbot chatbot = new Chatbot(victoria, map, myCard);
    chatbot.printGreeting();
    //map.move("North");
    while (play) {
      chatbot.getInput();
      System.out.println(chatbot.makeResponse());
    }

  }
}
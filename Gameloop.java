/**
 * Gameloop
 */
public class Gameloop {
    private Person player;
    private MapGame map;
    static BingoCard bingo;
    private Chatbot chat;
  
    /**
     * Constructor
     */
    public Gameloop() {
      this.player = new Person(200); // initialize player with $200
      this.map = new MapGame(); // initializes new map
      this.bingo = new BingoCard(player); // initializes new bingo card for player
      this.chat = new Chatbot(player, map, bingo); // initializes new chatbot
    }
  
    /**
     * Main Method
     * @param args
     */
    public static void main(String args[]) {
      Gameloop loop = new Gameloop();
      loop.chat.printGreeting();
      bingo.printBingoCard();
      while (bingo.checkBingo() == false) {
        loop.chat.getInput();
        System.out.println(loop.chat.makeResponse());
      }
      System.out.println("You have won the game!");
    }
  }
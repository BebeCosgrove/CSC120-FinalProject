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
    String [] wordArray;
    Person chatter;
    MapGame map;
    BingoCard card;

    /**
     * Constructor for chatbot class
     * @param chatter person to whom the chatbot belongs
     * @param map map to which the chatbot belongs
     * @param card bingo card that belongs to the chatbot's owner
     */
    public Chatbot(Person chatter, MapGame map, BingoCard card){
        this.responseString = "";
        userResponseScanner = new Scanner(System.in);
        numWordsReplaced = 0;
        this.chatter = chatter;
        this.map = map;
        this.card = card;
        wordArrayList = new ArrayList<>();
    }

    /**
     * Method to print a greeting to welcome the character when they spawn on the map
     */
    public void printGreeting(){
        System.out.println("Welcome to Northampton!");
        System.out.println("You are currently at the PVTA bus stop outside of JMG at Smith College. There is a bus driver in front of you holding a letter, and town lies to the north of you.");
        System.out.println("Enter a command to make your next move. May the odds be ever in your favor...");
    }

    /**
     * Method to get the user's input
     * @return the user's input as a string
     */
    public String getInput(){
        return this.userInputString = userResponseScanner.nextLine();
    }


    /**
     * Method to make a response based on what the user input. Evaluates a series of if statements to decide what to do, and calls methods based on recognized words.
     * @return a response to what the person entered
     */

     //need to add branches for moving through buildings and restarting at the pvta stop
    public String makeResponse(){
        wordArray = this.userInputString.split(" ");
        for (String a : wordArray){
            //remove spaces and line returns and turn it all into lowercase
            a.trim();
            a.toLowerCase();
            wordArrayList.add(a);
        }
            //evaluate if the word in the array matches one of the hit words
            //if yes, then set the replacement word to match the correct response
            //indicate that a replacement has been made by upcounting words replaced variable
            if(wordArrayList.contains("walk")&&wordArrayList.contains("north")){   //check for walk north
              //call walk method with north direction
              this.responseString = "Walking north!";
            }else if(wordArrayList.contains("walk")&&wordArrayList.contains("south")){   //check for north
                //walk method with south direction
                this.responseString = "Done!";
            }else if(wordArrayList.contains("walk")&&wordArrayList.contains("east")){   //check for east
                //walk method with south direction
                this.responseString = "Done!";
            }else if(wordArrayList.contains("walk")&&wordArrayList.contains("west")){   //check for west
                //walk method with east direction
                this.responseString = "Done!";
            }else if(wordArrayList.contains("walk")){   //check for just walk with no direction
                this.responseString = "What direction would you like to walk in?";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 1")){   //check grab on obj 1
                //call grab on obj 1 if at appropriate location
                this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 2")){ //call grab on the appropriate object
              //call grab on obj 2
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 3")){ //call grab on the appropriate object
              //call grab on obj 3
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 4")){ //call grab on the appropriate object
              //call grab on obj 4
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 5")){ //call grab on the appropriate object
              //call grab on obj 5
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 6")){ //call grab on the appropriate object
              //call grab on obj 6
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 7")){ //call grab on the appropriate object
              //call grab on obj 7
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 8")){ //call grab on the appropriate object
              //call grab on obj 8
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")&&wordArrayList.contains("obj 9")){ //call grab on the appropriate object
              //call grab on obj 9
              this.responseString = "Done!";
            }else if(wordArrayList.contains("grab")){ //check for grab without a specified object
              this.responseString = "What object would you like to grab?";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 1")){ //check for buy
              //call buy on obj 1
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 2")){ //call buy on the appropriate object
              //call buy on obj 2
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 3")){ //call buy on the appropriate object
              //call buy on obj 3
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 4")){ //call buy on the appropriate object
              //call buy on obj 4
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 5")){ //call buy on the appropriate object
              //call buy on obj 5
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 6")){ //call buy on the appropriate object
              //call buy on obj 6
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 7")){ //call buy on the appropriate object
              //call buy on obj 7
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 8")){ //call buy on the appropriate object
              //call buy on obj 8
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")&&wordArrayList.contains("obj 9")){ //call buy on the appropriate object
              //call buy on obj 9
              this.responseString = "Done!";
            }else if(wordArrayList.contains("buy")){ //check for buy without a specified object
              this.responseString = "What would you like to buy?";
            }else if(wordArrayList.contains("look")&&wordArrayList.contains("around")){ //check to see if they want to look around
              //call get description from the map
              this.responseString = "Done!";
            }else if(wordArrayList.contains("check")&&wordArrayList.contains("bingo")){ //check to see if they want to check their bingo
              this.card.checkBingo();
              this.responseString = "Done!";
            }else if(wordArrayList.contains("borrow")&&wordArrayList.contains("book 1")){ //check to see if they want to borrow a library book
              //call borrow on the title
              this.responseString = "Done!";
            }else if(wordArrayList.contains("borrow")){
              this.responseString = "What title would you like to borrow?";
            }else if(wordArrayList.contains("return")&&wordArrayList.contains("book 1")){ //check to see if they want to return a library book
              //call return on the title
              this.responseString = "Done!";
            }else if(wordArrayList.contains("return")){
              this.responseString = "What title would you like to return?";
            }else if(wordArrayList.contains("end")&&wordArrayList.contains("game")){
              //end the game
            }else {
              this.responseString = "I don't know that word";
            }
            return this.responseString;
        }

    
    public static void main(String[] arguments) {
      boolean play = true;
      Person victoria = new Person(0,0,0);
      BingoCard myCard = new BingoCard(victoria);
      Chatbot chatbot = new Chatbot(victoria, null, myCard);
      chatbot.printGreeting();
      while(play){
        chatbot.getInput();
        System.out.println(chatbot.makeResponse());
      }
      
    }
  }


import java.util.Random;
import java.util.Scanner;

public class Chatbot {
    //attributes
    String replacementWord;
    String responseString;
    Scanner userResponseScanner;
    int numWordsReplaced;
    String userInputString;
    String[] wordArray;
    Person chatter;

    public Chatbot(Person chatter){
        this.replacementWord = "none";
        this.responseString = "";
        userResponseScanner = new Scanner(System.in);
        numWordsReplaced = 0;
        this.chatter = chatter;
    }

    public void printWelcomeMessage(){
        System.out.println("Welcome to Northampton!");
        System.out.println("You are currently at the PVTA bus stop outside of JMG at Smith College. There is a bus driver in front of you holding a letter, and town lies to the north of you.");
        System.out.println("Enter a command to make your next move. May the odds be ever in your favor...");
    }

    public String getInput(){
        return this.userInputString = userResponseScanner.nextLine();
    }

    public String makeResponse(){
        wordArray = this.userInputString.split(" ");
        for (String a : wordArray){
            //remove spaces and line returns
            a.trim();
            //evaluate if the word in the array matches one of the hit words
            //if yes, then set the replacement word to match the correct response
            //indicate that a replacement has been made by upcounting words replaced variable
            if(a.equalsIgnoreCase("walk")){   //check for walk
              //this.replacementWord = "you";
              //a = replacementWord;
              //numWordsReplaced++;
              this.responseString = "What direction?";
            }else if(a.equalsIgnoreCase("north")){   //check for north
                //walk method with north direction
            }else if(a.equalsIgnoreCase("south")){   //check for south
                //walk method with south direction
            }else if(a.equalsIgnoreCase("east")){   //check for east
                //walk method with east direction
            }else if(a.equalsIgnoreCase("west")){   //check for west
                //walk method with west direction
            }else if(a.equalsIgnoreCase("")){   //check something
                //do stuff here
            }else {
              this.replacementWord = "none";
            }
            
            //concatinate the replacement words into a new string
            responseString = responseString.concat(a + " ");
  
        }

    }
    public static void main(String[] arguments) {
    // declarations
    String replacementWord = "none";
    String responseString = "";
    int randNum = 0;
    Scanner scanny = new Scanner(System.in);
    Random randy = new Random();
    int transcriptIndex = 0;
    //array of random responses
    String[] randomResponses = new String[5];
    randomResponses[0] = "Cool!";
    randomResponses[1] = "Mhmmmmmmmm!";
    randomResponses[2] = "How thought provoking...!";
    randomResponses[3] = "No way";
    randomResponses[4] = "WOW!";

    //print greeting
    System.out.println("Hi there, welcome to the ChatBot. How many rounds?");
    
    //scan for number of rounds
    int numRounds = scanny.nextInt();
    scanny.nextLine();

    //make an array to store transcript
    String[] transcript = new String[(2*numRounds)+2];

    //Print greeting
    String greeting = "What's on your mind?";
    System.out.println(greeting);
    transcript[transcriptIndex] = greeting;
    transcriptIndex++;
    
    //Check for responses for the number of times they requested
    for (int i = 0; i < (numRounds); i++){
      
      //scan for responses
      int numWordsReplaced = 0;
      System.out.println("----------USER RESPONSE BELOW----------");
      String response = scanny.nextLine();
      transcript[transcriptIndex] = response;
      
      //split scan into an array with each word separated
      String[] wordArray = response.split(" ");
      
      //loop through each word in the array
      for (String a : wordArray){
          //remove spaces and line returns
          a.trim();
          
          //evaluate if the word in the array matches one of the hit words
          //if yes, then set the replacement word to match the correct response
          //indicate that a replacement has been made by upcounting words replaced variable
          if(a.equalsIgnoreCase("i")){   //replace "I" with "you"
            replacementWord = "you";
            a = replacementWord;
            numWordsReplaced++;
          }else if(a.equalsIgnoreCase("me")){   //replace "me" with "you"
          replacementWord = "you";
          a = replacementWord;
          numWordsReplaced++;
          }else if(a.equalsIgnoreCase("am")){   //replace "am" with "are"
          replacementWord = "are";
          a = replacementWord;
          numWordsReplaced++;
          }else if(a.equalsIgnoreCase("you")){   //replace "you" with "I"
          replacementWord = "I";
          a = replacementWord;
          numWordsReplaced++;
          }else if(a.equalsIgnoreCase("my")){   //replace "my" with "your"
          replacementWord = "your";
          a = replacementWord;
          numWordsReplaced++;
          }else if(a.equalsIgnoreCase("your")){   //replace "your" with "my"
          replacementWord = "my";
          a = replacementWord;
          numWordsReplaced++;
          }else {
            replacementWord = "none";
          }
          
          //concatinate the replacement words into a new string
          responseString = responseString.concat(a + " ");

      }

      //evaluate if a replacement has been made, and if so, add a question mark to turn the response into a question
      if(numWordsReplaced > 0){
        responseString = responseString.concat("?");
      } else {
        //make random number that corresponds to a response
        randNum = randy.nextInt(5);
        responseString = randomResponses[randNum];
        
      }

      System.out.println("----------CHATBOT RESPONSE BELOW---------");
      System.out.println(responseString);
      //store in an array here
      transcript[transcriptIndex+1] = responseString;
      responseString = "";
      transcriptIndex = transcriptIndex+2;

    }

    String bye = "Bye!";
    System.out.println(bye);
    transcript[transcriptIndex] = bye;
    System.out.println("Thanks for consulting the chatbot! The trascript of our conversation can be found below:");
  
     for(int i = 0; i < (2*numRounds)+2; i++){
      System.out.println(transcript[i]);
    }
  
    
  }
}

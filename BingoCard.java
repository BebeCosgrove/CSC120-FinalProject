import java.util.ArrayList;
import java.util.Collections;
public class BingoCard {
    ArrayList<String> tasks;
    ArrayList<String> shuffledTasks;
    private boolean winCondition1 = false;
    private boolean winCondition2 = false;
    private boolean winCondition3 = false;
    private boolean winCondition4 = false;
    private boolean winCondition5 = false;
    private boolean winCondition6 = false;
    private boolean winCondition7 = false;
    private boolean winCondition8 = false;
    private boolean winCondition9 = false;
    private Person owner;

    
    public BingoCard(){
        this.owner = owner;
        tasks = new ArrayList<>();
        //format the tasks so that the strings are all the same length
        tasks.add("task 1");
        tasks.add("task 2");
        tasks.add("task 3");
        tasks.add("task 4");
        tasks.add("task 5");
        tasks.add("task 6");
        tasks.add("task 7");
        tasks.add("task 8");
        tasks.add("task 9");
        shuffledTasks = new ArrayList<>();
        shuffledTasks.add("task 1");
        shuffledTasks.add("task 2");
        shuffledTasks.add("task 3");
        shuffledTasks.add("task 4");
        shuffledTasks.add("task 5");
        shuffledTasks.add("task 6");
        shuffledTasks.add("task 7");
        shuffledTasks.add("task 8");
        shuffledTasks.add("task 9");
        Collections.shuffle(shuffledTasks);
        System.out.println("You have made a bingo card!");

    }

    public void printBingoCard(){
        System.out.println("-----------BINGO CARD-----------");
        System.out.println(shuffledTasks.get(0)+"   |   "+shuffledTasks.get(1)+"   |   "+shuffledTasks.get(2));
        System.out.println(shuffledTasks.get(3)+"   |   "+shuffledTasks.get(4)+"   |   "+shuffledTasks.get(5));
        System.out.println(shuffledTasks.get(6)+"   |   "+shuffledTasks.get(7)+"   |   "+shuffledTasks.get(8));
    }

    public boolean checkBingo(){
        boolean bingo = false;
        if(owner.getInventory().contains("coffee")){
            winCondition1 = true;
            //how to map this to the shuffled array? go to office hours to see if there is an algorithm or soemthing to fix this
        }
        return bingo;
    }

    public static void main(String args[]){
        BingoCard myCard = new BingoCard();
        System.out.println(myCard.tasks);
        myCard.printBingoCard();
    }
    
}

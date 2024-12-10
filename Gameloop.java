public class Gameloop {
    private Person player;
    private MapGame map;
    static BingoCard bingo;
    private Chatbot chat;


    public Gameloop(){
        this.player = new Person(200);
        this.map = new MapGame();
        this.bingo = new BingoCard(player);
        this.chat = new Chatbot(player, map, bingo);
    }

    public static void main(String args[]){
        Gameloop loop = new Gameloop();
        loop.chat.printGreeting();
        bingo.printBingoCard();
        while(bingo.checkBingo() == false){
            loop.chat.getInput();
            System.out.println(loop.chat.makeResponse());
        }
        System.out.println("You have won the game!");
    }
}

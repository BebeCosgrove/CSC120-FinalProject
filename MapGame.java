import com.google.common.graph.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapGame{
   private HashMap<String, Map<String, Building>> directions;
   private MutableGraph<Building> mapGraph;
   private Building pvta;
   private Building currentLocation;
   public Store synergy;
   public Store woodstar;
   public Store bread;
   private Building thornes;
   public Building music;
   public Store uo;
   private Building mosaic;
   private Building policeStation;
   public Library forbes;
   private Building pulaski;
   private Building cityHall;
   private Building cedarChest;
   public Store troots;
   private Building bass;
   public Building garden;
   public Store scam;
   private Building smithGate;
   //objects
   Object macbeth;
   Object uggs;
   Object coffee;
   Object top;
   Object loaf;
   Object ticket;
   Object plant;
   Object postcard;
   Object dumplings;
   



    public MapGame(){
        pvta = new Building("PVTA Station", "Elm Street at Prospect Street");
        this.currentLocation = pvta;
        directions = new HashMap<>();
        mapGraph = GraphBuilder.undirected().build();
        synergy = new Store("Synergy", "2 Tyler Ct");
        woodstar = new Store("Woodstar Cafe", "46 College Ln");
        bread = new Store("hungry ghost bread", "44 College Ln");
        thornes = new Building("Thornes Marketplace", "150 Main St");
        music = new Building("Academy of Music", "274 Main St");
        uo = new Store("Urban Outfitters", "109 Main St");
        troots = new Store("T.ROOTS", "249 Main St");
        mosaic = new Building("Mosaic Cafe", "78 Masonic St");
        policeStation = new Building("Northampton Police Department", "29 Center St");
        forbes = new Library("Forbes Library", "20 West St");
        pulaski = new Building("Pulaski Park", "240 Main St");
        cityHall = new Building("Northampton City Hall", "210 Main St");
        cedarChest = new Building("Cedar Chest", "150 Main St");
        garden = new Building("The Botanic Garden of Smith College", "16 College Ln");
        bass = new Building("Bass Hall", "4 Tyler Ct");
        scam = new Store("Smith College Museum of Art", "20 Elm St");
        smithGate = new Building("Smith College Gate", "20 Elm St");
        this.addNodesEdges();
        this.directions();

        macbeth = new Object("macbeth");
        forbes.addTitle(macbeth);
        uggs = new Object("uggs", 150);
        synergy.addGoods(uggs);
        coffee = new Object("coffee",5);
        woodstar.addGoods(coffee);
        top = new Object("top", 10);
        uo.addGoods(top);
        loaf = new Object("hungry ghost bread",7);
        bread.addGoods(loaf);
        ticket = new Object("ticket");
        plant = new Object("plant");
        postcard = new Object("postcard", 5);
        scam.addGoods(postcard);
        dumplings = new Object("dumplings", 7);
        troots.addGoods(dumplings);


    }

    public Building getCurrentLocation(){
        return this.currentLocation;
    }

    public Building move(String direction){
        //while (true) {
            //System.out.println("\nWhere do you want to go? (North/South/East/West or Restart): ");
            //String input = scanner.nextLine().trim();
            if (direction.equalsIgnoreCase("Restart")) {
                currentLocation = pvta;
                System.out.println("Restarting... You are back at: " + currentLocation.name);
            } else {
                Map<String, Building> possibleMoves = directions.get(currentLocation.name);
                if (possibleMoves != null && possibleMoves.containsKey(direction)) {
                    currentLocation = possibleMoves.get(direction);

                   System.out.println("\nYou moved " + direction + " to: " + currentLocation.name);
                } else {
                    System.out.println("Building not found! Try again.");
        
                }

            
            }
            return currentLocation;
        
    }
    public void addNodesEdges(){
        mapGraph.addNode(pvta);
        mapGraph.addNode(bread);
        mapGraph.addNode(troots);
        mapGraph.addNode(woodstar);
        mapGraph.addNode(mosaic);
       
        //nodes for the store area
        mapGraph.addNode(music);
        mapGraph.addNode(thornes);
        mapGraph.addNode(uo);
        mapGraph.addNode(synergy);
        mapGraph.addNode(cedarChest);

        //nodes for city hall area
        mapGraph.addNode(cityHall);
        mapGraph.addNode(forbes);
        mapGraph.addNode(pulaski);
        mapGraph.addNode(policeStation);

        //nodes for smith college area
        mapGraph.addNode(smithGate);
        mapGraph.addNode(bass);
        mapGraph.addNode(scam);
        mapGraph.addNode(policeStation);


        //edges for the restaurant area 
        mapGraph.putEdge(pvta, bread); 
        mapGraph.putEdge(bread, woodstar); 
        mapGraph.putEdge(bread, troots); 
        mapGraph.putEdge(bread, mosaic);
        mapGraph.putEdge(bread, thornes);
        mapGraph.putEdge(troots, bread);
        mapGraph.putEdge(troots, mosaic);
        mapGraph.putEdge(mosaic, troots);
        mapGraph.putEdge(troots, woodstar);
        mapGraph.putEdge(mosaic, thornes);

        //edges for the store area 
        mapGraph.putEdge(music, cedarChest); 
        mapGraph.putEdge(music, thornes); 
        mapGraph.putEdge(music, uo); 
        mapGraph.putEdge(thornes, bread);
        mapGraph.putEdge(thornes, mosaic);
        mapGraph.putEdge(thornes, uo);
        mapGraph.putEdge(thornes, mosaic);
        mapGraph.putEdge(thornes, synergy);
        mapGraph.putEdge(cedarChest, thornes);
        mapGraph.putEdge(cedarChest, music);
        mapGraph.putEdge(cedarChest, uo);
        mapGraph.putEdge(cedarChest, synergy);
        mapGraph.putEdge(uo, music);
        mapGraph.putEdge(uo, cedarChest);
        mapGraph.putEdge(uo, thornes);
        mapGraph.putEdge(uo, synergy);
        mapGraph.putEdge(synergy, cedarChest);
        mapGraph.putEdge(synergy, uo);
        mapGraph.putEdge(synergy, thornes);
        
        //edges for the smith college area
        mapGraph.putEdge(bass, garden); 
        mapGraph.putEdge(bass, scam); 
        mapGraph.putEdge(bass, smithGate);
        mapGraph.putEdge(garden, scam); 
        mapGraph.putEdge(garden, bass);
        mapGraph.putEdge(garden, smithGate);
        mapGraph.putEdge(scam, garden);
        mapGraph.putEdge(scam, bass);
        mapGraph.putEdge(scam, smithGate);
        mapGraph.putEdge(smithGate, bass);
        mapGraph.putEdge(smithGate, scam);
        mapGraph.putEdge(smithGate, garden);


        //edges for the city hall area
        mapGraph.putEdge(cityHall, pvta); 
        mapGraph.putEdge(cityHall, forbes); 
        mapGraph.putEdge(cityHall, policeStation); 
        mapGraph.putEdge(cityHall, pulaski);
        mapGraph.putEdge(forbes, cityHall); 
        mapGraph.putEdge(forbes, policeStation);
        mapGraph.putEdge(forbes, pulaski);
        mapGraph.putEdge(pulaski, cityHall);
        mapGraph.putEdge(pulaski, bass);
        mapGraph.putEdge(scam, smithGate);
        mapGraph.putEdge(smithGate, bass);
        mapGraph.putEdge(smithGate, scam);
        mapGraph.putEdge(smithGate, garden);


    }

    public void directions(){
        // Directions for PVTA Station
        directions.put(pvta.name, Map.of(
            "East", bread,
            "North", smithGate,
            "West", cityHall,
            "South", music
        ));

        // Directions for Hungry Ghost Bread
        directions.put(bread.name, Map.of(
            "West", pvta,
            "South", thornes,
            "East", mosaic,
            "North", woodstar
        ));
        // Directions for Mosaic Cafe
        directions.put(mosaic.name, Map.of(
            "West", bread,
            "East", troots,
            "North", woodstar
        )); 

         // Directions for Woodstar Cafe
         directions.put(woodstar.name, Map.of(
            "South", bread,
            "East", mosaic
        ));

        // Directions for T.Roots
        directions.put(troots.name, Map.of(
            "West", mosaic
        ));

        //Direction of Academy of Music
        directions.put(music.name, Map.of(
            "North", pvta,
            "West", cedarChest,
            "South", uo,
            "East", thornes
        ));

        //Direction of Thornes
        directions.put(thornes.name, Map.of(
            "North", bread,
            "West", music,
            "South", uo,
            "East", synergy
        ));

         //Direction of urban outfitters
         directions.put(uo.name, Map.of(
            "North", thornes,
            "West", music,
            "South", cedarChest,
            "East", synergy
        ));
         //Directions for Cedar Chest
         directions.put(cedarChest.name, Map.of(
            "North", uo,
            "South", synergy,
            "East", music
        ));
         //Directions for Synergy
         directions.put(synergy.name, Map.of(
            "North", thornes,
            "South", cedarChest,
            "West", uo
        ));

        // Directions for City Hall
        directions.put(cityHall.name, Map.of(
            "North", pvta,
            "South", policeStation,
            "East", pulaski,
            "West", forbes

        ));

        // Directions for Forbes
        directions.put(forbes.name, Map.of(
            "South", policeStation,
            "East", pulaski,
            "North", cityHall

        ));

        // Directions for Pulaski Park
        directions.put(pulaski.name, Map.of(
            "South", policeStation,
            "West", forbes,
            "North", cityHall

        ));

        // Directions for Police Station
        directions.put(policeStation.name, Map.of(
            "North", cityHall,
            "East", pulaski,
            "West", forbes

        ));


        // Directions for Smith College
        directions.put(smithGate.name, Map.of(
            "South", pvta,
            "North", garden,
            "East", scam,
            "West", bass

        ));

        // Directions for Bass Hall
        directions.put(bass.name, Map.of(
            "North", garden,
            "East", scam,
            "South", smithGate

        ));

        // Directions for SCAM
        directions.put(scam.name, Map.of(
            "North", garden,
            "South", smithGate,
            "West", bass

        ));

        // Directions for Botanic Garden
        directions.put(garden.name, Map.of(
            "South", smithGate,
            "East", scam,
            "West", bass

        ));





    }
    public static void main(String args[]){
        MapGame map = new MapGame();
        map.addNodesEdges();
        map.directions();
        map.move("North");
        map.move("North");
        map.move("North");
        map.move("South");
        System.out.println(map.getCurrentLocation());
        //Object object = map.woodstar.getInventory();
        System.out.println(map.woodstar.getInventory().get(0).getName());
    }

        


    
}



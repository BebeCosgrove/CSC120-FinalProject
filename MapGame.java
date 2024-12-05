import com.google.common.graph.*;
import java.util.HashMap;
import java.util.Map;

// class Building {
    //String name;
  //  String address;

   // public Building(String name, String address) {
       // this.name = name;
      //  this.address = address;
   // }

   // @Override
 //   public String toString() {
//return name;
   // }
//}

public class MapGame{
   
    public static void main(String[] args) {
        // Create buildings (nodes)
        Building library = new Building("Neilson Library", "4 Tyler Ct");
        Building Synergy = new Building("Synergy", "2 Tyler Ct");
        Building Woodstar = new Building("Woodstar Cafe", "46 College Ln");
        Building Bread = new Building("hungry ghost bread", "44 College Ln");

        // Create a graph to represent the map
        MutableGraph<Building> mapGraph = GraphBuilder.undirected().build();

        // Add nodes and edges

        mapGraph.addNode(library);
        mapGraph.addNode(Synergy);
        mapGraph.addNode(Woodstar);
        mapGraph.addNode(Bread);

        mapGraph.putEdge(library, Synergy); 
        mapGraph.putEdge(Synergy, Woodstar); 
        mapGraph.putEdge(Woodstar, Bread); 

        // Use a helper map to store directions (optional)
        Map<String, Building> currentLocation = new HashMap<>();
        currentLocation.put("current", library); // Start at the library

        

    

        // Display the graph
        System.out.println("Locations and connections:");
        for (Building node : mapGraph.nodes()) {
            System.out.println(node + " is connected to " + mapGraph.adjacentNodes(node));
        }
    }
}


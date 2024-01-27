import java.io.FileWriter;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        /*
        We declared number of trial as 10000 arbitrarily.
        Increasing the number of trials might give better solution but executes slower*/
        final int NUMBER_OF_TRIALS = 10000;
        /* Takes the input and creates the graph instance */
        Graph graph = new Graph(args[0]); 
        /* Holds the total number of vertex in input. */
        int numberOfVertices = graph.vertices.size(); 
        /* Creates the color array */
        int[] colors = new int[numberOfVertices]; 
        /* Paints according to the algortihm in the Graph class*/
        int numberOfColors = graph.colorGraphBySorting(colors); 
        
        int[] newColors = new int[numberOfVertices]; 

        /* It finds the optimal coloring of the graph that it can find in the given number of trials
         and writes them to color array. */
        for (int i = 0; i < NUMBER_OF_TRIALS; i++) {  
            int newNumberOfColors = graph.colorGraph(newColors, numberOfColors);
            if(newNumberOfColors == -1)continue;
            colors = Arrays.copyOf(newColors, numberOfVertices);
            numberOfColors = newNumberOfColors; 
        }

        /*  Writes the colors array to the file */
        FileWriter output = new FileWriter("output.txt" );
        output.write(numberOfColors+"\n");
        for (int i : colors) {
            output.write(i+" ");
        }
        output.close();
    }
}
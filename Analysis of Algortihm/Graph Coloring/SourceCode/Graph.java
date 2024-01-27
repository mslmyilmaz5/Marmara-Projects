import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Graph {

    /* Creates an arraylist to store vertices. */
    ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    
    public Graph(String inputFileName) throws Exception {
        /* Reads the contet of input file */
        Scanner inputFile = new Scanner(new File(inputFileName));
        String[] line = inputFile.nextLine().split(" ");
        /* Store the total vertex number from the first line
          in the input file .*/
        int numberOfVertices = Integer.parseInt(line[1]);   
        /* Initially sets each vertex to 0 degrees.*/
        for (int i = 0; i < numberOfVertices; i++) {    
            vertices.add(new Vertex(i));
        }
        /* Takes the id's of vertices, adds an edge between
        them and make them neighbors. */
        while (inputFile.hasNext()) {
            line = inputFile.nextLine().split(" ");  
            int v1 = Integer.parseInt(line[1])-1;
            int v2 = Integer.parseInt(line[2])-1;
            addEdge(v1, v2);
        }
    }
    
    /*This method adds edge between two vertices.*/
    public void addEdge(int v1,int v2){      
        vertices.get(v1).addAdjacency(vertices.get(v2));
        vertices.get(v2).addAdjacency(vertices.get(v1));
    }

        /* STAGE 1 */
    public int colorGraphBySorting(int[] colors){
        /* Store total number of vertices in the list */
        int numberOfVertices = vertices.size(); 
        /* Initially declares all vertices as unpainted
        (-1 holds for unpainted)*/ 
        Arrays.fill(colors,-1); 
        /* Sort the vertices from highest to lowest 
        in terms of their degrees*/
        Collections.sort(vertices,Comparator.reverseOrder());  
        /* Starting color with zeroth color */
        int currentColor = 0; // staring color 0 
        for (int i = 0; i < numberOfVertices; i++) {
            Vertex currentVertex = vertices.get(i);
            /* If the vertex is already painted,continue */
            if(colors[currentVertex.vertexId]!=-1) continue; 
            /* Color the current vertex wtih the color we have*/
            colors[currentVertex.vertexId] = currentColor; 
            /* Check remaining vertices to color with the same color.*/
            for (int j = i+1; j < numberOfVertices; j++) { 
                /* Choose the spesific vertex */
                Vertex jthVertex = vertices.get(j); 
                /*Checks whether the vertex we painted before and the current
                 vertex adjacent or not and whether the vertex we selected
                 is already painted or not.*/
                if(!currentVertex.adjacencies.contains(jthVertex) && colors[jthVertex.vertexId]==-1){ 
                    /* Checks whether the neighbors of the selected 
                    vertex are painted with the current color or not */
                    boolean isColorable = true; 
                    for (int k = 0; k < jthVertex.adjacencies.size(); k++) {
                        if(colors[jthVertex.adjacencies.get(k).vertexId]==currentColor) isColorable = false; 
                    }
                    /*  If all conditions holds vertex is painted */
                    if(isColorable) colors[jthVertex.vertexId] = currentColor; 
                }
            }
            /* Continues with the next color */
            currentColor++; 
        }
        return currentColor;
    }

    /* STAGE 2  */
   
    /* It is the same logic with STAGE 1. Only difference is
      we do not sort the vertices according the their degrees.
      Instead,we store them randomly.
      Also, we have upperbound where we will check the total number of
      color used in STAGE 2 to decide whether
      continue with painting process or not.
      */
    public int colorGraph(int[] colors,int upperBound){ 
        int numberOfVertices = vertices.size();
        Arrays.fill(colors,-1);
        Collections.shuffle(vertices);
        int currentColor = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            Vertex currentVertex = vertices.get(i);
            if(colors[currentVertex.vertexId]!=-1) continue;
            colors[currentVertex.vertexId] = currentColor;
            for (int j = i+1; j < numberOfVertices; j++) {
                Vertex jthVertex = vertices.get(j);
                if(!currentVertex.adjacencies.contains(jthVertex) && colors[jthVertex.vertexId]==-1){
                    boolean isColorable = true;
                    for (int k = 0; k < jthVertex.adjacencies.size(); k++) {
                        if(colors[jthVertex.adjacencies.get(k).vertexId]==currentColor) isColorable = false; 
                    }
                    if(isColorable) colors[jthVertex.vertexId] = currentColor;
                }
            }
            currentColor++;
            /* If it exceeds the upper bound, do not continue */
            if(currentColor>=upperBound) return -1;//Exceeds upper bound
        }
        return currentColor;
    }
    
}

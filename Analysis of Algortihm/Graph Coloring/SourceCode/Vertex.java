import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
    int vertexId;    
    int degree;
    ArrayList<Vertex> adjacencies;
    

    /* Initializes vertex with given vertexId and zero as degree.*/
    public Vertex(int vertexId) {   
        this.vertexId = vertexId;       
        degree = 0;
        adjacencies = new ArrayList<Vertex>();
    }
    
    /* Adds the vertex in paramater as a neighbor of this vertex and
     * increases the degree of it. */
    public void addAdjacency(Vertex vertex){ 
        adjacencies.add(vertex);
        degree++;
    }
    @Override
    /* Vertexes are compared by their degrees.
    It is used to sort list of vertices according to degrees of vertices.*/
    public int compareTo(Vertex o) {    
        if(this.degree == o.degree){
            return 0;
        }
        if(this.degree>o.degree){
            return 1;
        }
        return -1;
    }
}

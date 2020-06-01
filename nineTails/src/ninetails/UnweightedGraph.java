/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninetails;

import java.util.List;

/**
 *
 * @author khela
 */
public class UnweightedGraph<V> extends AbstractGraph<V> {
 
    // Construct an empty unweighted graph 
    public UnweightedGraph(){
        ;
    }
    
    // Construct a graph with specified edges and vertices. 
    public UnweightedGraph(V[] vertices, int[][] edges){
        super(vertices, edges);
    }
    
    // Constructor with the specified vertices and edge stored in List
    public UnweightedGraph(List<V> vertices, List<Edge> edge){
        super(vertices, edge);
    }
    
    // Construct a graph for integer vertices 0,1,2 and edge list
    public UnweightedGraph(List<Edge> e, int numOfVertices){
        super(e, numOfVertices);
    }
    
    // Construct a graph from integer vertices 0,1 and edge array
    public UnweightedGraph(int [][]edges, int numOfVertices){
        super(edges,numOfVertices);
    }
}

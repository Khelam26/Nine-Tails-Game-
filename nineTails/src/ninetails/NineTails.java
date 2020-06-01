/**
 * Nine coins are placed in a three-by-three matrix with
 * some face up and some face down. A legal move is to take a coin that is face up and reverse it,
 * together with the coins adjacent to it (this does not include coins that are diagonally adjacent).
 * Your task is to find the minimum number of moves that lead to all coins being face down.
 */
/**
 * Classes used: 
 *  NineTail:           Main model, which contains the method to get a shortest path from the target node to any node
 *  Graph:              INterface that contains all the common operations of graphs and an abstract class named AbstractGraph that partially implements Grah
 *  UNweightedGraph:    It simply extends AbstractGraph with five constructors for creating the concrete Graph instances
 *  Edge:               To define edges as objects and store edges in a ArrayList. 
 *  AbstractGraph:      The AbstractGraph class defines the data field vertices to store vertices and
                        neighbors to store edges in adjacency lists. neighbors.get(i) stores all edges adjacent to vertex i
 */
/**
 * TARGET NODE
 *      TTT
 *      TTT
 *      TTT
 */
package ninetails;

import java.util.Scanner;

/**
 * @author khelan Created: May 6th, 2020 Last Modified: May 10th, 2020
 */
public class NineTails {

    public static void main(String[] args) {

        // Prompts the user to enter 9 random values of Hs and Ts
        System.out.println("Enter the intial Nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        
        if(userInput.isEmpty())
            userInput = input.nextLine();

        // Input Validation: All 0s and 1s are replaced with Hs and ts respectively. 
        userInput = userInput.replaceAll("0", "H");
        userInput = userInput.replaceAll("1", "T");

        // To Capitalize the characters before performing operations on them 
        userInput = userInput.toUpperCase();

        // The values are stored in an intial node. 
        char[] intialNode = userInput.toCharArray();

        // Using the NineTail class, the shortest path to reach the target node is found 
        NineTail nt = new NineTail();
        java.util.List<Integer> path = nt.getShortestPath(NineTail.getIndex(intialNode));

        // Steps on how the target node is achieved 
        System.out.println("The steps to flip the coins are: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.println("Step " + (i + 1) + ": ");
            nt.printNode(nt.getNode(path.get(i).intValue()));
        }
    }
}

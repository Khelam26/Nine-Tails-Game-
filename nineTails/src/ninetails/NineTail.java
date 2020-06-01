package ninetails;

import java.util.*;
import java.util.List;

/**
 * @author khelan 
 * Created: May 6th, 2020 
 * Last Modified: May 10th, 2020
 */
public class NineTail {

    public final static int SIZE = 9;
    public final static int NUMBER_OF_NODES = (int) Math.pow(2, SIZE);
    public final static int SQRT_SIZE = (int) Math.sqrt(SIZE);
    protected AbstractGraph<Integer>.Tree tree; // A tree rooted at the last node

    /**
     * Constructs a model for the nine tail problem and obtains the tree
     */
    public NineTail() {
        List<AbstractGraph.Edge> edges = getEdges();
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, NUMBER_OF_NODES);

        tree = graph.bfs(NUMBER_OF_NODES - 1);
    }

    /**
     * @param none Returns A list of edge object for the graph
     * @return List
     */
    private List<AbstractGraph.Edge> getEdges() {
        List<AbstractGraph.Edge> edges = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            for (int j = 0; j < SIZE; j++) {
                char[] node = getNode(i);
                if (node[j] == 'H') {
                    int v = getFlippedNode(node, j);
                    edges.add(new AbstractGraph.Edge(v, i));
                }
            }
        }
        return edges;
    }

    /**
     * Metod flips the node at the specified position and its adjacent position.
     * This method returns the index of the new node.
     *
     * @param node
     * @param position
     * @return index of the node
     */
    public static int getFlippedNode(char[] node, int position) {
        int row = (position / SQRT_SIZE);
        int column = (position % SQRT_SIZE);

        flipACell(node, row, column);
        flipACell(node, row - 1, column);
        flipACell(node, row + 1, column);
        flipACell(node, row, column - 1);
        flipACell(node, row, column + 1);

        return getIndex(node);
    }

    /**
     * Method flips a node at the specified row and column.
     *
     * @param node
     * @param row
     * @param column
     * @return none
     */
    public static void flipACell(char[] node, int row, int column) {
        if (row >= 0 && row <= (SQRT_SIZE - 1) && column >= 0 && column <= (SQRT_SIZE - 1)) {
            node[row * (SQRT_SIZE) + column] = (node[row * (SQRT_SIZE) + column] == 'H' ? 'T' : 'H');
        }
    }

    /**
     * Returns the index of the specified node
     *
     * @param node
     * @return
     */
    public static int getIndex(char[] node) {
        int result = 0;
        for (int i = 0; i < SIZE; i++) {
            result = (node[i] == 'T' ? (result * 2) + 1 : result * 2);
        }
        return result;
    }

    /**
     * Returns a node consisting of nine characters of Hs and Ts
     *
     * @param index
     * @return
     */
    public static char[] getNode(int index) {
        char[] result = new char[SIZE];

        for (int i = 0; i < SIZE; i++) {
            int digit = index % 2;

            result[(8) - i] = (digit == 0 ? 'H' : 'T');
            index /= 2;
        }
        return result;
    }

    /**
     * Method invokes the getPath method to get a vertices in a shortest path
     * from the specified node to the target node
     *
     * @param nodeIndex
     * @return
     */
    public List<Integer> getShortestPath(int nodeIndex) {
        return tree.getPath(nodeIndex);
    }

    /**
     * Method displays a node on the console
     *
     * @param node
     */
    public static void printNode(char[] node) {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i % SQRT_SIZE != 2 ? node[i] : node[i] + "\n");
        }
        System.out.println();
    }
}

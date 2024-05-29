import java.util.HashMap;
import java.util.Map;

/**
 * A class that represents a vertex in a graph.
 *
 * @param <V> The type of data held by the vertex.
 */
public class Vertex<V> {
    // The data associated with the vertex.
    private V data;
    // An object that manages the adjacent vertices and their edge weights.
    private AdjacencyList adjacencyList;

    /**
     * Constructs a vertex with the given data.
     *
     * @param data The data held by the vertex.
     */
    public Vertex(V data) {
        // Initialize the instance variables with the given data and a new AdjacencyList object.
        this.data = data;
        this.adjacencyList = new AdjacencyList();
    }

    /**
     * Returns the data held by the vertex.
     *
     * @return The data held by the vertex.
     */
    public V getData() {
        // Return the data associated with the vertex.

        return data;
    }

    /**
     * Adds an adjacent vertex with the given weight.
     *
     * @param destination The adjacent vertex to be added.
     * @param weight The weight of the edge to the adjacent vertex.
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        // Delegate the task of adding an adjacent vertex and its edge weight to the AdjacencyList object.

        adjacencyList.add(destination, weight);
    }

    /**
     * Returns the map of adjacent vertices and their edge weights.
     *
     * @return The map of adjacent vertices and their edge weights.
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacencyList.getAdjacentVertices();
    }

    /**
     * An inner class to manage the adjacent vertices and their edge weights.
     */
    private class AdjacencyList {
        // The map that stores the adjacent vertices and their edge weights.
        private Map<Vertex<V>, Double> adjacentVertices;

        public AdjacencyList() {
            // Initialize the map of adjacent vertices and their edge weights.
            this.adjacentVertices = new HashMap<>();
        }

        /**
         * Adds an adjacent vertex with the given weight.
         *
         * @param destination The adjacent vertex to be added.
         * @param weight The weight of the edge to the adjacent vertex.
         */
        public void add(Vertex<V> destination, double weight) {
            // Add the given adjacent vertex and its edge weight to the map.
            adjacentVertices.put(destination, weight);
        }

        /**
         * Returns the map of adjacent vertices and their edge weights.
         *
         * @return The map of adjacent vertices and their edge weights.
         */
        public Map<Vertex<V>, Double> getAdjacentVertices() {
            return adjacentVertices;
        }
    }
}

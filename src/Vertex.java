import java.util.HashMap;
import java.util.Map;

/**
 * Represents a vertex in a graph.
 *
 * @param <V> The type of data held by the vertex.
 */
public class Vertex<V> {

    // The data held by the vertex.
    private V data;

    // The adjacency list of the vertex, managing the adjacent vertices and their edge weights.
    private AdjacencyList adjacencyList;

    /**
     * Constructs a vertex with the given data.
     *
     * @param data The data held by the vertex.
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacencyList = new AdjacencyList();
    }

    /**
     * Returns the data held by the vertex.
     *
     * @return The data held by the vertex.
     */
    public V getData() {
        return data;
    }

    /**
     * Adds an adjacent vertex with the given weight.
     *
     * @param destination The adjacent vertex to be added.
     * @param weight The weight of the edge to the adjacent vertex.
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
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

        // The map of adjacent vertices and their edge weights.
        private Map<Vertex<V>, Double> adjacentVertices;

        public AdjacencyList() {
            this.adjacentVertices = new HashMap<>();
        }

        /**
         * Adds an adjacent vertex with the given weight.
         *
         * @param destination The adjacent vertex to be added.
         * @param weight The weight of the edge to the adjacent vertex.
         */
        public void add(Vertex<V> destination, double weight) {
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

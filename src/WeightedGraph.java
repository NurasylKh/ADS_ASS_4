import java.util.*;
/**
 * A class that represents a weighted graph, where vertices have data associated with them.
 *
 * @param <V> The type of data held by the vertices.
 */public class WeightedGraph<V> {
    // The map that stores the vertices and their associated data.
    private final Map<V, Vertex<V>> vertices;
    // A flag that indicates whether the graph is directed or not.
    private final boolean directed;
    // The map that stores the adjacency list of the graph, where each vertex is associated with a list of its adjacent edges.
    private final Map<V, List<Edge<V>>> adjacencyList;
    /**
     * Constructs a weighted graph with the given directionality.
     *
     * @param directed A flag that indicates whether the graph is directed or not.
     */
    public WeightedGraph(boolean directed) {
        // Initialize the instance variables with the given directionality and empty maps for vertices and adjacency list.
        this.directed = directed;
        this.vertices = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }
    /**
     * Returns the map of vertices and their associated data.
     *
     * @return The map of vertices and their associated data.
     */
    public Map<V, Vertex<V>> getVertices() {
        // Return the map of vertices and their associated data.
        return vertices;
    }
    /**
     * Returns the vertex associated with the given data. If the vertex does not exist, a new vertex is created and added to the graph.
     *
     * @param data The data associated with the vertex.
     * @return The vertex associated with the given data.
     */
    public Vertex<V> getVertex(V data) {
        // Retrieve the vertex associated with the given data. If it's null, create a new vertex and add it to the map of vertices.
        Vertex<V> vertex = vertices.get(data);
        if (vertex == null) {
            vertex = new Vertex<>(data);
            vertices.put(data, vertex);
        }
        // Return the vertex associated with the given data.
        return vertex;
    }
    /**
     * Adds an edge between the vertices associated with the given source and destination data, with the given weight.
     *
     * @param source The data associated with the source vertex.
     * @param dest The data associated with the destination vertex.
     * @param weight The weight of the edge.
     */
    public void addEdge(V source, V dest, double weight) {
        // Retrieve the vertices associated with the given source and destination data.
        Vertex<V> sourceVertex = getVertex(source);
        Vertex<V> destVertex = getVertex(dest);

        // Create a new edge between the source and destination vertices with the given weight.
        Edge<V> edge = new Edge<>(sourceVertex.getData(), destVertex.getData(), weight);
        // Add the edge to the adjacency list of the source vertex. If the list does not exist, create a new one.
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);

        // If the graph is not directed, add a reverse edge to the adjacency list of the destination vertex.
        if (!directed) {
            Edge<V> reverseEdge = new Edge<>(destVertex.getData(), sourceVertex.getData(), weight);
            adjacencyList.computeIfAbsent(dest, k -> new ArrayList<>()).add(reverseEdge);
        }
    }
    /**
     * Returns the list of edges adjacent to the vertex associated with the given data.
     *
     * @param v The data associated with the vertex.
     * @return The list of edges adjacent to the vertex associated with the given data , or an empty list if the vertex has no adjacent edges.
     */
    public List<Edge<V>> adjacencyList(V v) {
        // Return the list of edges adjacent to the vertex associated with the given data, or an empty list if the vertex has no adjacent edges.

        return adjacencyList.getOrDefault(v, Collections.emptyList());
    }
}

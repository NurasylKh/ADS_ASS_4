import java.util.*;
/**
 * A class that represents Dijkstra's algorithm for finding the shortest path in a weighted graph
 *
 * @param <V> The type of data held by the vertices
 */
public class DijkstraSearch<V> extends Search<V> {
    // The set of unsettled nodes in the graph
    private final Set<V> unsettledNodes;
    // The map that stores the shortest distance from the source vertex to each vertex in the graph
    private final Map<V, Double> distances;
    /**
     * Constructs a Dijkstra's algorithm for the given graph starting from the source vertex
     *
     * @param graph The weighted graph to search
     * @param source The source vertex to start the search from
     */
    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        // Call the superclass constructor to initialize the graph, source, marked, and edgeTo fields
        super(graph, source);
        // Initialize the unsettledNodes and distances fields
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        // Call the dijkstra method to perform Dijkstra's algorithm
        dijkstra();
    }

    private void dijkstra() {
        // Set the source vertex's distance to 0 and add it to the unsettledNodes
        distances.put(source, 0D);
        unsettledNodes.add(source);
        // Continue the algorithm until all the nodes are settled (visited)
        while (!unsettledNodes.isEmpty()) {
            // Get the vertex with the minimum weight from the unsettledNodes
            V currentNode = getVertexWithMinimumWeight(unsettledNodes);
            // Mark the current node as visited and remove it from the unsettledNodes
            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            // Iterate through the edges connected to the current node
            for (Edge<V> edge : graph.adjacencyList(currentNode)) {
                // Get the vertex on the other side of the edge
                V target = edge.other(currentNode);
                // Calculate the new distance to the target vertex through the current node
                double newDistance = getShortestDistance(currentNode) + edge.weight();

                // If the new distance is shorter than the current distance, update the distance and the edgeTo map
                // add the target vertex to the unsettledNodes if it's not already there
                if (getShortestDistance(target) > newDistance) {
                    distances.put(target, newDistance);
                    edgeTo.put(target, currentNode);
                    unsettledNodes.add(target);
                }
            }
        }
    }
    /**
     * Returns the vertex with the minimum weight from the given set of vertices.
     *
     * @param vertices The set of vertices to check.
     * @return The vertex with the minimum weight.
     */

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        // Initialize the minimum vertex to null.
        V minimum = null;
        // Iterate through the vertices and find the one with the minimum weight.
        for (V vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }
    /**
     * Returns the shortest distance to the given destination vertex.
     *
     * @param destination The destination vertex.
     * @return The shortest distance to the destination vertex.
     */
    private double getShortestDistance(V destination) {
        Double distance = distances.get(destination);
        return (distance == null ? Double.MAX_VALUE : distance);
    }
}

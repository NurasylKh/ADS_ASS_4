import java.util.*;
/**
 * A class that represents BFS algorithm on a weighted graph
 *
 * @param <V> The type of data held by the vertices
 */
public class BreadthFirstSearch<V> extends Search<V> {
    /**
     * Constructs a breadth-first search algorithm for the given graph starting from the source vertex
     *
     * @param graph The weighted graph to search
     * @param source The source vertex to start the search from
     */
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        // Call the superclass constructor to initialize the graph, source, marked, and edgeTo fields
        super(graph, source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        // Mark the current vertex as visited
        marked.add(current);
        // Create a queue to store the vertices to be visited.
        Queue<V> queue = new LinkedList<>();
        // Add the current vertex to the queue.
        queue.add(current);
        // Continue the BFS until the queue is empty.
        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (Edge<V> edge : graph.adjacencyList(v)) {
                V w = edge.other(v);
                // If the vertex is not marked, mark it and add it to the queue
                // update the edgeTo map to store the edge between the current vertex and the new vertex
                if (!marked.contains(w)) {
                    marked.add(w);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}

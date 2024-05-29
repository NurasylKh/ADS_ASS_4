import java.util.*;

/**
 * Abstract base class for search algorithms in a weighted graph.
 *
 * @param <V> The type of data held by the vertices.
 */
public class Search<V> {
    // The set of marked (visited) vertices during the search.
    protected Set<V> marked;
    // The map of edges that were used to reach each vertex during the search.
    protected Map<V, V> edgeTo;
    // The source vertex where the search begins.
    protected final V source;
    // The weighted graph to be searched.
    protected final WeightedGraph<V> graph;

    /**
     * Constructs a search algorithm for the given graph starting from the source vertex.
     *
     * @param graph The weighted graph to search.
     * @param source The source vertex to start the search from.
     */
    public Search(WeightedGraph<V> graph, V source) {
        // Initialize the instance variables with the given parameters and empty collections for marked and edgeTo.
        this.graph = graph;
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    /**
     * Checks if there is a path to the given vertex.
     *
     * @param v The vertex to check for a path.
     * @return True if there is a path to the vertex, false otherwise.
     */
    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    /**
     * Returns an iterable representing the path to the given vertex.
     *
     * @param v The vertex to get the path to.
     * @return An iterable representing the path to the vertex, or null if no path exists.
     */
    public Iterable<V> pathTo(V v) {
        // If there is no path to the given vertex, return null.
        if (!hasPathTo(v))
            return null;
        // Create a linked list to store the path from the source vertex to the given vertex.
        LinkedList<V> linkedList = new LinkedList<>();
        // Iterate through the edges in the edgeTo map, starting from the given vertex and moving towards the source vertex.
        for (V i = v; !i.equals(source); i = edgeTo.get(i))
            linkedList.push(i);
        // Add each vertex to the beginning of the linked list to maintain the correct order of the path
        linkedList.push(source);

        return linkedList;
    }
}
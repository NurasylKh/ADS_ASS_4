import java.util.*;

public class WeightedGraph<V> {
    private final Map<V, Vertex<V>> vertices;
    private final boolean directed;
    private final Map<V, List<Edge<V>>> adjacencyList;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }

    public Vertex<V> getVertex(V data) {
        Vertex<V> vertex = vertices.get(data);
        if (vertex == null) {
            vertex = new Vertex<>(data);
            vertices.put(data, vertex);
        }
        return vertex;
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> sourceVertex = getVertex(source);
        Vertex<V> destVertex = getVertex(dest);

        Edge<V> edge = new Edge<>(sourceVertex.getData(), destVertex.getData(), weight);
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);

        if (!directed) {
            Edge<V> reverseEdge = new Edge<>(destVertex.getData(), sourceVertex.getData(), weight);
            adjacencyList.computeIfAbsent(dest, k -> new ArrayList<>()).add(reverseEdge);
        }
    }

    public List<Edge<V>> adjacencyList(V v) {
        return adjacencyList.getOrDefault(v, Collections.emptyList());
    }
}

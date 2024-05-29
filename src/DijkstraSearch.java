import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Set<V> unsettledNodes;
    private final Map<V, Double> distances;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(graph, source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();

        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            V currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Edge<V> edge : graph.adjacencyList(currentNode)) {
                V target = edge.other(currentNode);
                double newDistance = getShortestDistance(currentNode) + edge.weight();

                if (getShortestDistance(target) > newDistance) {
                    distances.put(target, newDistance);
                    edgeTo.put(target, currentNode);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(V destination) {
        Double distance = distances.get(destination);
        return (distance == null ? Double.MAX_VALUE : distance);
    }
}

/**
 * Main class to test BFS and Dijkstra's algorithm. */
public class Main {
    public static void main(String[] args) {
        // Create a weighted graph and populate it with weights
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);
        // Perform Dijkstra's algorithm and print the result
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Astana");
        outputPath(djk, "Kyzylorda");

        // Create a new weighted graph and populate it without weights
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        fillWithoutWeights(graph);
        // Perform BFS and print
        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Astana");
        outputPath(bfs, "Kyzylorda");
    }
    /**
     * Populate the given weighted graph with edges and weights
     */
    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Astana", "Almaty", 3.1);
        graph.addEdge("Zhezkazgan", "Aktau", 5.2);
        graph.addEdge("Aktau", "Almaty", 7.1);
        graph.addEdge("Almaty", "Zhezkazgan", 6.3);
        graph.addEdge("Zhezkazgan", "Astana", 4.2);
        graph.addEdge("Almaty", "Kostanay", 5.3);
        graph.addEdge("Zhezkazgan", "Kyzylorda", 2.1);
    }
    public static void fillWithoutWeights(WeightedGraph<String> graph) {
        graph.addEdge("Astana", "Almaty", 1.0);
        graph.addEdge("Zhezkazgan", "Aktau", 1.0);
        graph.addEdge("Aktau", "Almaty", 1.0);
        graph.addEdge("Almaty", "Zhezkazgan", 1.0);
        graph.addEdge("Zhezkazgan", "Astana", 1.0);
        graph.addEdge("Almaty", "Kostanay", 1.0);
        graph.addEdge("Zhezkazgan", "Kyzylorda", 1.0);
    }
    /**
     * to print the path from the source to the target, if it exists
     */
    public static void outputPath(Search<String> search, String key) {
            Iterable<String> path = search.pathTo(key);
            if (path == null) {
                System.out.println("No path found to " + key);
            } else {
                printPath(path);
            }
        }

        /**
         * Print the given path.
         */
        private static void printPath(Iterable<String> path) {
            for (String v : path) {
                System.out.print(v + " > ");
            }
            System.out.println();
        }



}

package Algorithms;
import visualizer.Edge;
import visualizer.Vertex;
import java.util.*;

public class DFSAlgorithm implements GraphAlgorithm {

    @Override
    public AlgorithmResult run(Map<Vertex, List<Edge>> graph, Vertex start) {

        // If the chosen vertex doesn't have any edges, then just return it
        if (graph.get(start).isEmpty()) {
            List<Vertex> onlyStart = new ArrayList<>();
            onlyStart.add(start);
            return new AlgorithmResult(onlyStart, "DFS -> " + start.getId()) ;
        }

        // Initialize the string that will contain the traversal
        String traversalPath = "DFS : ";

        // Initialize a set to keep track of visited Vertices
        Set<Vertex> visited = new HashSet<>();
        
        // Records the order vertices are first visited in, for step-by-step animation
        List<Vertex> visitOrder = new ArrayList<>();


        // Call helper on Start Vertex
        traversalPath += helper(graph, start, visited, visitOrder);

        // Iterate through all other nodes in the graph
        for (Vertex vertex: graph.keySet()) {
            if (!visited.contains(vertex) && !graph.get(vertex).isEmpty()) {
                traversalPath += helper(graph, vertex, visited, visitOrder);
            }
        }

        String summary = traversalPath.substring(0, traversalPath.length() - 4);
        return new AlgorithmResult(visitOrder, summary);
    }

    private String helper(Map<Vertex, List<Edge>> graph, Vertex vertex, Set<Vertex> visited, List<Vertex> visitOrder) {
        // The output string
        String output = "";

        // Mark the current Vertex as visited
        visited.add(vertex);
        visitOrder.add(vertex);

        // Process the current Vertex
        output += processVertex(vertex);

        // Find the Edges of the current Vertex
        List<Edge> currentVertexEdges = graph.get(vertex);

        // Sort the edges from the lowest weight (first to traverse) to the highest weight (last to traverse)
        Collections.sort(currentVertexEdges);

        // Recursively visit all unvisited neighbors of the current Vertex
        for (Edge edge: currentVertexEdges) {
            Vertex neighbor = edge.getVertex2();
            if (!visited.contains(neighbor)) {
                output += helper(graph, neighbor, visited, visitOrder);
            }
        }

        return output;
    }
}



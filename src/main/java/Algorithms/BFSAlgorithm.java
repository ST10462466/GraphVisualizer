package algorithms;

import visualizer.Edge;
import visualizer.Vertex;

import java.util.*;

/*
- Breadth-First Search. Now also records visitOrder so the GUI can animate
- the traversal step by step, in addition to the original summary string.
 */
public class BFSAlgorithm implements GraphAlgorithm {

    @Override
    public AlgorithmResult run(Map<Vertex, List<Edge>> graph, Vertex start) {
        // Initialize the string that will contain the traversal
        String traversalPath = "BFS : ";

        // Initialize a set to keep track of visited Vertices
        Set<Vertex> visited = new HashSet<>();

        // Initialize a queue for BFS
        Queue<Vertex> queue = new LinkedList<>();

        // Records the order vertices are dequeued/processed in, for step-by-step animation
        List<Vertex> visitOrder = new ArrayList<>();

        // Mark the start Vertex as visited and enqueue it
        visited.add(start);
        queue.offer(start);

        // BFS traversal
        while (!queue.isEmpty()) {
            // Dequeue a Vertex from the queue
            Vertex current = queue.poll();

            // Process the current Vertex
            traversalPath += processVertex(current);
            visitOrder.add(current);

            // Find the Edges of the current Vertex
            List<Edge> currentVertexEdges = graph.get(current);

            // Sort the edges from the lowest weight (first to traverse) to the highest weight (last to traverse)
            Collections.sort(currentVertexEdges);

            // Visit all unvisited neighbors of the current Vertex
            for (Edge edge : currentVertexEdges) {
                Vertex neighbor = edge.getVertex2();
                if (!visited.contains(neighbor)) {
                    // Mark neighbor as visited and enqueue
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        String summary = traversalPath.substring(0, traversalPath.length() - 4);
        return new AlgorithmResult(visitOrder, summary);

    }

}

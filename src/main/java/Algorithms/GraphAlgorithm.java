
package algorithms;

import visualizer.Edge;
import visualizer.Vertex;
import java.util.*;

// Update GraphAlgorithm interface to return AlgorithmResult instead of String
public interface GraphAlgorithm {
    AlgorithmResult run(Map<Vertex, List<Edge>> graph, Vertex start);

    default String processVertex(Vertex vertex) {
        return vertex.getId() + " -> ";
    }
}

package Algorithms;

import visualizer.Edge;
import visualizer.Vertex;

import java.util.*;

/*
 Replaced String with AlgorithmResult to carry both the visit order and the final
summary text from BFS/DFS/Dijkstra/Prim. Graph now animates through the
visit order with a Timer, highlighting each vertex in turn, before
showing the existing summary text.
*/
public class AlgorithmSetter {

    private GraphAlgorithm algorithm;

    public void setAlgorithm(GraphAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    // Runs the currently selected algorithm starting from the given vertex.
    
    public AlgorithmResult execute(Map<Vertex, List<Edge>> graph, Vertex start) {
        return this.algorithm.run(graph, start);
    }
}

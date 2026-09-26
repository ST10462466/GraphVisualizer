
package Algorithms;
import visualizer.Vertex;
import java.util.Collections;
import java.util.List;

/*
 * The result of running a GraphAlgorithm.
 *
 * Carries two things the GUI needs:
 *   - visitOrder: the vertices in the exact order the algorithm visited/settled them,
 *     used to animate the traversal step by step on screen.
 *   - summary: the final human-readable result text (unchanged from the original
 *     BFS/DFS/Dijkstra/Prim output format), shown once the animation finishes.
*/

public class AlgorithmResult {
    
    private final List<Vertex> visitOrder;
        private final String summary;

        public AlgorithmResult(List<Vertex> visitOrder, String summary) {
            this.visitOrder = Collections.unmodifiableList(visitOrder);
            this.summary = summary;
        }

        public List<Vertex> getVisitOrder() {
            return visitOrder;
        }

        public String getSummary() {
            return summary;
        }

}

Graph Algorithms Visualizer

* Project Description
This is a Java Swing desktop application for building graphs by hand and running classic graph algorithms on them. A user places vertices on a canvas, connects them with weighted edges, and then runs Breadth-First Search, Depth-First Search, Dijkstra's Algorithm, or Prim's Algorithm from a chosen starting vertex.
The problem it solves is a teaching/learning one: graph algorithms are usually described in text or on a whiteboard, which makes it hard to see how they actually move through a graph. This tool lets you build your own graph, run an algorithm on it, and watch the result, instead of reading it in the abstract.
Feature added for this ICE: the original version of the app ran an algorithm instantly and only ever displayed the final text result (e.g. `BFS : A -> B -> C`), with no indication of how the algorithm got there. I added step-by-step visual highlighting of the traversal: when an algorithm runs, each vertex it visits lights up green in the exact order the algorithm visits it, animated with a timer, before the final summary text is shown. This applies to all four algorithms (BFS, DFS, Dijkstra's, Prim's).

* How to Run
Make sure you have Java 21 installed.
Open NetBeans.
Select File -> Open Project, browse to the `GraphVisualizer` folder, and open it (NetBeans reads the Maven `pom.xml` automatically and imports it as a Maven project).
Wait for NetBeans to finish resolving/building the project (check the bottom status bar).
In the Projects panel, expand `Source Packages -> Visualizer`, right-click `GraphVisualizer.java`, and select Run File.
The application window should open.

* Usage Guide
Modes (top menu bar, "Mode"):
Add a Vertex – click anywhere on empty canvas to place a vertex; you'll be asked for a single-character ID.
Add an Edge – click two vertices in a row to connect them; you'll be asked for an edge weight.
Remove a Vertex – click a vertex to delete it (and any edges attached to it).
Remove an Edge – click an edge to delete it.
None – used when running an algorithm (see below).
Graph Creation:
Switch to Add a Vertex mode and click on the canvas to add each vertex, giving each a unique 1-character ID.
Switch to Add an Edge mode and click two vertices in sequence to connect them with a weighted edge.
Repeat until the graph is built. Vertices/edges can be removed at any time using the corresponding Remove mode.
Algorithm Execution:
Open the Algorithms menu and choose BFS, DFS, Dijkstra's, or Prim's Algorithm. This automatically switches the mode to None.
Click on the vertex you want to use as the starting point.
Watch the vertices highlight green one at a time in the order the algorithm visits them.
Once the animation finishes, the final result (traversal order / shortest distances / MST parent links) is shown at the bottom of the window.
File menu:
New – clears the canvas and starts a fresh graph.
Exit – closes the application.

* Skills Applied
Java Swing GUI development (`JFrame`, `JPanel`, `JMenu`, custom-painted components)
Mouse event handling and mode-based UI state management
Object-oriented design: Strategy pattern for swapping algorithms (`GraphAlgorithm` interface + `AlgorithmSetter`)
Data structures: adjacency-list graph representation (`Map<Vertex, List<Edge>>`), queues, sets, maps
Graph algorithms: Breadth-First Search, Depth-First Search, Dijkstra's shortest path, Prim's minimum spanning tree
UI animation using `javax.swing.Timer` to sequence state changes over time
Working with an existing codebase: reading and extending someone else's architecture without breaking existing behaviour

* Technologies Used
Java 21
Java Swing (GUI toolkit, part of the JDK)
Maven (build/dependency management, see `pom.xml`)

* Visuals
<img width="980" height="727" alt="IceTask3(a)" src="https://github.com/user-attachments/assets/9fa6f2b3-f9d6-4033-93e5-1a022a4db6ee" />
<img width="962" height="730" alt="IceTask3(b)" src="https://github.com/user-attachments/assets/9861e9ca-6735-4041-bf64-51aa773524fe" />
<img width="975" height="720" alt="IceTask3(c)" src="https://github.com/user-attachments/assets/78720206-a7f8-428b-80a0-7693be65fb96" />


* Portfolio Reflection
This project is a strong portfolio piece because it demonstrates a full slice of software development: GUI design, event-driven programming, data modelling, and implementing textbook algorithms correctly inside a real application rather than in isolation. It also shows the ability to read and extend an existing codebase — a skill that matters more in real jobs than writing something from scratch.
Working on the animated highlighting feature reinforced how much of an algorithm's behaviour is lost when only the final answer is shown, and how a small change in what data is returned (visit order, not just a final string) can unlock a much clearer way of presenting it to a user.

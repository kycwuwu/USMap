AUTHOR: Kylie Wu
CORE CONCEPTS: graphs, heaps, disjoint sets, minimum spanning trees, self-made lists and nodes

This program displays major US cities (whose names and coordinates are listed on the file cityxy.txt) on a GUI that resembles a primitive map. Upon loading, it calculates the minimum spanning tree connecting all of the cities together.

To run the entire program, run USMap.java.

CLASSES:

USMap - The tester class that also defines the other methods needed for the program to run, such as reading the input file to generate points, creating all possible edges, calculating the minimum spanning tree, and displaying all the needed data.

MapPanel - Extension of the JPanel class from javax.swing. It enables the program to draw the cities, city names, and edges onto the window.

CityNode - Serves as a vertex of the graph, representing a city. Contains a name, XY coordinates, and a reference to the next CityNode (assuming it is in a CityList)

CityList - Self-implementation of a linked list of CityNodes

MapEdge - Serves as an edge of the graph that connects two CityNodes together, having a weight equivalent to the distance between the CityNodes. Also stores the names of the two cities it connects.

EdgeListNode - Contains the data from MapEdge and a reference to the next EdgeListNode in the EdgeList

EdgeList - Self-implementation of a linked list of EdgeListNodes

HeapTreeNode - Defines properties of a node within a heap and/or tree. Contains reference to a MapEdge, and left/right HeapTreeNodes.

MyBinaryHeap - Implementation of a minHeap of HeapTreeNodes that was borrowed from the Weiss textbook

DisjSet - Implementation of a disjoint set, code adapted from the Weiss textbook. Used to make sure duplicate edges between two cities are not made.

THINGS TO NOTE:

The console output of cities and distances is a little messy, due to the huge variance in city names. This made it difficult to format the output nicely in even columns.
The graphical output of the map had to be scaled down in order for it to fit in the window nicely.
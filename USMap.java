/**
 * COMSW3137
 * Assignment 5 Part 1
 * Kylie Wu
 * kcw2141
 *
 * Contains all the methods needed to create needed data and run the program.
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class USMap
{
    // all of these lists are shared with all the methods
    static CityList cities;
    static EdgeList edges;
    static EdgeList mst;
    private JFrame frame;

    /**
     * Runs the program and calls the needed methods in the proper order
     * @param args parameters from the command line (there are none needed for this one)
     */
    public static void main(String args[])
    {
        // create a new list for cities and edges
        cities = new CityList();
        edges = new EdgeList();

        readCities();
        makeEdges();
        makeMinSpanTree();

        new USMap();
    }

    /**
     * Creates the GUI
     */
    public USMap()
    {
        // sets up GUI window
        this.frame = new JFrame("Map");
        this.frame.setSize(1650,1000);

        // adds panel to window
        MapPanel panel = new MapPanel(cities, mst);
        this.frame.getContentPane().add(panel, BorderLayout.CENTER);

        this.frame.setVisible(true);
    }

    /**
     * Reads the files from the file cityxy.txt and adds the information to the CityList cities
     */
    public static void readCities()
    {
        try
        {
            Scanner reader = new Scanner(new File("cityxy.txt"));

            // read in cities with coordinate and put them in a list
            while (reader.hasNext())
            {
                String cityName = reader.next();
                int xCoord = reader.nextInt();
                int yCoord = reader.nextInt();
                CityNode cNode = new CityNode(cityName, xCoord, yCoord);
                cities.add(cNode);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }

    /**
     * Creates edges between the cities
     */
    public static void makeEdges()
    {
        // create edges between all cities and print them out
        CityNode city1 = cities.header;
        CityNode city2 = cities.header.next;
        while (city1 != null && city2 != null)
        {
            // calculate distance
            double theDistance = Math.sqrt(Math.pow((city1.getX() - city2.getX()), 2)
                    + Math.pow((city1.getY() - city2.getY()), 2));
            // create a new edge and add it to the list
            edges.add(new MapEdge(city1, city2, theDistance));
            city2 = city2.next;

            // once we exhaust all the combinations of city1 with other city2s, go to the next start city and
            // continue to iterate through other possible city combinations
            if (city2 == null)
            {
                city1 = city1.next;
                city2 = city1.next;
            }
        }

        // print out cities and distances
        System.out.println("All possible (non-repeated) edges:\nStart City\t\tEnd City \t\t Distance");
        EdgeListNode current = edges.header;
        while (current != null)
        {
            System.out.println(current);
            current = current.next;
        }
    }

    /**
     * Creates a minimum spanning tree
     */
    public static void makeMinSpanTree()
    {
        MyBinaryHeap heap = new MyBinaryHeap(edges.getSize());

        // insert all edges into the heap
        EdgeListNode current = edges.header;
        while (current != null)
        {
            heap.insert(new HeapTreeNode(current.edge));
            current = current.next;
        }

        DisjSet ds = new DisjSet(cities.getSize(), cities);
        mst = new EdgeList();

        while(mst.getSize() != (cities.getSize() - 1) && !heap.isEmpty())
        {
            // find the shortest edge weight
            HeapTreeNode e = heap.deleteMin();
            // find which set the city is located in
            int firstHeader = ds.find(ds.getIndex(e.edge.firstCity.getName()));
            int secondHeader = ds.find(ds.getIndex(e.edge.secondCity.getName()));

            // if the cities are in different lists (not connected), add the edge to the tree and union the sets
            if (firstHeader != secondHeader) {
                mst.add(e.edge);
                ds.union(firstHeader, secondHeader);
            }
        }

        // printing out the tree
        System.out.println("\nMinimum Spanning Tree Edges:\nStart City\t\tEnd City \t\t Distance");
        System.out.println(mst);
    }

}

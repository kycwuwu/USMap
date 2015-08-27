/**
 * COMSW3137
 * Assignment 5 Part 1
 * Kylie Wu
 * kcw2141
 *
 * Node holding data for a MapEdge to be used in EdgeList
 */
public class EdgeListNode
{
    MapEdge edge;
    EdgeListNode next;

    /**
     * Makes a new EdgeListNode with the given data
     * @param m given MapEdge
     */
    public EdgeListNode(MapEdge m)
    {
        edge = m;
        next = null;
    }

    /**
     * String representation of the EdgeListNode
     * @return a String
     */
    public String toString()
    {
        return (edge.toString());
    }
}

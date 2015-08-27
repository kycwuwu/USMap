/**
 * COMSW3137
 * Assignment 5 Problem 1
 * Kylie Wu
 * kcw2141
 *
 * Node that can be used in a heap or a tree
 */
public class HeapTreeNode
{
    MapEdge edge;
    HeapTreeNode left;
    HeapTreeNode right;

    /**
     * Creates a new node with the given MapEdge data
     * @param me given MapEdge
     */
    public HeapTreeNode(MapEdge me)
    {
        edge = me;
        left = null;
        right = null;
    }
}

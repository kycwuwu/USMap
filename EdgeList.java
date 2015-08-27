/**
 * COMSW3137
 * Assignment 5 Part 1
 * Kylie Wu
 * kcw2141
 *
 * List of edges between cities
 */
public class EdgeList
{
    EdgeListNode header;

    /**
     * Default constructor
     */
    public EdgeList()
    {
        header = null;
    }

    /**
     * Adds an EdgeList Node to the list
     * @param e MapEdge to be converted into an EdgeListNode to be added to the list
     */
    public void add(MapEdge e)
    {
        // create a new EdgeListNode with the given MapEdge data
        EdgeListNode node = new EdgeListNode(e);

        // if the header is empty, the new node becomes the header
        if (header == null)
        {
            header = node;
        }
        else
        {
            EdgeListNode current = header;
            EdgeListNode prev = null;

            // find the end of the list
            while (current != null)
            {
                prev = current;
                current = current.next;
            }

            // add the node to the end of the list
            prev.next = node;
        }
    }

    /**
     * Gets the number of elements in the list
     * @return int size of the list
     */
    public int getSize()
    {
        EdgeListNode current = header;
        int count = 0;

        while (current != null)
        {
            current = current.next;
            count += 1;
        }

        return count;
    }

    /**
     * String representation of the list
     * @return String of the data in the list
     */
    public String toString()
    {
        String s = "";

        EdgeListNode current = header;

        // print each node in the list
        while (current != null)
        {
            s += current.toString() + "\n";
            current = current.next;
        }

        return s;
    }
}

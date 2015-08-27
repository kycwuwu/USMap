/**
 * COMSW3137
 * Assignment 5 Part 1
 * Kylie Wu
 * kcw2141
 *
 * Implementation of a set from Weiss textbook
 */
public class DisjSet
{
    private int[] parent;
    private String[] cityNames;

    /**
     * Creates a disjoint set of a certain size using data from a CityList
     * @param numElements int number of elements
     * @param c the list of cities to use
     */
    public DisjSet(int numElements, CityList c)
    {
        parent = new int[numElements];
        cityNames = new String[numElements];
        CityNode current = c.header;

        // set all parent values to -1 and the cityNames to each city's name from the list
        for (int i = 0; i < parent.length; i++)
        {
            parent[i] = -1;
            cityNames[i] = current.getName();
            current = current.next;
        }
    }

    /**
     * Finds the index of the list's header
     * @param s String to be found
     * @return int index
     */
    public int getIndex(String s)
    {
        int index = 0;

        // go through the index searching for the string
        do
        {
            if (cityNames[index].equals(s))
            {
                return index;
            }
            index += 1;
        }
        while (index < cityNames.length);

        return index;
    }

    /**
     * Finds the index of the list's header
     * @param x the index to look at
     * @return int index of header
     */
    public int find(int x)
    {
        // if the value is -1, that means the current index is the location of the header
        if (parent[x] < 0)
            return x;
        // recurse and follow the parent to find the header
        else
            return find(parent[x]);
    }

    /**
     * Joins the two lists together
     * @param root1 header location of one set
     * @param root2 header location of other set
     */
    public void union(int root1, int root2)
    {
        parent[root1] = root2;
    }
}

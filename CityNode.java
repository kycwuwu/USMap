/**
 * COMSW3137
 * Assignment 5 Part 1
 * Kylie Wu
 * kcw2141
 *
 * The node for a CityList
 */
public class CityNode
{
    private String name;
    private int x;
    private int y;
    CityNode next;

    /**
     * Creates a new CityNode with the given information
     * @param n the name of the city
     * @param a x coordinate
     * @param b y coordinate
     */
    public CityNode(String n, int a, int b)
    {
        name = n;
        x = a;
        y = b;
        next = null;
    }

    /**
     * Gets the name of the city
     * @return String name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the x coordinate of the city
     * @return int x
     */
    public int getX()
    {
        return x;
    }

    /**
     * Returns the y coordinate of the city
     * @return int y
     */
    public int getY()
    {
        return y;
    }
}

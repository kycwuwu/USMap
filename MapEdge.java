/**
 * COMSW3137
 * Assignment 5 Part 1
 * Kylie Wu
 * kcw2141
 *
 * An edge on the map that connects two cities
 */
public class MapEdge
{
    CityNode firstCity;
    CityNode secondCity;
    double distance;

    /**
     * Constructor
     * @param c1 Node for first city
     * @param c2 Node for second city
     * @param d double for the distance between the cities
     */
    public MapEdge(CityNode c1, CityNode c2, double d)
    {
        firstCity = c1;
        secondCity = c2;
        distance = d;
    }

    /**
     * String representation of a MapEdge
     * @return String representing the CityNodes that make up the edge and the distance between them
     */
    public String toString()
    {
        return (firstCity.getName() + "\t\t" + secondCity.getName() + " \t\t" + distance);
    }
}

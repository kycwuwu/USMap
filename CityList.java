/**
 * COMSW3137
 * Assignment 5 Problem 1
 * Kylie Wu
 * kcw2141
 *
 * List of cities
 */
public class CityList
{
    CityNode header;

    /**
     * Default constructor for a CityList
     */
    public CityList()
    {
        header = null;
    }

    public CityList(CityNode c)
    {
        header = c;
    }

    /**
     * Adds a city to the CityList
     * @param c city to add to the CityList
     */
    public void add(CityNode c)
    {
        // if there is no header, c is the header
        if (header == null)
        {
            header = c;
        }
        else
        {
            CityNode current = header;
            CityNode prev = null;

            // traverse the list until we hit the end
            while (current != null)
            {
                prev = current;
                current = current.next;
            }

            // make c the last element
            prev.next = c;
        }
    }

    /**
     * Obtains the number of elements in this list
     * @return int representing the list's size
     */
    public int getSize()
    {
        int count = 0;
        CityNode current = header;

        while (current != null)
        {
            count += 1;
            current = current.next;
        }

        return count;
    }

    /**
     * Checks if the list contains this city
     * @param c
     * @return
     */
    public boolean contains(CityNode c)
    {
        CityNode current = header;

        while (current != null)
        {
            // if the names are the same this list contains c
            if (current.getName().equals(c.getName()))
                return true;

            current = current.next;
        }

        return false;
    }
}

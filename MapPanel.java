/**
 * COMSW3137
 * Assignment 5 Problem 1
 * Kylie Wu
 * kcw2141
 *
 * Extension of JPanel that enables drawing on the map's data
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MapPanel extends JPanel
{
    private CityList c;
    private EdgeList e;
    final double shrinkFactor = 0.55; // to scale the map to a size that will fit in the window

    /**
     * Creates a new MapPanel with the given data in mind
     * @param city list of cities
     * @param edge list of edges
     */
    public MapPanel(CityList city, EdgeList edge)
    {
        super();
        c = city;
        e = edge;
    }

    /**
     * Paints graphics onto the panel
     * @param g given Graphics
     */
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        CityNode currentC = c.header;
        EdgeListNode currentE = e.header;

        // paint the city locations and their names
        while (currentC != null)
        {
            Ellipse2D.Double city = new Ellipse2D.Double(shrinkFactor*currentC.getX() - 5,
                    850 - shrinkFactor*currentC.getY() - 5, 10, 10);
            g2.drawString(currentC.getName(), (float) (shrinkFactor*currentC.getX()) + 5,
                    (float) (850 - shrinkFactor*currentC.getY()));
            g2.draw(city);
            g2.fill(city);
            currentC = currentC.next;
        }

        // paint in the edges between the cities
        while (currentE != null)
        {
            g2.setColor(Color.RED);
            Line2D.Double path = new Line2D.Double(shrinkFactor*currentE.edge.firstCity.getX(),
                    850 - shrinkFactor*currentE.edge.firstCity.getY(), shrinkFactor*currentE.edge.secondCity.getX(),
                    850 - shrinkFactor*currentE.edge.secondCity.getY());
            g2.draw(path);
            currentE = currentE.next;
        }
    }
}

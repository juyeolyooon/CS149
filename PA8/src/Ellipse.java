import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Ellipse extends JComponent {       /* ellipse class extends JComponent class from swing package inside
                                                    of javax package */
    public void paintComponent(Graphics g) {    /* overriding paintComponent of JComponent class and passing object g
                                                   of type Graphics as an argument */

        Graphics2D g2 = (Graphics2D) g;         //casting g into a new variable g2 of type Graphics 2D

        g2.setColor(Color.BLACK);               //setting the black color to paint the ellipse with

        Ellipse2D.Double ellipseObj = new Ellipse2D.Double(0, 0, getWidth(), getHeight());   /* calling getWidth
                                                  and getHeight method inside of the constructor to resize ellipse */

        g2.draw(ellipseObj);                   //this draws black outlined ellipse with no filled color

        g2.setColor(Color.CYAN);               //this sets the filling color to light blue

        g2.fill(ellipseObj);                  //this fills ellipse with light blue color

    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class E20_7 {
    public static void main(String[] args) {
        new E20_7();
    }

    ArrayList<RectangleComponents> listOfRectangles;
    JFrame frame = new JFrame();
    final int BOX_MAX_W = 70;
    final int BOX_MAX_H = 90;
    final int WIDTH = 500;
    final int HEIGHT = 600;

    public E20_7()                //E20_7 constructor with menu items and frame
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("E20_7 Menu Items");
        JMenuItem fewerItem = new JMenuItem("Fewer");
        JMenuItem moreItem = new JMenuItem("More");

        fewerItem.addActionListener(new Listener(false));
        moreItem.addActionListener(new Listener(true));

        menu.add(fewerItem);
        menu.add(moreItem);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
        frame.setTitle("E20.7");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        listOfRectangles = new ArrayList<>();
    }

    static class RectangleComponents extends JComponent       //components and color of the rectangles
    {
        Rectangle box;
        Color color;

        public RectangleComponents(int x, int y, int w, int h, Color color) {
            this.box = new Rectangle(x, y, w, h);
            this.color = color;
        }

        public void paint(Graphics g)              //drawing the rectangles
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.draw(box);
        }
    }

    public void paintRectangles(boolean more) {         //implementing menu item functions
        int numberOfRectangle = listOfRectangles.size();

        if (more) {
            if (numberOfRectangle == 0) {
                numberOfRectangle++;
            } else {
                numberOfRectangle *= 2;
            }

            for (int i = listOfRectangles.size(); i < numberOfRectangle; i++) {
                int w = (int) (Math.random() * (BOX_MAX_W));
                int h = (int) (Math.random() * (BOX_MAX_H));
                int x = (int) (Math.random() * (WIDTH - w));
                int y = (int) (Math.random() * (HEIGHT - h));
                RectangleComponents box = new RectangleComponents(x, y, w, h, Color.BLACK);
                listOfRectangles.add(box);
                frame.add(box);
                frame.setVisible(true);
            }
        } else {
            numberOfRectangle /= 2;
            for (int i = listOfRectangles.size() - 1; i >= numberOfRectangle; i--) {
                RectangleComponents box = listOfRectangles.get(listOfRectangles.size() - 1);
                frame.remove(box);
                listOfRectangles.remove(listOfRectangles.size() - 1);
                frame.repaint();
            }
        }
    }

    class Listener implements ActionListener         //action listener for drawing more or less recs
    {
        final boolean more;

        public Listener(boolean more) {
            this.more = more;
        }

        public void actionPerformed(ActionEvent e) {
            paintRectangles(more);
        }
    }
}

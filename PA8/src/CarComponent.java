import javax.swing.*;
import java.awt.*;

public class CarComponent extends JComponent {

    Car car = new Car(0, 0);

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        car.draw(g2);
    }

    public void moveCarBy(int dx, int dy) {
        car.translate(1, 0);
        repaint();
    }

    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class P20_1 extends JFrame {

    int recNum;

    {
        recNum = 1;
    }

    Random random = new Random();

    public P20_1() {
        super();
        setLayout(new BorderLayout());
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 500, 1);
        slider.addChangeListener(arg0 -> {
            recNum = slider.getValue();
            P20_1.this.repaint();
        });

        JPanel panel = new JPanel() {

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);

                for (int i = 0; i < recNum; i++) {
                    int a = (int) Math.floor(random.nextDouble() * getWidth());
                    int b = (int) Math.floor(random.nextDouble() * getHeight());
                    int c = (int) Math.floor(random.nextDouble() * (getWidth() - a));
                    int d = (int) Math.floor(random.nextDouble() * (getHeight() - b));
                    g.drawRect(a, b, c, d);
                }
            }
        };

        add(slider, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            P20_1 r = new P20_1();
            r.setTitle("P20_1 Slider");
            r.setSize(new Dimension(550, 600));
            r.setVisible(true);
        });
    }
}

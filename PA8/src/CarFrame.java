import javax.swing.*;
import java.awt.event.ActionListener;

public class CarFrame extends JFrame {
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;

    public CarComponent scene;

    public CarFrame() {
        scene = new CarComponent();
        add(scene);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        ActionListener listener = new TimeListener();

        final int DELAY = 100;
        Timer t = new Timer(DELAY, listener);
        t.start();
    }
}

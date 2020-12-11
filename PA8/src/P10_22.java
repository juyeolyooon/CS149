import javax.swing.*;

public class P10_22 {
    public static void main(String[] args) {
        JFrame frame = new CarFrame();
        frame.setTitle("P10_22");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarComponent component = new CarComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}



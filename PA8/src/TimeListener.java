import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeListener implements ActionListener {
    private CarComponent scene;
    
    public void actionPerformed(ActionEvent e) {
        scene.moveCarBy(1, 1);
    }
}

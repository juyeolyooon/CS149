import javax.swing.JFrame;

public class E3_17 {

    public static void main(String[] args) {

        JFrame frame = new JFrame();            //object of JFrame

        frame.setSize(300,400);    //setting the size of the frame

        frame.setTitle("E3.17");               //title of the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //ability to close the frame by clicking on red cross

        Ellipse drawEllipse = new Ellipse();  //object of the class ellipse that has the drawing methods

        frame.add(drawEllipse);              //add the drawing to show on the frame

        frame.setVisible(true);             //making the frame visible when executed


    }


}
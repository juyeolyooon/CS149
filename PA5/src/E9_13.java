import java.awt.*;
/*
The java.awt.Rectangle class of the standard Java library does not supply a method
to compute the area or perimeter of a rectangle. Provide a subclass BetterRectangle of the
Rectangle class that has getPerimeter and getArea methods. Do not add any instance variables.
In the constructor, call the setLocation and setSize methods of the Rectangle class. Provide a
program that tests the methods that you supplied.
 */
public class E9_13 {
    public static void main(String[] args) {
        BetterRectangle r = new BetterRectangle(100000,1000000,3,4);
        int perimeter = r.getPerimeter();
        int area = r.getArea();
        System.out.println("Expected perimeter: 14, actual: " + perimeter);
        System.out.println("Expected area: 12, actual: " + area);
    }
}

class BetterRectangle extends Rectangle {
    /**
     * Construct a rectangle based on the position and size.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param w width
     * @param h height
     */
    public BetterRectangle(int x, int y, int w, int h) {
        setLocation(x, y);
        setSize(w, h);
    }

    /**
     * Get the perimeter of the rectangle
     * @return perimeter of the rectangle
     */
    public int getPerimeter() {
        return 2 * (width + height);
    }

    /**
     * Get the area of the rectangle
     * @return area of the rectangle
     */
    public int getArea() {
        return width * height;
    }

}

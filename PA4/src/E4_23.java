/*
Implement a class SodaCan whose constructor receives the height and diameter of the
soda can. Supply methods getVolume and getSurfaceArea. Supply a SodaCanTester class
that tests your class.
 */

// Works as SodaCanTester class in the problem
public class E4_23 {
    public static void main(String[] args) {
        SodaCan can = new SodaCan(5.0, 3.0);
        double volume = can.getVolume();
        double area = can.getSurfaceArea();
        System.out.format("Expected volume: 35.34, actual: %.2f;\n", volume);
        System.out.format("Expected area: 61.26, actual: %.2f.\n", area);
    }
}


class SodaCan {
    private double height, diameter;

    /**
     * Construct a soda can by the height and diameter of the soda can.
     *
     * @param h height of the soda can
     * @param d diameter of the soda can
     */
    public SodaCan(double h, double d) {
        this.height = h;
        this.diameter = d;
    }

    /**
     * Get the volume of the soda can
     *
     * @return volume of the soda can
     */
    public double getVolume() {
        double radius = diameter / 2.0;
        return Math.PI * radius * radius * height;
    }

    /**
     * Get the surface area of the soda can (including bottom and top)
     *
     * @return surface area of the soda can
     */
    public double getSurfaceArea() {
        return Math.PI * diameter * (diameter / 2.0 + height);
    }

}

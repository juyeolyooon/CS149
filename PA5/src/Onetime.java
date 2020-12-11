// use the same occursOn as the superclass, no need to override.
public class Onetime extends Appointment {
    public Onetime(String date, String description) {
        super(date, description);
    }

    /**
     * Print format: <type>: <description> made on <date>
     * @return String representation of Onetime objects
     */
    @Override
    public String toString() {
        return "Onetime:\t" + super.toString();
    }
}

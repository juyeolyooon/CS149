import java.time.LocalDate;

public class Monthly extends Appointment {
    public Monthly(String date, String description) {
        super(date, description);
    }

    /**
     * Check if a monthly appointment occurs.
     * (A monthly appointment occurs on the date the appointment was made,
     * and every month (same day of month after)
     * @param year
     * @param month
     * @param day
     * @return true if input date is on or after appointment date, and the day of month are same
     */
    @Override
    public boolean occursOn(int year, int month, int day) {
        LocalDate inputDate = LocalDate.of(year, month, day);
        return getDate().getDayOfMonth() == day && (inputDate.isEqual(getDate()) || inputDate.isAfter(getDate()));
    }

    /**
     * Print format: <type>: <description> made on <date>
     * @return String representation of Monthly objects
     */
    @Override
    public String toString() {
        return "Monthly:\t" + super.toString();
    }
}

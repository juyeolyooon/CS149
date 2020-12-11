import java.time.LocalDate;

public class Daily extends Appointment {
    public Daily(String date, String description) {
        super(date, description);
    }

    /**
     * Check if a daily appointment occurs.
     * (A daily appointment occurs on the date the appointment was made, and every day after)
     * @param year
     * @param month
     * @param day
     * @return true if the input date is the same as appointment date or after the appointment date
     */
    @Override
    public boolean occursOn(int year, int month, int day) {
        LocalDate inputDate = LocalDate.of(year, month, day);
        return inputDate.isEqual(getDate()) || inputDate.isAfter(getDate());
    }

    /**
     * Print format: <type>: <description> made on <date>
     * @return String representation of Daily objects
     */
    @Override
    public String toString() {
        return "Daily:\t" + super.toString();
    }
}

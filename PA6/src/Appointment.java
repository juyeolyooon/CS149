import java.time.LocalDate;

public class Appointment {
    private LocalDate date;
    private String description;

    public Appointment(String date, String description) {
        this.description = description;
        this.date = LocalDate.parse(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Check if the appointment occurs on the input date.
     * Same as onetime appointment
     *
     * @param year
     * @param month
     * @param day
     * @return true if the input date is the same date as appointment date
     */
    public boolean occursOn(int year, int month, int day) {
        return date.isEqual(LocalDate.of(year, month, day));
    }

    /**
     * Print format: <description> made on <date>
     *
     * @return String representation of Appointment objects
     */
    @Override
    public String toString() {
        return description + "\tmade on\t" + date;
    }
}

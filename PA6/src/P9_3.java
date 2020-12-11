import java.util.Scanner;

/*
Implement a superclass Appointment and subclasses Onetime, Daily, and Monthly. An
appointment has a description (for example, “see the dentist”) and a date. Write a method
occursOn(int year, int month, int day) that checks whether the appointment occurs on that date.
For example, for a monthly appointment, you must check whether the day of the month matches.
Then fill an array of Appointment objects with a mixture of appointments. Have the user enter a date
and print out all appointments that occur on that date.
 */
public class P9_3 {
    public static void main(String[] args) {
        Appointment appointment1 = new Onetime("2019-11-03", "Birthday");
        Appointment appointment2 = new Daily("2019-08-20", "Classes");
        Appointment appointment3 = new Monthly("2019-12-03", "dentist");
        Appointment appointment4 = new Daily("2019-12-30", "A");
        Appointment appointment5 = new Monthly("2020-01-01", "B");

        Appointment[] appointments = {appointment1, appointment2, appointment3, appointment4, appointment5};

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = scan.nextInt();
        System.out.print("Enter the month: ");
        int month = scan.nextInt();
        System.out.print("Enter the day: ");
        int day = scan.nextInt();

        printOccurs(appointments, year, month, day);
    }

    /**
     * Print the appointment(s) occur on the input date
     *
     * @param appointments array of appointments
     * @param year
     * @param month
     * @param day
     */
    public static void printOccurs(Appointment[] appointments, int year, int month, int day) {
        System.out.println("Appointment(s) on " + year + "-" + month + "-" + day + ": ");
        for (Appointment app : appointments) {
            if (app.occursOn(year, month, day))
                System.out.println(app);
        }
    }
}


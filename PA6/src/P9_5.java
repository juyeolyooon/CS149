// import PA5.*; // Use Appointment and its subclasses from PA6

import java.io.*;
import java.util.*;

/*
Improve the appointment book program of PA6 Exercises P9.3 and P9.4 by
letting the user save the appointment data to a file and reload the data from a file.
 */
public class P9_5 {

    public static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String file = "appointments.txt";
        boolean done = false;
        try {
            while (!done) {
                System.out.print("Enter option (a - add and save an appointment, l - load appointments, c - check, q - quit): ");
                Scanner in = new Scanner(System.in);
                char option = in.nextLine().toLowerCase().charAt(0);
                switch (option) {
                    case 'a':
                        System.out.print("Enter the type (o - Onetime, d - Daily, or m - Monthly): ");
                        char type = in.nextLine().toLowerCase().charAt(0);
                        System.out.print("Enter the date (yyyy-mm-dd): ");
                        String date = in.nextLine();
                        System.out.print("Enter the description: ");
                        String description = in.nextLine();
                        Appointment appointment = getAppointment(type, date, description);
                        if (appointment != null)
                            save(file, appointment);
                        break;
                    case 'l':
                        appointments = load(file);
                        break;
                    case 'c':
                        System.out.print("Enter the year: ");
                        int year = in.nextInt();
                        System.out.print("Enter the month: ");
                        int month = in.nextInt();
                        System.out.print("Enter the day: ");
                        int day = in.nextInt();
                        Appointment[] apps = new Appointment[appointments.size()];
                        P9_3.printOccurs(appointments.toArray(apps), year, month, day); // Use method from PA6
                        break;
                    case 'q':
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Get an appointment based on type, date and description
     *
     * @param type        o = onetime, d = daily, m = monthly
     * @param date        format: yyyy-mm-yy
     * @param description
     */
    public static Appointment getAppointment(char type, String date, String description) {
        Appointment app = null;
        try {
            switch (type) {
                case 'o':
                    app = new Onetime(date, description);
                    break;
                case 'd':
                    app = new Daily(date, description);
                    break;
                case 'm':
                    app = new Monthly(date, description);
                    break;
                default:
                    throw new IllegalStateException("Invalid type: " + type);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nFail to add appointment. Please use yyyy-mm-dd format");
        }
        return app;
    }

    /**
     * Save the appointment into file
     *
     * @param file        output file
     * @param appointment
     * @throws IOException
     */
    public static void save(String file, Appointment appointment) throws IOException {
        appointments.add(appointment);
        FileWriter writer = new FileWriter(file, true);
        PrintWriter print = new PrintWriter(writer);
        print.println(appointment);
        print.close();
    }

    /**
     * Load data from file.
     *
     * @param fileName the name of file
     * @throws FileNotFoundException
     */
    public static ArrayList<Appointment> load(String fileName) throws FileNotFoundException {
        ArrayList<Appointment> apps = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] info = line.split("\t");
                char type = line.toLowerCase().charAt(0);
                String date = info[3];
                String description = info[1];
                Appointment app = getAppointment(type, date, description);
                apps.add(app);
            }
            System.out.println(fileName + " loaded.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return apps;
    }
}


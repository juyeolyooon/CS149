import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/*
Reimplement Exercise E15.4 so that the keys of the map are objects of class Student.
A student should have a first name, a last name, and a unique integer ID.
For grade changes and removals, lookup should be by ID. The printout should be sorted by last name.
If two students have the same last name, then use the first name as a tie breaker.
If the first names are also identical, then use the integer ID.
 */
public class P15_2 {
    // use TreeMap to sort Students
    static TreeMap<Student, String> grades = new TreeMap<>();
    static HashMap<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {
        boolean done = false;
        try {
            while (!done) {
                System.out.print("Select an option: a for add a student, " +
                        "r for remove a student, " +
                        "\nm for modify a grade, " +
                        "p for print all grades, " +
                        "q to quit: ");
                Scanner scan = new Scanner(System.in);
                char choice = scan.nextLine().toLowerCase().charAt(0);
                switch (choice) {
                    case 'a':
                        System.out.print("Enter student first name: ");
                        String firstName = scan.nextLine();
                        System.out.print("Enter student last name: ");
                        String lastName = scan.nextLine();
                        System.out.print("Enter student ID: ");
                        int ID = scan.nextInt();
                        Student student = new Student(firstName, lastName, ID);
                        System.out.print("Enter student grade: ");
                        String grade = scan.next();
                        add(student, grade);
                        break;
                    case 'r':
                        System.out.print("Enter student ID: ");
                        ID = scan.nextInt();
                        remove(ID);
                        break;
                    case 'm':
                        System.out.print("Enter student ID: ");
                        ID = scan.nextInt();
                        System.out.print("Enter the new grade: ");
                        grade = scan.next();
                        modify(ID, grade);
                        break;
                    case 'p':
                        print();
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
     * Add a student (only if the student does not exist)
     *
     * @param student
     * @param grade
     */
    public static void add(Student student, String grade) {
        int ID = student.getID();
        Student s = students.get(ID);
        if (s != null) {
            if (s.equals(student)) System.out.println("Student exists, fail to add.");
            else System.out.println("ID exists, fail to add. Please choose other ID");
        } else {
            students.put(ID, student);
            grades.put(student, grade);
        }
    }

    /**
     * Remove a student based on studentID
     *
     * @param studentID
     */
    public static void remove(int studentID) {
        Student student = students.get(studentID);
        if (student == null) System.out.println("Student does not exist. Fail to remove.");
        else {
            students.remove(studentID);
            grades.remove(student);
        }
    }

    /**
     * Modify the student's grade based on student ID
     *
     * @param studentID
     * @param newGrade
     */
    public static void modify(int studentID, String newGrade) {
        Student student = students.get(studentID);
        if (student == null) System.out.println("Student does not exist. Fail to modify.");
        else grades.put(student, newGrade);
    }

    /**
     * Print all result.
     */
    public static void print() {
        for (Student student : grades.keySet())
            System.out.println(student + ": " + grades.get(student));
    }

}

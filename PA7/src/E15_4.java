import java.util.*;
/*
Write a program that keeps a map in which both keys and values
are strings—the names of students and their course grades.
Prompt the user of the program to add or remove students,
to modify grades, or to print all grades.
 */
public class E15_4 {
    // use TreeMap for sorting
    static TreeMap<String, String> grades = new TreeMap<>();
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
                        System.out.print("Enter student name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter student grade: ");
                        String grade = scan.nextLine();
                        add(name, grade);
                        break;
                    case 'r':
                        System.out.print("Enter student name: ");
                        name = scan.nextLine();
                        remove(name);
                        break;
                    case 'm':
                        System.out.print("Enter student name: ");
                        name = scan.nextLine();
                        System.out.print("Enter the new grade: ");
                        grade = scan.nextLine();
                        modify(name, grade);
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
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Add a student (only if the student does not exist)
     * @param student
     * @param grade
     */
    public static void add(String student, String grade){
        if (grades.containsKey(student)) System.out.println("Student exists. Fail to add");
        else grades.put(student, grade);
    }

    /**
     * Remove a student
     * @param student
     */
    public static void remove(String student){
        if(!grades.containsKey(student)) System.out.println("Student does not exist");
        else grades.remove(student);
    }

    /**
     * Modify the student's grade
     * @param student
     * @param newGrade
     */
    public static void modify(String student, String newGrade){
        if(!grades.containsKey(student)) System.out.println("Student does not exist");
        else grades.put(student, newGrade);
    }

    /**
     * Print all result.
     */
    public static void print(){
        for(String student:grades.keySet())
            System.out.println(student+": " + grades.get(student));
    }
}

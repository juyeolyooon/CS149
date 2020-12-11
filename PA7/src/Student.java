// implement Comparable for sorting
public class Student implements Comparable<Student> {
    private final String firstName, lastName;
    private final int ID;

    public Student(String firstName, String lastName, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getID() {
        return ID;
    }

    /**
     * Sorted by last name.
     * If two others have the same last name, then use the first name as a tie breaker.
     * If the first names are also identical, then use the integer ID.
     *
     * @param other the student to compare with
     * @return > 0 means this > other; == 0 means this == other; < 0 means this < other.
     */
    @Override
    public int compareTo(Student other) {
        if (this.lastName.equals(other.lastName)) { // check first name if last name same
            if (this.firstName.equals(other.firstName)) // check id if first and last name both same
                return this.ID - other.ID;
            else return this.firstName.compareTo(other.firstName);
        } else return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName + " (ID=" + ID + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student other = (Student) o;
        return ID == other.ID && firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        return ID;
    }
}

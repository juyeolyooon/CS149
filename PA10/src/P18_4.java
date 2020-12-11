import java.util.ArrayList;

/*
Make the Measurable interface from Chapter 10 into a generic class (Measurable2.java).
Provide a static method that returns the largest element of an ArrayList<T>,
provided that the elements are instances of Measurable<T>.
Be sure to return a value of type T.
 */
public class P18_4 {
    public static <T extends Measurable2<T>> T print(ArrayList<T> a) {
        T max = a.get(0);
        for (T t : a) {
            if (t.getMeasurable() > max.getMeasurable())
                max = t;
        }
        return max;
    }
}

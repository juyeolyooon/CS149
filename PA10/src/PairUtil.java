/*
Write a static generic method PairUtil.minmax that computes the minimum and maximum
elements of an array of type T and returns a pair containing the minimum and maximum value.
Require that the array elements implement the Measurable interface of Chapter 10.
 */
public class PairUtil {
    public static <T extends Measurable> Pair<T, T> minmax(T[] a) {
        T max = a[0];
        T min = a[0];
        for (T t : a) {
            if (t.getMeasure() > max.getMeasure()) max = t;
            else if (t.getMeasure() <= min.getMeasure()) min = t;
        }
        return new Pair<T, T>(min, max);
    }
}

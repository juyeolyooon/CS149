import java.util.Scanner;

/*
Compute the alternating sum of all elements in an array.
 */
public class E7_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an array of integers, use space to separate elements: ");
        try {
            String[] input = scan.nextLine().split(" ");
            int[] numbers = new int[input.length];
            // get input array
            for (int i = 0; i < numbers.length; i++) numbers[i] = Integer.parseInt(input[i]);
            // compute and output result
            int sum = numbers[0];
            System.out.print(numbers[0]);
            for (int i = 1; i < numbers.length; i++) {
                if (i % 2 == 0) {
                    sum += numbers[i];
                    System.out.print(" + " + numbers[i]);
                }
                else {
                    sum -= numbers[i];
                    System.out.print(" - " + numbers[i]);
                }
            }
            System.out.println(" = " + sum);
        } catch (
                Exception e) {
            System.out.println("Invalid input, program terminated.");
        }
    }
}

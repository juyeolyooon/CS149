import java.util.Scanner;

/*
Write a program that reads two times in military format (0900, 1730) and
prints the number of hours and minutes between the two times.
 */
public class E4_17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Please enter your first time: ");
            int firstTime = scan.nextInt();
            System.out.print("Please enter your second time: ");
            int secondTime = scan.nextInt();
            int firstHour = firstTime / 100;
            int firstMin = firstTime % 100;
            int secondHour = secondTime / 100;
            int secondMin = secondTime % 100;

            if (secondHour < firstHour || (secondHour == firstHour && secondMin < firstMin)) {
                secondHour += 24;
            }

            int diffHour = secondHour - firstHour;
            int diffMin = secondMin - firstMin;

            if (diffMin < 0) {
                diffHour -= 1;
                diffMin += 60;
            }

            System.out.print((diffHour) + " Hours " + (diffMin) + " Minutes");

        } catch (Exception e){
            System.out.println("Invalid input, program terminated!");
        }
    }
}

import java.util.Scanner;
/*
Write a program that takes user input describing a playing card in the following shorthand
notation:
A Ace
2 ... 10 Card values
J Jack
Q Queen
K King
D Diamonds
H Hearts
S Spades
C Clubs
Your program should print the full description of the card.
 */
public class E5_19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the card notation: ");
        String input = scan.nextLine().toUpperCase();
    }
}

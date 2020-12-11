import java.util.Scanner;

/*
Write a program that prompts the user for an integer and then prints out all prime numbers up to that integer.
 */
// Works as the PrimePrinter class in the problem.
public class P6_5 {
    //
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        try{
            int input = scan.nextInt();
            PrimeGenerator p = new PrimeGenerator();
            int prime = p.nextPrime();
            while(prime < input){
                System.out.print(prime + " ");
                prime = p.nextPrime();
            }
        } catch (Exception e){
            System.out.println("Invalid input, program terminated.");
        }
    }
}

class PrimeGenerator {
    int current;

    // Constructor
    public PrimeGenerator() {
        current = 1;
    }

    // return the next prime number
    public int nextPrime() {

        current++;
        // loop that increment current value until it becomes a prime number.
        while (!isPrime(current)){
            current++;
        }
        return current;
    }

    // return true if input is prime number.
    public static boolean isPrime(int n) {
        // definition of prime number: if a number is not divisible by any number between 1 and the number, it is prime number
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

package recursion;

// Recursive implementation of n! (n-factorial) calculation
public class Factorial {

    public static int factorial(int n) {
        // Base case: n = 0 or 1
        if (n <= 1) {
            System.out.println(n);
            return 1;
        }
        System.out.print(n + "*");
        // Recursive case: n! = n * (n - 1)!
        // Nos regresa el actual por el factorial siguiente ej: 5 * 4! despues 4 * 3! asi hasta llegar al 1 que regresa 1 y se devuelven las llamadas
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}

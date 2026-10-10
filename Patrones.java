
import java.util.Scanner;

public class Patrones {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresa un numero positivo:");
        int n = scan.nextInt();

        if (n <= 0) {
            System.out.println("Error: n debe ser positivo.");
            return;
        }

        // -------------------------
        // PATRON A
        // -------------------------

        System.out.println("\nPatron A:");

        for (int i = 1; i <= n; i++) {

            System.out.print("1");

            for (int j = 1; j < i; j++) {
                System.out.print(" *");
            }

            if (i > 1) {
                System.out.print(" 1");
            }

            System.out.println();
        }

        // -------------------------
        // PATRON B
        // -------------------------

        System.out.println("\nPatron B:");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // -------------------------
        // PATRON C
        // -------------------------

        System.out.println("\nPatron C:");

        // Parte que crece
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Parte que disminuye
        for (int i = n - 1; i >= 1; i--) {

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // -------------------------
        // PATRON D
        // -------------------------

        System.out.println("\nPatron D:");

        for (int i = 1; i <= n; i++) {

            // Parte ascendente
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // Parte descendente
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}


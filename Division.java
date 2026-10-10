import java.util.Scanner;

public class Division {

    static String binario8(int numero) {

        int valor = numero & 0xFF;
        String binario = "";

        for (int i = 7; i >= 0; i--) {
            int bit = (valor >> i) & 1;
            binario = binario + bit;
        }

        return binario;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el primer numero:");
        int a = scan.nextInt();

        System.out.println("Ingrese el segundo numero:");
        int b = scan.nextInt();

        if (a < -128 || a > 127 || b < -128 || b > 127) {
            System.out.println("Error: los numeros deben estar entre -128 y 127.");
            return;
        }

        if (b == 0) {
            System.out.println("Error: no se puede dividir entre cero.");
            return;
        }

        // Caso especial:
        // -128 / -1 = 128, que no cabe en 8 bits con signo
        if (a == -128 && b == -1) {
            System.out.println("Desbordamiento");
            return;
        }

        int cociente = a / b;
        int residuo = a % b;

        System.out.println(binario8(a) + "  " + a);
        System.out.println(binario8(b) + "  " + b);

        System.out.println("Cociente:");
        System.out.println(binario8(cociente) + "  " + cociente);

        System.out.println("Residuo:");
        System.out.println(binario8(residuo) + "  " + residuo);
    }
}


import java.util.Scanner;

public class Suma {

    // Convierte un entero a su representación de 8 bits
    static String binario8(int numero) {

        int valor = numero & 0xFF;
        String binario = "";

        for (int i = 7; i >= 0; i--) {
            int bit = (valor >> i) & 1;
            binario = binario + bit;
        }

        return binario;
    }

    // Suma bit por bit usando acarreo
    static int sumar8(int a, int b) {

        int acarreo = 0;
        int resultado = 0;

        for (int i = 0; i < 8; i++) {

            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;

            int suma = bitA + bitB + acarreo;

            int bitResultado = suma % 2;
            acarreo = suma / 2;

            resultado = resultado | (bitResultado << i);
        }

        // Convertimos el resultado de 8 bits a entero con signo
        if ((resultado & 128) != 0) {
            resultado = resultado - 256;
        }

        return resultado;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el primer numero:");
        int a = scan.nextInt();

        System.out.println("Ingrese el segundo numero:");
        int b = scan.nextInt();

        if (a < -128 || a > 127 || b < -128 || b > 127) {
            System.out.println("Error: los numreos deben estar entre -128 y 127.");
            return;
        }

        int resultado = sumar8(a, b);

        System.out.println(binario8(a) + "  " + a);
        System.out.println(binario8(b) + "  " + b);
        System.out.println("----------------");

        boolean overflow =
                (a >= 0 && b >= 0 && resultado < 0)
                        ||
                        (a < 0 && b < 0 && resultado >= 0);

        if (overflow) {
            System.out.println("Desbordamiento");
        } else {
            System.out.println(binario8(resultado) + "  " + resultado);
        }
    }
}

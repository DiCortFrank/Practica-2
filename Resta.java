import java.util.Scanner;

public class Resta {

    static String binario8(int numero) {

        int valor = numero & 0xFF;
        String binario = "";

        for (int i = 7; i >= 0; i--) {
            int bit = (valor >> i) & 1;
            binario = binario + bit;
        }

        return binario;
    }

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

        if ((resultado & 128) != 0) {
            resultado = resultado - 256;
        }

        return resultado;
    }

    // Cambia el signo usando complemento a 2
    static int complementoDos(int numero) {

        int valor = numero & 0xFF;

        // Invertir bits
        valor = (~valor) & 0xFF;

        // Sumar 1
        valor = (valor + 1) & 0xFF;

        if ((valor & 128) != 0) {
            valor = valor - 256;
        }

        return valor;
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

        // A - B = A + (-B)
        int menosB = complementoDos(b);

        int resultado = sumar8(a, menosB);

        System.out.println(binario8(a) + "  " + a);
        System.out.println(binario8(b) + "  " + b);
        System.out.println("----------------");

        boolean overflow =
                (a >= 0 && b < 0 && resultado < 0)
                        ||
                        (a < 0 && b >= 0 && resultado >= 0);

        if (overflow) {
            System.out.println("Desbordamiento");
        } else {
            System.out.println(binario8(resultado) + "  " + resultado);
        }
    }
}

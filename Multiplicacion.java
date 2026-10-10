import java.util.Scanner;

public class Multiplicacion {

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

        // Obtenemos las magnitudes
        int multiplicando;

        if (a < 0) {
            multiplicando = -a;
        } else {
            multiplicando = a;
        }

        int multiplicador;

        if (b < 0) {
            multiplicador = -b;
        } else {
            multiplicador = b;
        }

        int resultado = 0;

        // Multiplicación binaria
        while (multiplicador > 0) {

            // Revisamos el último bit
            if ((multiplicador & 1) == 1) {
                resultado = resultado + multiplicando;
            }

            // Desplazar multiplicando a la izquierda
            multiplicando = multiplicando << 1;

            // Desplazar multiplicador a la derecha
            multiplicador = multiplicador >> 1;
        }

        // Determinar el signo
        if ((a < 0 && b >= 0) || (a >= 0 && b < 0)) {
            resultado = -resultado;
        }

        System.out.println(binario8(a) + "  " + a);
        System.out.println(binario8(b) + "  " + b);
        System.out.println("----------------");

        if (resultado < -128 || resultado > 127) {
            System.out.println("Desbordamiento");
        } else {
            System.out.println(binario8(resultado) + "  " + resultado);
        }
    }
}

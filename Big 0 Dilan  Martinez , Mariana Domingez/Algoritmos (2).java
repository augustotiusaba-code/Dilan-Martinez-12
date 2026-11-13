public class Main {

    public static void main(String[] args) {
        int[] numeros = {10, 20, 30};

        System.out.println("--- Ejercicio 1: O(1) ---");
        imprimirInicio(numeros);

        System.out.println("--- Ejercicio 2: O(n) ---");
        recorrerArreglo(numeros);

        System.out.println("--- Ejercicio 3: O(n^2) ---");
        generarParejas(numeros);

        System.out.println("--- Ejercicio 4: O(log n) ---");
        dividirEntreDos(16);

        System.out.println("--- Ejercicio 5: O(n log n) ---");
        cicloConDivisiones(8);
        System.out.println("(no imprime nada, solo hace el trabajo)");

        System.out.println("--- Experimento: tiempos ---");
        int[] valoresN = {100, 1_000, 5_000, 10_000};
        System.out.println("n\tO(n) ns\tO(n^2) ns");
        for (int tam : valoresN) {
            long t0 = System.nanoTime();
            conteoLineal(tam);
            long duracionLineal = System.nanoTime() - t0;

            long t1 = System.nanoTime();
            conteoCuadratico(tam);
            long duracionCuadratica = System.nanoTime() - t1;

            System.out.println(tam + "\t" + duracionLineal + "\t" + duracionCuadratica);
        }
    }

    // Ejercicio 1: acceso directo a una posicion
    public static void imprimirInicio(int[] arr) {
        System.out.println(arr[0]);
    }

    // Ejercicio 2: un solo recorrido
    public static void recorrerArreglo(int[] arr) {
        for (int valor : arr) {
            System.out.println(valor);
        }
    }

    // Ejercicio 3: dos ciclos anidados
    public static void generarParejas(int[] arr) {
        for (int a : arr) {
            for (int b : arr) {
                System.out.println(a + " - " + b);
            }
        }
    }

    // Ejercicio 4: el valor se reduce a la mitad en cada vuelta
    public static void dividirEntreDos(int n) {
        while (n > 1) {
            n /= 2;
            System.out.println(n);
        }
    }

    // Ejercicio 5: ciclo externo con reduccion a la mitad adentro
    public static void cicloConDivisiones(int n) {
        for (int k = 0; k < n; k++) {
            int temp = n;
            while (temp > 1) {
                temp /= 2;
            }
        }
    }

    // Experimento: Algoritmo A (lineal)
    public static long conteoLineal(int n) {
        long total = 0;
        for (int k = 0; k < n; k++) {
            total++;
        }
        return total;
    }

    // Experimento: Algoritmo B (cuadratico)
    public static long conteoCuadratico(int n) {
        long total = 0;
        for (int k = 0; k < n; k++) {
            for (int m = 0; m < n; m++) {
                total++;
            }
        }
        return total;
    }
}

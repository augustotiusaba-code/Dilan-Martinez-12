public class Main {

    public static void main(String[] args) {

        // VARIABLES PRIMITIVAS
        int semestre = 3;
        double notaMinima = 3.0;
        boolean activo = true;

        // CREACIÓN DE OBJETOS
        Estudiante estudiante1 =
                new Estudiante("Laura", 20, 4.2);

        Estudiante estudiante2 =
                new Estudiante("Carlos", 22, 3.8);

        // DOS REFERENCIAS AL MISMO OBJETO
        Estudiante copia = estudiante1;
        copia.setPromedio(4.8);

        System.out.println("Promedio estudiante1: "
                + estudiante1.getPromedio());
        System.out.println("Promedio copia: "
                + copia.getPromedio());

        // LLAMADA A MÉTODO
        procesarEstudiante(estudiante2);

        // REFERENCIAS NULL
        estudiante1 = null;
        copia = null;

        // Solicitud a la JVM para considerar GC
        System.gc();

        System.out.println("Programa finalizado.");

        // ===== RETO: PRODUCTOS =====
        retoProductos();
    }

    public static void procesarEstudiante(Estudiante estudiante) {
        int puntosExtra = 1;
        double nuevoPromedio = estudiante.getPromedio() + 0.2;
        estudiante.setPromedio(nuevoPromedio);
        estudiante.mostrarDatos();
        System.out.println("Puntos extra: " + puntosExtra);
    }

    public static void retoProductos() {
        System.out.println("\n--- RETO: PRODUCTOS ---");

        // a) Tres productos
        Producto p1 = new Producto(101, "Teclado", 80000);
        Producto p2 = new Producto(102, "Mouse", 45000);
        Producto p3 = new Producto(103, "Monitor", 600000);

        // b) Segunda referencia al primer producto
        Producto p1Alias = p1;

        // c) Modificar precio mediante la segunda referencia
        p1Alias.setPrecio(95000);

        // d) Comprobar el cambio mediante la primera referencia
        System.out.println("Precio via p1: " + p1.getPrecio());
        System.out.println("Precio via p1Alias: " + p1Alias.getPrecio());

        // e-h) Método actualizarPrecio (usar Step Into aquí)
        actualizarPrecio(p2, 50000);
        p2.mostrarDatos();
        p3.mostrarDatos();

        // i) null a ambas referencias del primer producto
        p1 = null;
        p1Alias = null;
        System.gc();
        System.out.println("p1 y p1Alias ahora son null.");
    }

    public static void actualizarPrecio(Producto producto, double nuevoPrecio) {
        double precioAnterior = producto.getPrecio();
        producto.setPrecio(nuevoPrecio);
        System.out.println("Precio actualizado de " + precioAnterior
                + " a " + producto.getPrecio());
    }
}

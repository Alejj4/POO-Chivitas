package Punto3;

public class Punto3Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("978-111", "Cien Años de Soledad", "Gabriel García Márquez", 471);
        Libro libro2 = new Libro("978-222", "Don Quijote de la Mancha", "Miguel de Cervantes", 863);
        Libro libro3 = new Libro("978-333", "El Aleph", "Jorge Luis Borges", 146);

        // 4. Crear dos bibliotecas
        Biblioteca biblioCentral = new Biblioteca("Biblioteca Central", "Av. Corrientes 1234");
        Biblioteca biblioNacional = new Biblioteca("Biblioteca Nacional", "Calle San Martín 500");

        // 2. Pasar los objetos Libros al método agregarLibro
        biblioCentral.agregarLibro(libro1);
        biblioCentral.agregarLibro(libro2);
        biblioCentral.agregarLibro(libro3);

        // 3. Probar catálogo y búsquedas
        System.out.println("--- Catálogo inicial ---");
        biblioCentral.mostrarCatalogo();

        System.out.println("\n--- Métodos de consulta ---");
        System.out.println("Cantidad de libros: " + biblioCentral.contarLibros());
        System.out.println("Libro más extenso: " + biblioCentral.obtenerLibroMasExtenso());

        // 4. Trasladar un libro de una biblioteca a otra
        System.out.println("\n--- Traslado de libro ---");
        String isbnBuscar = "978-222";
        Libro libroAEnviar = biblioCentral.buscarPorIsbn(isbnBuscar);

        if (libroAEnviar != null && biblioCentral.retirarLibro(isbnBuscar)) {
            biblioNacional.agregarLibro(libroAEnviar);
            System.out.println("El libro '" + libroAEnviar.getTitulo() + "' se trasladó con éxito.");
        }

        // Estado final de ambas bibliotecas
        System.out.println("\n--- Estado final Biblioteca Central ---");
        biblioCentral.mostrarCatalogo();

        System.out.println("\n--- Estado final Biblioteca Nacional ---");
        biblioNacional.mostrarCatalogo();

    }
}

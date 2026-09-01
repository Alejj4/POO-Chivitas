package Punto3;

public class Punto3Main {
    static void main() {
        Libros libro1 = new Libros("978-111", "Cien Años de Soledad", "Gabriel García Márquez", 471);
        Libros libro2 = new Libros("978-222", "Don Quijote de la Mancha", "Miguel de Cervantes", 863);
        Libros libro3 = new Libros("978-333", "El Aleph", "Jorge Luis Borges", 146);

        // 4. Crear dos bibliotecas
        Bliblioteca biblioCentral = new Bliblioteca("Biblioteca Central", "Av. Corrientes 1234");
        Bliblioteca biblioNacional = new Bliblioteca("Biblioteca Nacional", "Calle San Martín 500");

        // 2. Pasar los objetos Libros al método agregarLibro
        biblioCentral.agregarLibro(libro1);
        biblioCentral.agregarLibro(libro2);
        biblioCentral.agregarLibro(libro3);

        // 3. Probar catálogo y búsquedas
        System.out.println("--- Catálogo inicial ---");
        biblioCentral.obtenerCatalogo();

        System.out.println("\n--- Métodos de consulta ---");
        System.out.println("Cantidad de libros: " + biblioCentral.contarLibros());
        System.out.println("Libro más extenso: " + biblioCentral.obtenerLibrosMasExtenso());

        // 4. Trasladar un libro de una biblioteca a otra
        System.out.println("\n--- Traslado de libro ---");
        String isbnBuscar = "978-222";
        Libros libroAEnviar = biblioCentral.buscarPorIsbn(isbnBuscar);

        if (libroAEnviar != null && biblioCentral.retirarLibro(isbnBuscar)) {
            biblioNacional.agregarLibro(libroAEnviar);
            System.out.println("El libro '" + libroAEnviar.getTitulo() + "' se trasladó con éxito.");
        }

        // Estado final de ambas bibliotecas
        System.out.println("\n--- Estado final Biblioteca Central ---");
        biblioCentral.obtenerCatalogo();

        System.out.println("\n--- Estado final Biblioteca Nacional ---");
        biblioNacional.obtenerCatalogo();

    }
}

package Punto3;

public class Libros {
    private String ISBN;
    private String titulo;
    private String autor;
    private int cantidadPaginas;

    public Libros(String ISBN,String titulo, String autor,int cantidadPaginas) {
        this.ISBN = ISBN;
        this.autor = autor;
        this.titulo = titulo;
        this.cantidadPaginas = cantidadPaginas;

    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}

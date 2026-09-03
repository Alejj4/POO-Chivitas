package Punto3;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private String Direccion;
    private ArrayList<Libro> listaLibros;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        Direccion = direccion;
        this.listaLibros = new ArrayList<>();
    }

    public boolean agregarLibro(Libro libro){
        if(libro !=null){
          this.listaLibros.add(libro);
            return true;
        }
        else{
            return false;
        }
    }

    public Libro buscarPorIsbn(String ISBN){
            for (Libro buscador: listaLibros){
                String valorBusqueda=buscador.getISBN();
                if(valorBusqueda.equalsIgnoreCase(ISBN)){
                    return buscador;

                }

            }

            System.out.println("El libro no esta en la biblioteca");
        return null;

    }

    public boolean retirarLibro(String ISBN){
        Libro retiroLibro = buscarPorIsbn( ISBN);
        if (retiroLibro !=null){
            listaLibros.remove(retiroLibro);
            return true;
        }
        else{
            return false;
        }

    }
    public int contarLibros() {
        return listaLibros.size();
    }

    public Libro obtenerLibroMasExtenso(){
        if (listaLibros.size()==0){
            System.out.println("No hay libros en la libreria");
            return null;
        }
        else{
            Libro masLargo = this.listaLibros.get(0);
            for (Libro seguimiento: listaLibros){
                if(seguimiento.getCantidadPaginas()>masLargo.getCantidadPaginas()){
                    masLargo= seguimiento;
                }

            }
            return masLargo;
        }
    }

    public void mostrarCatalogo(){
        if(listaLibros.size()==0){
            System.out.println("No hay libros en la libreria");
        }
        else{
            for (Libro catalogo: listaLibros){
                System.out.println(catalogo);
            }

        }

    }



}

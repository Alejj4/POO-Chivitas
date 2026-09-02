package Punto3;
import java.util.ArrayList;

public class Bliblioteca {
    private String nombre;
    private String Direccion;
    private ArrayList<Libros> listaLibros;

    public Bliblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        Direccion = direccion;
        this.listaLibros = new ArrayList<>();
    }

    public boolean agregarLibro(Libros libro){
        if(libro !=null){
          this.listaLibros.add(libro);
            return true;
        }
        else{
            return false;
        }
    }

    public Libros buscarPorIsbn(String ISBN){
            for (Libros buscador: listaLibros){
                String valorBusqueda=buscador.getISBN();
                if(valorBusqueda.equalsIgnoreCase(ISBN)){
                    return buscador;

                }

            }

            System.out.println("El libro no esta en la biblioteca");
        return null;

    }

    public boolean retirarLibro(String ISBN){
        Libros retiroLibro = buscarPorIsbn( ISBN);
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

    public Libros obtenerLibrosMasExtenso(){
        if (listaLibros.size()==0){
            System.out.println("No hay libros en la libreria");
            return null;
        }
        else{
            Libros masLargo = this.listaLibros.get(0);
            for (Libros seguimiento: listaLibros){
                if(seguimiento.getCantidadPaginas()>masLargo.getCantidadPaginas()){
                    masLargo= seguimiento;
                }

            }
            return masLargo;
        }
    }

    public void obtenerCatalogo(){
        if(listaLibros.size()==0){
            System.out.println("No hay libros en la libreria");
        }
        else{
            for (Libros catalogo: listaLibros){
                System.out.println(catalogo);
            }

        }

    }



}

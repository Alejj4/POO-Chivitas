package Punto2;

public class Equipo {
    private String nombre;
    private String categoria;
    private Entrenador entrenadorActual;

    public Equipo(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.entrenadorActual = null;
    }

    public void asignarEntrenador(Entrenador asignarEntrenador){

        if(asignarEntrenador== null){
            System.out.println("No puede ingresar un entrenador nulo--------------------------------------------");
        }
        else if(this.entrenadorActual == null){
            this.entrenadorActual= asignarEntrenador;

        }
        else{
            System.out.println("Ya exsiste un entrenador asignado actualmente--------------------------------------------");

        }
    }

    public void cambiarEntrenador(Entrenador cambiarEntrenador){
        if(cambiarEntrenador== null){
            System.out.println("No puede ingresar un entrenador nulo--------------------------------------------");

        }
        else if (this.entrenadorActual == null) {
            System.out.println("No existe un entrenador asignado actualmente.");}
        else{
            this.entrenadorActual = cambiarEntrenador;

        }

    }

    public Entrenador buscarEntrenador() {
        if(entrenadorActual== null){
            System.out.println("No exsiste un entrenador asignado actualmente--------------------------------------------");
            return null;


        }
        else{
            return  entrenadorActual;
        }
    }


    public void mostrarInfomacion() {
        System.out.println("Equipo" +
                "nombre='" + nombre  +
                ", categoria='" + categoria +
                ", entrenadorActual=" + entrenadorActual);
    }


}

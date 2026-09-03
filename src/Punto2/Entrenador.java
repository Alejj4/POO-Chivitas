package Punto2;

public class Entrenador {
    private int DNI;
    private String nombre;
    private int experiencia;

    public Entrenador(int DNI, String nombre, int experiencia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.experiencia = experiencia;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "DNI=" + DNI +
                ", nombre='" + nombre + '\'' +
                ", experiencia=" + experiencia +
                '}';
    }
}

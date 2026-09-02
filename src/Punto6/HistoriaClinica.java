package Punto6;

import java.util.ArrayList;
import java.util.List;

public class HistoriaClinica {
    private int numeroHistoria;
    private List<Consulta> consultasRegistradas;
    private int cantidadConsultas;
    private int capacidadMaxima;
    private String fechaCreacion;

    public HistoriaClinica(int numeroHistoria, String fechaCreacion) {
        this(numeroHistoria, fechaCreacion, 5);
    }

    public HistoriaClinica(int numeroHistoria, String fechaCreacion, int capacidadMaxima) {
        this.numeroHistoria = numeroHistoria;
        this.fechaCreacion = fechaCreacion;
        this.capacidadMaxima = capacidadMaxima;
        this.consultasRegistradas = new ArrayList<>();
        this.cantidadConsultas = 0;
    }

    public boolean agregarConsulta(Consulta consulta){
        if (consulta != null && this.consultasRegistradas.size() < this.capacidadMaxima) {
            consultasRegistradas.add(consulta);
            this.cantidadConsultas = this.consultasRegistradas.size();
            System.out.println("Se agrego la consulta");
            return true;
        } else {
            System.out.println("No se pudo agregar la consulta: capacidad disponible agotada (" + this.capacidadMaxima + " max).");
            return false;
        }
    }

    public List<Consulta> buscarPorFecha(String fecha){
        List<Consulta> encontradas = new ArrayList<>();
        for (Consulta consul : consultasRegistradas){
            if(consul.getFechaAtencion().equalsIgnoreCase(fecha)){
                encontradas.add(consul);
            }
        }
        return encontradas;
    }

    public int ConsultasSeguimiento() {
        int contador = 0;
        for (Consulta consul : consultasRegistradas) {
            if (consul.requiereSeguimiento()) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularCostoPromedio() {
        if (consultasRegistradas == null || consultasRegistradas.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Consulta consul : consultasRegistradas) {
            suma += consul.getCosto();
        }
        return suma / consultasRegistradas.size();
    }

    public Consulta obtenerConsultaMayorCosto() {
        if (consultasRegistradas == null || consultasRegistradas.isEmpty()) {
            return null;
        }
        Consulta mayor = consultasRegistradas.get(0);
        for (Consulta consul : consultasRegistradas) {
            if (consul.getCosto() > mayor.getCosto()) {
                mayor = consul;
            }
        }
        return mayor;
    }

    public Consulta obtenerUltimaConsulta() {
        if (consultasRegistradas.isEmpty()) return null;
        return consultasRegistradas.get(consultasRegistradas.size() - 1);
    }


    public int contarPorDiagnostico(String diagnostico) {
        int contador = 0;
        for (Consulta consul : consultasRegistradas) {
            if (consul.getDiagnostico().equalsIgnoreCase(diagnostico)) {
                contador++;
            }
        }
        return contador;
    }

    public int getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(int numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public List<Consulta> getConsultasRegistradas() {
        return consultasRegistradas;
    }

    public void setConsultasRegistradas(List<Consulta> consultasRegistradas) {
        this.consultasRegistradas = consultasRegistradas;
    }

    public int getCantidadConsultas() {
        return cantidadConsultas;
    }

    public void setCantidadConsultas(int cantidadConsultas) {
        this.cantidadConsultas = cantidadConsultas;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}
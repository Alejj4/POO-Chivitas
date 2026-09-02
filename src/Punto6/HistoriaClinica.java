package Punto6;

import java.util.ArrayList;
import java.util.List;

public class HistoriaClinica {
    private int numeroHistoria;
    private List<Consulta> consultasRegistradas;
    private int cantidadConsultas;
    private String fechaCreacion;

    public HistoriaClinica(int numeroHistoria, String fechaCreacion) {
        this.numeroHistoria = numeroHistoria;
        this.fechaCreacion = fechaCreacion;
    }

    public boolean agregarConsulta(Consulta consulta){
        if(cantidadConsultas<= this.consultasRegistradas.size()){
            consultasRegistradas.add(consulta);
            System.out.println("Se agrego la consulta");
            return true;
        }
        else{
            return false;
        }

    }
    public List<Consulta> buscarPorFecha( String fecha){
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
            if (consul.requiereSeguimiento()==true) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularCostoPromedio() {
        double suma = 0;
        for (Consulta consul : consultasRegistradas) {
            suma += consul.getCosto();
        }
        return suma / consultasRegistradas.size();
    }

    public Consulta obtenerConsultaMayorCosto() {
        Consulta mayor =consultasRegistradas.get(0);
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












}
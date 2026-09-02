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
}
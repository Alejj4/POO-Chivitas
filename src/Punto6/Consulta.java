package Punto6;

public class Consulta {
    private String fechaAtencion;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private double costo;
    private boolean requiereSeguimiento;

    public Consulta(String fechaAtencion, String motivo, String diagnostico, String tratamiento, double costo, boolean requiereSeguimiento) {
        this.fechaAtencion = fechaAtencion;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.costo = costo;
        this.requiereSeguimiento = requiereSeguimiento;
    }

    public boolean requiereSeguimiento(){
        return this.requiereSeguimiento;
    }

    public double costoFinal(Boolean tieneObraSocial){
        if(tieneObraSocial==true){
            return this.costo*0.50;
        }
        else{
            return this.costo;
        }

    }
    public void MostrarResumen(){
        System.out.println("Fecha: " + fechaAtencion + " | Motivo: " + motivo +
                " | Diagnóstico: " + diagnostico + " | Tratamiento: " + tratamiento +
                " | Costo Base: $" + costo + " | Seguimiento: " + (requiereSeguimiento ? "Sí" : "No"));

    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isRequiereSeguimiento() {
        return requiereSeguimiento;
    }

    public void setRequiereSeguimiento(boolean requiereSeguimiento) {
        this.requiereSeguimiento = requiereSeguimiento;
    }
}







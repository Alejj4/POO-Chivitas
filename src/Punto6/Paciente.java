package Punto6;

public class Paciente {
    private String numeroIdentificacion;
    private String nombreApellido;
    private String fechaNacimiento;
    private String obraSocial;
    private HistoriaClinica historiaClinica;

    public Paciente(String numeroIdentificacion, String nombreApellido, String fechaNacimiento, String obraSocial, HistoriaClinica historiaClinica, String fechaCreacion, int numeroHistoria) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.obraSocial = obraSocial;
        this.historiaClinica = new HistoriaClinica(numeroHistoria, fechaCreacion);

    }

    public int consultarEdadPaciente(int añoActual){
        int añoInt= 0;
        String añoTexto = this.fechaNacimiento.substring(6);
        añoInt = Integer.parseInt(añoTexto);
        return añoActual - añoInt;
    }

    public boolean registrarConsulta(Consulta consulta) {
        return this.historiaClinica.agregarConsulta(consulta);
    }



}

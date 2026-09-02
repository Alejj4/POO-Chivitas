package Punto6;

public class Paciente {
    private String numeroIdentificacion;
    private String nombreApellido;
    private String fechaNacimiento;
    private String obraSocial;
    private HistoriaClinica historiaClinica;

    public Paciente(String numeroIdentificacion, String nombreApellido, String fechaNacimiento, String obraSocial, String fechaCreacion, int numeroHistoria) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.obraSocial = obraSocial;
        this.historiaClinica = new HistoriaClinica(numeroHistoria, fechaCreacion);
    }

    public Paciente(String numeroIdentificacion, String nombreApellido, String fechaNacimiento, String obraSocial, String fechaCreacion, int numeroHistoria, int capacidadHistoria) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.obraSocial = obraSocial;
        this.historiaClinica = new HistoriaClinica(numeroHistoria, fechaCreacion, capacidadHistoria);
    }

    public Paciente(String numeroIdentificacion, String nombreApellido, String fechaNacimiento, String obraSocial, HistoriaClinica historiaClinica, String fechaCreacion, int numeroHistoria) {
        this(numeroIdentificacion, nombreApellido, fechaNacimiento, obraSocial, fechaCreacion, numeroHistoria);
    }

    public int consultarEdadPaciente(int añoActual){
        int añoInt= 0;
        String añoTexto = this.fechaNacimiento.substring(6);
        añoInt = Integer.parseInt(añoTexto);
        return añoActual - añoInt;
    }

    public void registrarConsulta(Consulta consulta) {
        historiaClinica.agregarConsulta(consulta);
    }

    //public int obtenerEdad() {no se como hacerlo}

    public double obtenerCostoTotalConsultas() {
        double total = 0;
        boolean descuento = false;
        if (obraSocial != null && !obraSocial.trim().isEmpty() && !obraSocial.equalsIgnoreCase("ninguna")) {
            descuento = true;
        }
        for (Consulta consul : historiaClinica.getConsultasRegistradas()) {
            total += consul.costoFinal(descuento);
        }
        return total;
    }

    public boolean necesitaSeguimiento() {
        return historiaClinica.ConsultasSeguimiento() > 0;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
}

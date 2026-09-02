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

    public void registrarConsulta(Consulta consulta) {
        if(historiaClinica.agregarConsulta(consulta)){
            System.out.println("Se agrego la consulta");
        }
        else{
            System.out.println("No se pudo agregar la consulta");
        }
    }

    //public int obtenerEdad() {no se como hacerlo}

    public double obtenerCostoTotalConsultas() {
        double total = 0;
        boolean descuento=false;
        if(obraSocial!=null){
            descuento=true;
        }
        for (Consulta consul : historiaClinica.getConsultasRegistradas()) {
            total += consul.costoFinal(descuento);
        }
        return total;
    }

    public boolean necesitaSeguimiento() {
        return historiaClinica.ConsultasSeguimiento() > 0;
    }







}

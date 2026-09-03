package Punto1;

import java.util.ArrayList;
import java.util.List;
public class Medico {
    private String matricula;
    private String nombre;
    private String especialidad;
    private List<Paciente> pacientes;

    public Medico(String matricula, String nombre, String especialidad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.pacientes = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente buscarPaciente(String dni){
        for (Paciente p : pacientes) {
            if (p.getDni().equals(dni)) {
                return p;
            }
        }
        return null;
    }
    public boolean asignarPaciente(Paciente paciente){
        if (paciente == null){
            return false;
        }
        if (buscarPaciente(paciente.getDni()) != null){
            return false;
        }
        this.pacientes.add(paciente);
        return true;


    }

    public boolean eliminarPaciente(String dni){
        if (buscarPaciente(dni) != null){
            this.pacientes.remove(buscarPaciente(dni));
            return true;
        }
        return false;
    }

    public int cantidadPacientes() {
        return this.pacientes.size();
    }



    public void mostrarPacientes(){
        if (!pacientes.isEmpty()) {
            for (Paciente p : pacientes) {
                System.out.println(p);
            }
        }else{
            System.out.println("No tiene pacientes asignados");
        }
    }
}



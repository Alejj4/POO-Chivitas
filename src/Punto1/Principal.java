package Punto1;

public class Principal{
    public static void main(String[] args) {

        Paciente p1 = new Paciente("123456789", "Tiziano", "osde");
        Paciente p2 = new Paciente("987654321", "Gonza", "swiss medical");
        Paciente p3 = new Paciente("999999999", "Alejo", "pami");

        Medico m1 = new Medico("01", "dr junchi", "pediatra");
        Medico m2 = new Medico("02", "dr chinti", "cardiologo");

        m1.asignarPaciente(p1);
        m1.asignarPaciente(p2);
        m2.asignarPaciente(p1);
        m2.asignarPaciente(p3);
        System.out.println("pacientes del medico 1: ");
        m1.mostrarPacientes();
        System.out.println("cantidad: " + m1.cantidadPacientes());
        System.out.println();

        System.out.println("pacientes del medico 2: ");
        m2.mostrarPacientes();
        System.out.println("cantidad: " + m2.cantidadPacientes());
        System.out.println();

        System.out.println("busqueda");
        Paciente buscado = m1.buscarPaciente("123456789");
        if (buscado != null){
            System.out.println("el paciente con el dni 123456789 es: " + buscado);
        }else{
            System.out.println("No existe tal paciente");
        }
        System.out.println();

        System.out.println("eliminacion");
        System.out.println("eliminar a tiziano con el dni 123456789");
        boolean eliminado = m1.eliminarPaciente("123456789");
        System.out.println("se elimino a tiziano?: " + eliminado);

        System.out.println("pacientes de medico 1 despues de la eliminacion");
        m1.mostrarPacientes();
        System.out.println();

        System.out.println("corroboracion de que el pacientes sigue existiendo: ");
        System.out.println("el paciente 1 es: " + p1);
        System.out.println("el paciente 1 sigue en la lista del medico 2: ");
        m2.mostrarPacientes();
    }
}

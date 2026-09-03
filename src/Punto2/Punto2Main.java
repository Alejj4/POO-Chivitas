package Punto2;

public class Punto2Main{
    public static void main(String[] args) {
        Equipo equipoLosCapitos = new Equipo("Loscapitos", "Expertos");
        Entrenador ingreso1=new Entrenador(49263749, "Tiziano", 9);
        Entrenador ingreso2=new Entrenador(44667374, "ISA", 18);

        equipoLosCapitos.asignarEntrenador(ingreso1);

        equipoLosCapitos.cambiarEntrenador(ingreso2);
        equipoLosCapitos.obtenerEntrenador();
        equipoLosCapitos.mostrarInformacion();

    }

}
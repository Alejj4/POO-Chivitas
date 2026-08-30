package Punto4;

import java.util.Scanner;

public class punto4Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GestorPedido gestor = new GestorPedido(2);
        Notificador noti1 = new Notificador("Alejo", "ale@gmail.com");
        Notificador noti2 = new Notificador("Gonzalo", "gonza@gmail.com");

        gestor.crearPedido(noti1);
        gestor.crearPedido(noti2);
        gestor.crearPedido(noti1);


        for (int i = 0; i < gestor.getTotalPedidos(); i++) {
            Pedido pedido = gestor.getPedido(i);

            System.out.println("\nPedido número: " + pedido.getNumero());
            System.out.println("Seleccione notificación:");
            System.out.println("1 - SMS");
            System.out.println("2 - Email");

            int opcion = sc.nextInt();

            while (opcion != 1 && opcion != 2) {
                System.out.println("Opción incorrecta. Elija 1 o 2:");
                opcion = sc.nextInt();
            }

            gestor.modificarEstado(pedido, noti1, opcion);
            gestor.modificarEstado(pedido, noti2, opcion);

        }
    }
}
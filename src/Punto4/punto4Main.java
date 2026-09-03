package Punto4;

public class punto4Main {
    public static void main(String[] args) {
        GestorPedido gestor = new GestorPedido();

        Pedido p1 = new Pedido(101, "PENDIENTE", 4500);
        Pedido p2 = new Pedido(102, "EN_PREPARACION", 8200);

        Notificador notiCliente1 = new Notificador("Alejo (ale@gmail.com)");
        Notificador notiCliente2 = new Notificador("Gonzalo (+5491112345678)");

        System.out.println("Notificación 1 Email");
        gestor.marcarComoListo(p1, notiCliente1, 2);

        System.out.println("\notificación 2 SMS");
        gestor.marcarComoListo(p2, notiCliente2, 1);

        System.out.println("\nprueba para ver duplicados");
        gestor.marcarComoListo(p1, notiCliente1, 2);
    }
}
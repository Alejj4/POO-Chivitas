package Punto4;

public class GestorPedido {

    public boolean marcarComoListo(Pedido pedido, Notificador notificador, int tipoNoti) {
        if (pedido == null || notificador == null) {
            System.out.println("Error: Pedido o notificador nulo.");
            return false;
        }

        // Consigna 3: Validar que solo se notifique si cambia efectivamente de estado
        if ("LISTO".equalsIgnoreCase(pedido.getEstado())) {
            System.out.println("El pedido " + pedido.getNumero() + " ya está LISTO. No se notifica nuevamente.");
            return false;
        }

        pedido.setEstado("LISTO");

        notificador.setMensaje("El pedido número " + pedido.getNumero() + " está listo para retirar.");

        switch (tipoNoti) {
            case 1:
                notificador.notiSMS();
                break;
            case 2:
                notificador.notiEmail();
                break;
            default:
                System.out.println("Tipo de notificación inválido.");
                return false;
        }

        return true;
    }
}
package Punto4;
import java.util.Scanner;

public class GestorPedido {
    private Pedido[] pedidos;
    int totalPedidos = 0;

    public GestorPedido(int capacidadMaxima){
        this.pedidos = new Pedido[capacidadMaxima];
    }
    public int getTotalPedidos() {
        return totalPedidos;
    }
    public Pedido getPedido(int indice) {
        return pedidos[indice];
    }
    public String crearPedido(Notificador notificador){
        Scanner sc = new Scanner(System.in);
        if(totalPedidos < this.pedidos.length){
        System.out.print("Número del pedido: ");
        int numero = sc.nextInt();

        System.out.print("Estado: ");
        String estado = sc.next();

        System.out.print("Total: ");
        int total = sc.nextInt();

        Pedido nuevoPedido = new Pedido(numero, estado, total,notificador);
        this.pedidos[totalPedidos] = nuevoPedido;
        totalPedidos++;
        }else return( "La lista de pedidos esta llena");
    return ("Pedido cargado!");
    }
    public String modificarEstado(Pedido pedido, Notificador noti, int tipoNoti) {
        if (pedido.getEstado().equalsIgnoreCase("pendiente")) {
            pedido.setEstado("listo");

            switch (tipoNoti) {
                case 1:
                    pedido.getNotificador().notiSMS();
                    break;
                case 2:
                    pedido.getNotificador().notiEmail();
                    break;
            }
            return "¡Notificación enviada!";
        }
        return "El pedido se encuentra listo o no está disponible";
    }



}

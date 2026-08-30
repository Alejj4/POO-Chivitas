package Punto4;

public class Notificador {
    private String destinatario;
    private String mensaje;
    private String email;

    public Notificador(String destinatario, String email) {
        this.destinatario = destinatario;
        this.mensaje = "El pedido esta listo para retirar";
        this.email = email;
    }

    public void notiSMS(){
        System.out.println("SMS");
        System.out.println(this.destinatario +  ": " + this.mensaje);
    }

    public void notiEmail(){
        System.out.println("De: blockburguer@gmail.com");
        System.out.println("Para: " + this.email +"\n");
        System.out.println("¡Hola! " + this.mensaje);
    }
}

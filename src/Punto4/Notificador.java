package Punto4;

public class Notificador {
    private String destinatario;
    private String mensaje;

    public Notificador(String destinatario) {
        this.destinatario = destinatario;
        this.mensaje = "";
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void notiSMS() {
        System.out.println("[SMS para " + this.destinatario + "]: " + this.mensaje);
    }

    public void notiEmail() {
        System.out.println("[Email para " + this.destinatario + "]: " + this.mensaje);
    }
}
package Punto4;

public class Pedido {
    private int numero;
    private String estado;
    private int total;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pedido(int numero, String estado, int total) {
        this.numero = numero;
        this.estado = estado;
        this.total = total;
    }
}

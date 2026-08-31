package Punto5;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto){
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito completo, dinero en cuenta: "+ saldo);
        }else{
            System.out.println("EL monto debe ser positivo");
        }
    }

    public void extraer(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo");
        } else if (monto > saldo) {
            System.out.println("El monto es mayor al saldo disponible");
        } else {
            saldo -= monto;
            System.out.println("Extraccion completa, dinero en cuenta: "+ saldo);
        }
    }


    public double calcularSaldoFinal(){
        return saldo;
    }

    public void mostrarInformacion() {
        System.out.println("Informacion de la cuenta:");
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("Saldo final: " + calcularSaldoFinal());
    }
}

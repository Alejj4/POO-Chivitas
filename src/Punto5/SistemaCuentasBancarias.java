package Punto5;

public class SistemaCuentasBancarias {
    public static void main(String[] args) {
        CuentaAhorro ahorro = new CuentaAhorro("01", "Gonzalo Raggio", 10000, 0.05);
        CuentaCorriente corriente = new CuentaCorriente("02", "Alero Aranguren", 5000, 3000, 200);

        System.out.println("Extraccion y deposito en cuenta de ahorros: ");
        ahorro.depositar(2000);
        ahorro.extraer(1500);
        ahorro.extraer(50000);
        ahorro.mostrarInformacion();
        System.out.println();

        System.out.println("Exraccion y deposito en cuenta corriente: ");
        corriente.depositar(1000);
        corriente.extraer(8000);
        corriente.extraer(2000);
        corriente.mostrarInformacion();
        System.out.println();

        CuentaBancaria[] cuentasBancarias = new CuentaBancaria[2];
        cuentasBancarias[0] = ahorro;
        cuentasBancarias[1] = corriente;

        System.out.println("Comportamiento polimorfico en saldo final: ");
        for (CuentaBancaria cuenta : cuentasBancarias) {
            System.out.println("El saldo final de: " + cuenta.getTitular() + " es de: " + cuenta.calcularSaldoFinal());
        }
    }


}

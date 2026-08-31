package Punto5;

public class CuentaCorriente extends  CuentaBancaria {
    private  double limiteDescubierto;
    private double costoMantenimiento;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double limiteDescubierto, double costoMantenimiento) {
        super(numeroCuenta, titular, saldo);
        this.limiteDescubierto = limiteDescubierto;
        this.costoMantenimiento = costoMantenimiento;
    }

    public double getLimiteDescubierto() {
        return limiteDescubierto;
    }

    public void setLimiteDescubierto(double limiteDescubierto) {
        this.limiteDescubierto = limiteDescubierto;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    @Override
    public void extraer(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo");
            return;
        }
        double saldoResultante = getSaldo() - monto;
        if(saldoResultante >= -limiteDescubierto){
            setSaldo(saldoResultante);
            System.out.println("Extaccion completa, dinero en cuenta: "+ getSaldo());
        }else {
            System.out.println("No se puede extraer, el saldo resultante es mayor al limite descubierto");
        }
    }

    @Override
    public double calcularSaldoFinal(){
        return getSaldo() - costoMantenimiento;

    }

}


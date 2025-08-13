// Crea una clase CuentaBancaria que represente una cuenta de un cliente en un banco.

// Requisitos:
// La clase debe tener los siguientes atributos:
// titular
// numeroCuenta
// saldo

// Crea un constructor que reciba el nombre del titular, el número de cuenta y el saldo inicial.

// El programa debe mostrar los datos de la cuenta.

// depositar

// retirar

// transferir

public class CuentaBancaria {
    String titular;
    String numeroCuenta;
    Integer saldo;

    public CuentaBancaria(String titular, String numeroCuenta, Integer saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void depositar(Integer deposito) {
        saldo += deposito;
        System.out.println(
                "Se ha depositado un nuevo saldo de "+deposito+" a la cuenta " + numeroCuenta + " la cual pertenece " + titular);
    }

    public void retirar(Integer retiro) {
        saldo -= retiro;
        System.out.println("Se ha retirado la suma de  " + saldo + " de la cuenta " + numeroCuenta);
    }
    
    public void transferir(CuentaBancaria trans, Integer cuentaTeas) {
        if (trans.saldo < cuentaTeas) {
            System.out.println("Lo sentimos el saldo que desea transferir a la cuenta " + numeroCuenta
                    + " no es suficiente el saldo que tiene " + trans.saldo);
        } else {
            Integer saldoActual = saldo;
            saldoActual += cuentaTeas;
            System.out.println("Se transfiere la cantidad de " + cuentaTeas + " de la cuenta " + trans.numeroCuenta
                    + " hacia la cuenta " + numeroCuenta);
        }
    }

    public void mostrarCuenta() {
        System.out.println("Titular"+titular);
        System.out.println("#Cuenta: "+numeroCuenta);
        System.out.println("Saldo: "+saldo);
    }

    public static void main(String[] args) {
        CuentaBancaria cliente1 = new CuentaBancaria("Carlos", "123456", 500000);
        CuentaBancaria cliente2 = new CuentaBancaria("Maria", "3112345", 100000);

        
        System.out.println("----------------------------Valores Predefinidos----------------------------");
        cliente1.mostrarCuenta();
        System.out.println("---------------------------------------------------------");
        cliente2.mostrarCuenta();



        System.out.println("----------------------------Valores Despues del deposito----------------------------");
        cliente1.depositar(1000);
        cliente2.depositar(2000);
        cliente1.mostrarCuenta();
        System.out.println("---------------------------------------------------------");
        cliente2.mostrarCuenta();


        System.out.println("----------------------------Valores Despues de transferencia----------------------------");
        cliente1.transferir(cliente2, 200000);
        cliente1.mostrarCuenta();
        System.out.println("---------------------------------------------------------");
        cliente2.mostrarCuenta();

    }
}
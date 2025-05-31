//@Author Matias Del Pup

package classes;

import java.util.Scanner;

public class ClaseHijaDeposito extends ClaseP {

    @Override
    public void Transferencias() {
        boolean valido = false;
        while (!valido) {
            System.out.println("¿Cuánto quieres depositar?");
            String input = entrada.nextLine();  

            try {
                deposito = Integer.parseInt(input);
                if (deposito <= 0) {
                    System.out.println("Por favor, ingrese un valor mayor a 0.");
                } else {
                    valido = true;  
                    setPlata(getPlata() + deposito);
                    System.out.println("Nuevo saldo después del depósito: " + getPlata());
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número por favor.");
            }
        }
    }
}
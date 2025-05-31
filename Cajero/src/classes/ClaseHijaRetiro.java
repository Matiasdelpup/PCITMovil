//@Author Matias Del Pup

package classes;

import java.util.Scanner;

public class ClaseHijaRetiro extends ClaseP {

    @Override
    public void Transferencias() {
        boolean valido = false;
        while (!valido) {
            System.out.println("¿Cuánto quieres retirar?");
            String input = entrada.nextLine();  

            try {
                retiro = Integer.parseInt(input);
                if (retiro > getPlata()) {
                    System.out.println("No tienes suficiente saldo.");
                } else {
                    valido = true;  
                    setPlata(getPlata() - retiro);
                    System.out.println("Nuevo saldo después del retiro: " + getPlata());
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número por favor.");
            }
        }
    }
}
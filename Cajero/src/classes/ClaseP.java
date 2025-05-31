//@Author Matias Del Pup

package classes;

import java.util.Scanner;

public abstract class ClaseP {
    protected int transferencias, retiro, deposito;
    private static int plata;
    protected static Scanner entrada = new Scanner(System.in);

    public void Operaciones() {
        boolean salir = false;
        while (!salir) {
            int eleccion = Menues();

            if (eleccion == 1) {
                ClaseP mensajero = crearOperacion(eleccion);
                mensajero.Transferencias();  
            } else if (eleccion == 2) {
                ClaseP mensajero = crearOperacion(eleccion);
                mensajero.Transferencias(); 
            } else if (eleccion == 3) {
                ClaseP mensajero = crearOperacion(eleccion);
                mensajero.Transferencias(); 
            } else if (eleccion == 4) {
                System.out.println("****************************");
                System.out.println("¡Muchas gracias por usarnos!");
                System.out.println("****************************");
                salir = true;
            }
        }
    }

    private int Menues() {
        int eleccion = -1;
        boolean valido = false;
        do {
            System.out.println("Elija una opción: ");
            System.out.println("   1. Preguntar saldo.");
            System.out.println("   2. Retirar efectivo.");
            System.out.println("   3. Depositar efectivo.");
            System.out.println("   4. Salir");

            String input = entrada.nextLine();  // Usamos nextLine() para leer la entrada como String
            try {
                eleccion = Integer.parseInt(input);
                if (eleccion >= 1 && eleccion <= 4) {
                    valido = true;
                } else {
                    System.out.println("**************************************************");
                    System.out.println("Por favor, seleccione un número dentro del margen.");
                    System.out.println("**************************************************");
                }
            } catch (NumberFormatException e) {
                // Si no es un número, mostramos el error
                System.out.println("************************************");
                System.out.println("Por favor, ingrese un número válido.");
                System.out.println("************************************");
            }
        } while (!valido);
        return eleccion;
    }

    private ClaseP crearOperacion(int eleccion) {
        switch (eleccion) {
            case 1:
                return new ClaseHijaConsulta();
            case 2:
                return new ClaseHijaRetiro();
            case 3:
                return new ClaseHijaDeposito();
            default:
                return null;
        }
    }

    public abstract void Transferencias();

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }
}

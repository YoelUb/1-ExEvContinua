package src.main.java;

import src.main.java.actividad1.Matematicas;
import src.main.java.actividad2.Tablero;
import java.util.concurrent.TimeUnit;


public class Main {


    public static void main(String[] args) {
        System.out.println("---------------------------------------------");
        System.out.println("Actividad 1: ");
        System.out.println("El numero Pi es: " + Matematicas.generarNumeroPi(Integer.parseInt(args[0])));
        System.out.println("---------------------------------------------");
        System.out.println("Actividad 2: ");
        Tablero tablero = new Tablero();
        try {
            System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
            tablero.leerEstadoDesdeArchivo("docs/matriz.txt");
            System.out.println(tablero);

            for (int i = 0; i <= 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                tablero.transitarAlEstadoSiguiente();
                System.out.println(tablero);
            }

            System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
            tablero.generarEstadoActualPorMontecarlo();
            System.out.println(tablero);


            for (int i = 0; i <= 15; i++) {
                TimeUnit.SECONDS.sleep(1);
                tablero.transitarAlEstadoSiguiente();
                System.out.println(tablero);
            }
        } catch (InterruptedException e) {
            System.out.println("Error durante la simulación: " + e);
        }

        System.out.println("---------------------------------------------");
        System.out.println("FUNCIONA ;)");
        System.out.println(";) ----> 10000 de aura");
        System.out.println(":) ------> -10000 de aura");

    }
}
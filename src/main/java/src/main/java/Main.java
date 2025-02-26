package src.main.java;

import actividad1.Matematicas;
import actividad2.Tablero;
import actividad3.Graph;

import java.util.List;
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
            tablero.leerEstadoDesdeArchivo("docs/Recursos/matriz.txt");
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
        System.out.println("Actividad 3: ");
        Graph<Integer> grafo = new Graph<>();
        grafo.addEdge(1, 2);
        grafo.addEdge(3, 4);
        grafo.addEdge(1, 5);
        grafo.addEdge(5, 6);
        grafo.addEdge(6, 4);
        int inicio = 1;
        int fin = 4;
        List<Integer> camino = grafo.onePath(inicio, fin);

        if (camino != null) {
            System.out.println("Camino encontrado de " + inicio + " a " + fin + ": " + camino);
        } else {
            System.out.println("No se encontró un camino de " + inicio + " a " + fin);
        }


        System.out.println("---------------------------------------------");
        System.out.println("FUNCIONA ;)");
        System.out.println(";) ----> 10000 de aura");
        System.out.println(":) ------> -10000 de aura");

    }
}
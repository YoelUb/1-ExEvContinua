package src.main.java.actividad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Tablero {

    private static final int DIMENSION = 30;
    private int[][] estadoActual = new int[DIMENSION][DIMENSION];
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    public void leerEstadoDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int fila = 0;

            while ((linea = br.readLine()) != null && fila < DIMENSION) {
                for (int columna = 0; columna < linea.length() && columna < DIMENSION; columna++) {
                    estadoActual[fila][columna] = Character.getNumericValue(linea.charAt(columna));
                }
                fila++;
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer bien el archivo :(: " + e.getMessage());
        }
    }


    public void generarEstadoActualPorMontecarlo() {

        Random rand = new Random();

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {

                estadoActual[i][j] = rand.nextInt(2);
            }
        }


    }

    private int contarVecinosVivos(int fila, int columna) {
        int vecinos = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int ix = fila + i;
                int jx = columna + j;

                if ((i != 0 || j != 0) && ix >= 0 && ix < DIMENSION && jx >= 0 && jx < DIMENSION) {
                    vecinos += estadoActual[ix][jx];
                }
            }
        }

        return vecinos;
    }

    public void transitarAlEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinos = contarVecinosVivos(i, j);

                if (estadoActual[i][j] == 1) {
                    estadoSiguiente[i][j] = (vecinos == 2 || vecinos == 3) ? 1 : 0;
                } else {
                    estadoSiguiente[i][j] = (vecinos == 3) ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < DIMENSION; i++) {
            System.arraycopy(estadoSiguiente[i], 0, estadoActual[i], 0, DIMENSION);
        }
    }


    @Override
    public String toString() {
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                sbuilder.append(estadoActual[i][j] == 1 ? "X" : " ");
            }
            sbuilder.append("\n");
        }
        return sbuilder.toString();
    }

}

package actividad1;

import java.util.Random;

public class Matematicas {


    public static double generarNumeroPi(long pasos) {
        int areaCuadrado = 4;
        int aciertos = 0;
        Random rand = new Random();


        for (int i = 0; i < pasos; i++){


            double x = rand.nextDouble();
            double y = rand.nextDouble();

            if ((x * x) + (y * y) <= 1){
                aciertos++;
            }

        }

        return areaCuadrado * (aciertos / (double) pasos);

    }

}

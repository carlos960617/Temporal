package viernes7;

import java.util.Scanner;

public class MesTester {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MesCollector enero = new MesCollector(1,2021);

        String datosEnero = enero.toString();

        System.out.println(datosEnero);

        enero.setTemperatura(25,22);

        System.out.println(enero);

        enero.mes = 5;


    }
}

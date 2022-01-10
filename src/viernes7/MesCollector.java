package viernes7;

import java.util.Arrays;

public class MesCollector {

    public int mes;
    private int anyo;
    private int diasMes;
    //temperaturas maximas de cada mes
    private int[] temperatura;

    public MesCollector (int mes1, int anyo1){
        mes = mes1;

        if(mes == 1 || mes==3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            diasMes = 31;
        }else if(mes == 4 || mes==6 || mes == 9 || mes == 11){
            diasMes = 30;
        }else if(mes == 2){
            diasMes = 28;
        }else{ diasMes = 0;}

        anyo = anyo1;

        temperatura = new int[31];
    }

     public int getTemperatura(int numDia){

        if(numDia < 1 || numDia > 31){
            return -1;
        }else{return temperatura[numDia-1];}

    }

    public void setTemperatura(int numDia, int temp){

        if(numDia >= 1 && numDia <= 31){

            temperatura[numDia-1] = temp;

        }

    }

    @Override
    public String toString(){

        String[] parte = new String[31];
        String s1 = "Mes: "+mes+"\n" +
                "Año: "+anyo+"\n" +
                "Dias del mes: "+diasMes+"\n" +
                "Temperaturas Máximas: ";

            for(int i= 0;i<temperatura.length; i++){

                if(temperatura[i] != 0){
                    parte[i] =  "\nDia "+(i+1)+": "+temperatura[i]+ " grados";
                }else{
                    parte[i] = "\nDia "+(i+1)+": No hay datos";
                }
            }

            return s1 + Arrays.toString(parte);

        }



    }

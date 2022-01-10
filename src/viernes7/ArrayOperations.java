package viernes7;

import java.util.Arrays;

/*En esta clase se recogen métodos para facilitar la manipulación de arrays
* @author Carlos Pastor
* */

public class ArrayOperations {

    /**Este metodo llamado "print" itera por un array e imprime los valores de este con un formato en concreto
     * [elemento1, elemento2, elemento3, etc.]
     */

    public static void print(int[] array){

        for(int i=0;i<array.length;i++){
            if(i == 0){
                System.out.println("["+ array[0]);
            }else if(i == array.length-1){
                System.out.println(array[i]+"]");
            }else{
                System.out.println(" "+array[i]+",");
            }

        }
    }

    /*Este metodo devuelve un array nuevo con los valores de un primer array con el orden de sus elementos invertido*/

    /*Si el array se sobreescribiese a si mismo en lugar de uno nuevo, habría que
    * 1- O usar dos ints que lleguen uno desd el inicio dela rray hasta la mitad y otro desde el final hasta la mitad
    * 2- O pasar los elementos invrtidos aun array nuevo y despues sobreescribirlo de nuevo en el array original
    *
    * Si lo dejas como esta, pero sobreescribiendo un mismo array en cuanto llegase a la mitad daria error porque estarias copiando
    * los elementos ya sobreescritos (rollo = copio Z en A y cuando tengo que llegar a copiar A en Z, A vale Z entoncs me quedo con el
    * valor de Z repetido y pierdo el valor A*/

    public static int[] reverse(int[] array){

        int[] array2 = new int[array.length];

        for(int i=array.length-1, j=0;i>=0;i--, j++){
            array2[j] = array[i];
        }

        return array2;
    }

    /*El siguiente método suma todos los elementos de un array de int y devuelve el resultado */

    public static int sum(int[] array){

        int sum=0;

        for(int i:array){
            sum += i;
        }

        return sum;
    }

    /*Este metodo itera por un array comparando todos los valores con el primero y almacena en una variable int que devuelve, el elemento
    * del array con el valor mas alto*/

    public static int max(int[] array){

        int max = array[0];

        for(int i = 0;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

    /*Este metodo itera por un array comparando todos los valores con el primero y almacena en una variable int que devuelve, el elemento
     * del array con el valor mas bajo*/

    /*En lugar de inicializar min a array[0] puedes usar Integer.MAX_VALUE y Integer.MIN_VALUE que son el maximo y minimo numero de los integers
    * */

    public static int min(int[] array){

        int min = array[0];

        for(int i = 0;i<array.length;i++){
            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    /*El siguiente metodo acepta dos arrays y los compara. Primero compara su longitud para filtrar
    * la posibilidad de que sean iguales y alerta con un mensaje si no es así. En caso afirmativo
    * comprueba que los elementos son iguales y estan en el mismo orden. En el caso contrario alertará con un mensaje*/

    public static boolean equals (int[] array1, int[] array2){

        boolean esIgual = true;

        if(array1.length != array2.length){
            esIgual = false;
            System.out.println("Los arrays no tienen la misma longitud");
        }else{
            for(int i= 0; i<array1.length;i++){
                if(array1[i] != array2[i]){
                    esIgual = false;
                    System.out.println("Los arrays no contienen los mimsos elementos en el mismo orden");
                }
            }
        }

        return esIgual;
    }

    /*El siguiente metodo recibe dos arrays y crea una copia de ambos para ordenar sus elementos de menor a mayor y
    comprobar si son iguales. La copia de los arrays se hace para no alterar el orden real de los arrays originales. La copia ordenada
    sirve para comprobar si los arrays contienen los mismos valores independienemente de que esten almacenados en el mismo orden.
    * */

    /*
    * Si no quieres utilizar dos arrays temporales, puedes comprobar que un array es igual a otro comprobando con un for anidado
    * uno por uno si el elemento se encuentra (almacenando el true en un boolean) si uno de los elementos no se encuentra en
    * el segundo atumaticamente es false y se acaba la comparacion y el metodo devuelve false.*/

    public static boolean equalsWithoutOrder (int[] array1, int[] array2){

        boolean esIgual = true;

        int[] temp1 = new int[array1.length];
        int[] temp2 = new int[array2.length];
        copy(array1, temp1);
        copy(array2, temp2);
        //ojo que cuando aplicas sort a un array en un metodo se cambia en el main tambien
        Arrays.sort(temp1);
        Arrays.sort(temp2);

        if(array1.length != array2.length){
            esIgual = false;
            System.out.println("Los arrays ni siquiera tienen la misma longitud");
        }else{
            for(int i= 0; i<array1.length;i++){
                if(temp1[i] != temp2[i]){
                    esIgual = false;
                    System.out.println("Los arrays no contienen los mismos elementos");
                }
            }
        }



        return esIgual;
    }

    /*El siguiente metodo comprueba si los valores del array fuente se encuentran en el array destino.
    Para ello se compara cada valor del primer array con cada uno de los valores del segundo y si coinciden todos los valores
    del primer array mínimo una vez con los del array destino el método devolvera "true"
    * */

    public static boolean isArrayOn (int[] src, int[] dst) {
        int coincide = 0;

        for(int i = 0;i<dst.length;i++){

            for(int j = 0;j<src.length;j++){
                if(dst[i] == src[j]){
                    coincide++;
                }
            }
        }

        if(coincide >= src.length){
            return true;
        }else{return false;}
    }


    /*El siguiente metodo copia los valores de un array en un segundo, ambos declarados previamente al metodo*/

    public static void copy(int[] src, int[] dst){

        for(int i = 0; i<src.length;i++){
            dst[i] = src[i];
        }

            // System.arraycopy(array1, int de donde quieres que empiece a copiar, array2, inidice de espacio donde quieres que se pegue, longitud final);
    }

    /*Este método itera por los elementos de un array y comprueba si el resto de dividirlo entre 2 es cero. En caso negativo
    * dicho numero será impar y por lo tanto el metodo sustituye su valor en el array por el valor cero. El metodo
    * no devuelve un array nuevo con los valores actualizados sino que sobreescribe los del array pasado como parámetro*/

    public static void removeOddNumbers(int[] array){

        for(int i =0;i< array.length;i++){
            if(array[i]%2 !=0){
                array[i] = 0;
            }
        }
    }

    /*El siguiente método recibe un array e imprime en pantalla uno nuevo que empieza y acaba por los valores pasados igualmente
    * por parametro. Dado que los valores pasados como inicio y fin del nuevo array no tienen en cuenta que los indices de los elementos
    * empiezan por 0 y no por 1, se hace un reajuste de este error restando uno al valor de inicio.*/

    public static void printRange(int[] array, int start, int end){
        //¿Por qué en el enunciado start=1 equivale a indice 0?

        int[] subArray = new int[(end-start)+1];
        for(int i=start-1, j=0; i<end; i++,j++){
            subArray[j] = array[i];

        }

        System.out.println(Arrays.toString(subArray));
    }

    /*En este metodo se devuelve un array nuevo que itera por el que se pasa como parametro y elimina los comprendidos entre -9 y +9
    * (numeros de un solo digito)*/

    public static int[] deleteOneDigitNumbers(int[] array){

        int count = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] < -9 || array[i] > 9){
                count++;
            }
        }

        int[] filtered = new int[count];

        for(int i = 0, j=0;i<array.length;i++){
            if(array[i] < -9 || array[i] > 9){
                filtered[j] = array[i];
                j++;
            }
        }
        return filtered;
    }

    /*Ejercicio 5:
    * El siguiente método itera por los elementos de un array, comprobando si la parte decimal es mayor o menor que cinco. En
    * el primer caso redondea la parte entera al siguiente entero en caso negativo deja la parte entera sin la parte
    * decimal (lo redondea al alza o a la baja). Finalmente devuelve un array con los numeros redondeados.*/

    public static double[] redondeo(double[] array){

        double[] arrayRedondeado = new double[array.length];

        for(int i=0;i<array.length;i++){
            int intPart = (int) array[i];
            double doublePart = (array[i] - intPart)*10;

            if(doublePart < 5){
                arrayRedondeado[i] = intPart;
            }else{
                arrayRedondeado[i] = intPart + 1;
            }


        }


        return arrayRedondeado;

    }

}

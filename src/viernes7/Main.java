package viernes7;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

import static viernes7.ArrayOperations.*;

public class Main {

    public static void main(String[] args) {

        int[] array = {-2, 45, -29, 77, 56, 31};

        int[] copyArray = new int[array.length];

        System.out.println("Mayor numero del array:");

        System.out.println(max(array));

        copy(array, copyArray);

        System.out.println("Array copiado en una nueva dirección de memoria");

        System.out.println(Arrays.toString(copyArray));

        //version erronea: int[] arrayOrdenado = array;

        int[] arrayOrdenado = new int[array.length];

        copy(array, arrayOrdenado);

        Arrays.sort(arrayOrdenado);

        System.out.println("Una version nueva de array, ordenada:");

        System.out.println(Arrays.toString(arrayOrdenado));

        System.out.println("Comprobación de arrays iguales aun en diferente orden");

        System.out.println(equalsWithoutOrder(array, arrayOrdenado));

        System.out.println("Comprobación de arrays iguales si estan en el mismo orden");

        System.out.println(ArrayOperations.equals(array, copyArray));

        System.out.println("Eliminación de numeros impares");

        removeOddNumbers(array);

        System.out.println(Arrays.toString(array));

        System.out.println("Suma de los elementos del array sin números impares");

        System.out.println(sum(array));

        System.out.println("El menor de los elementos en el array original");

        System.out.println(min(copyArray));

        System.out.println("Imprimir numeros en un rango en concreto: Del 1 al 4 inclusive");

        printRange(copyArray, 1, 4);

        System.out.println("Dandole la vuelta al array ordenado:");

        System.out.println(Arrays.toString(reverse(arrayOrdenado)));

        System.out.println("Imprimir numeros en un rango en concreto: Del 2 al 5 inclusive");

        printRange(arrayOrdenado, 2, 5);

        System.out.println("Array sin numeros de un solo digito");

        System.out.println(Arrays.toString(deleteOneDigitNumbers(copyArray)));

        System.out.println("Redondeemos los valores de un array de dobles");

        double[] array2 = {2.5, 2.4, 2.9, 5.7, 3.4, 1.9, 4.9};

        System.out.println(Arrays.toString(redondeo(array2)));







    }
}

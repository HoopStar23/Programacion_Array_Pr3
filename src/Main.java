import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        menuOpciones();
    }

    public static void menuOpciones(){
        int opciones;
        do{
            menu();
            opciones = validaInt();
            scanner.nextLine();

            switch(opciones){
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> System.out.println("Saliendo");
            }
        }while(opciones != 6);
    }

    public static void menu(){
        System.out.println("Ejercicio 1");
        System.out.println("Ejercicio 2");
        System.out.println("Ejercicio 3");
        System.out.println("Ejercicio 4");
        System.out.println("Ejercicio 5");
        System.out.println("6. Salir");
        System.out.println("Que ejercicio quieres hacer?");
    }

    public static int validaInt(){
        while(!scanner.hasNextInt()){
            System.out.println("No es un numero");
            scanner.next();
        }
        return scanner.nextInt();
    }


    /*Crea un programa que cree una matriz de tamaño 5x5 que almacene los números
    del 1 al 25 y luego muestre la matriz por pantalla.*/
    public static void ejercicio1(){
        System.out.println("<-- EJERCICIO 1 -->");
        
        int array[][]= new int[5][5];
        int contador = 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = contador;
                contador++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    /*Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas
    de multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por
    pantalla.*/
    public static void ejercicio2(){
        System.out.println("<-- EJERCICIO 2 -->");

        int array[][] = new int[10][10];
        int tabla = 1;
        int contador = 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = tabla * contador;
                contador++;
            }
            tabla++;
            contador = 1;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
    /*Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por
     teclado) e introduzca en ella NxM valores (también introducidos por teclado). Luego
     deberá recorrer la matriz y al final mostrar por pantalla cuántos valores son mayores
     que cero, cuántos son menores que cero y cuántos son igual a cero.
     */
    public static void ejercicio3(){
        System.out.println("<-- EJERCICIO 3 -->");

        System.out.println("Introduce un valor");
        int x = validaInt();
        System.out.println("Introduce otro valor");
        int y = validaInt();

        int array[][]= new int[x][y];
        int valor;

        System.out.println("A continuacion introduce " + y + " disinto valores");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                valor = validaInt();
                array[i][j] = valor;
            }
            System.out.println("Introduce otros " + y + " valores");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    /*Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados
    “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por
    teclado y luego el programa mostrará la nota mínima, máxima y media de cada
    alumno.
    */
    public static void ejercicio4(){
        System.out.println("<-- EJERCICIO 4 -->");

        int alumnos[][] = new int[4][5];
        int num = 1, notas, total= 0;
        double media = 0;


        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("A continuacion introduce las notas de del alumno " + num);
            for (int j = 0; j < alumnos[i].length; j++) {
                notas = validaInt();

                while (notas < 0 || notas > 10){
                    System.out.println("Por favor introduce un valor entre 0 y 10");
                    notas = validaInt();
                }
                total += notas;
                alumnos[i][j] = notas;
            }
            Arrays.sort(alumnos[i]);
            media = total/5; //COMO CONSEGUIR NOTA CON DECIMALES, NO ME ACUERDO

            System.out.println("La nota media del alumno " + num + " es: " + media);
            System.out.println("La nota minima del alumno " + num + " es: " + alumnos[i][0] + " y la maxima es: " + alumnos[i][alumnos.length]);
            num++;
            total = 0;
        }
    }


    /*Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una
    empresa y detectar si existe brecha salarial entre ambos. El programa pedirá por
    teclado la información de N personas distintas (valor también introducido por
    teclado). Para cada persona, pedirá su género (0 para varón y 1 para mujer) y su
    sueldo. Esta información debe guardarse en una única matriz. Luego se mostrará por
    pantalla el sueldo medio de cada género.
    */
    public static void ejercicio5(){ //INVESTIGAR UN POCO MAS
        System.out.println("<-- EJERCICIO 5 -->");

        System.out.println("Cuantos sois que trabajan?");
        int empleados = validaInt(), opcion = 0, sueldo = 0, totalM = 0 , totalH = 0, mujer = 0, hombre = 0;
        double mediaM = 0, mediaH = 0;


        int array[][] = new int[empleados][2];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Cual es tu genero?");
            System.out.println("0: Hombre");
            System.out.println("1: Mujer");
            opcion = validaInt();
            switch (opcion){
                    case 0:
                        hombre++;
                        System.out.println("Eres un varon");
                        System.out.println("Y cual es tu sueldo?");
                        sueldo = validaInt();
                        array[i][0] = sueldo;
                        totalH += sueldo;
                        break;
                    case 1:
                        mujer++;
                        System.out.println("Eres una mujer");
                        System.out.println("Y cual es tu sueldo?");
                        sueldo = validaInt();
                        array[i][1] = sueldo;
                        totalM += sueldo;
                        break;
            }
        }

        mediaH = totalH/hombre;
        mediaM = totalM/mujer;

        System.out.println("La media del sueldo para hombres es: " + mediaH);
        System.out.println("La media del sueldo para mujer es: " + mediaM);

    }
}

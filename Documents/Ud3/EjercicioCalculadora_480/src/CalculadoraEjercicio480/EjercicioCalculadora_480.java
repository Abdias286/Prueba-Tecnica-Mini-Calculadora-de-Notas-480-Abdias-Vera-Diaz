package CalculadoraEjercicio480;

import java.util.Scanner;

/* Aqui creare una clase Alumno para organizar los metodos e informacion del estudiante

*/
class Alumno {

   
    private double[] notas;            // Usare un array que guardara las notas
    private int cantidadAsignaturas;   // Aqui guardare cuantas asignaturas tendra

    
    // Usaremos este constructor que inicializara varibles al crear un alumno
    public Alumno(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;      // Aqui guardare las notas del alumno
        this.notas = new double[cantidadAsignaturas];        // y aqui guardare cuantas asignaturas tiene
    }

    
    // Este metodo "setNota" nos servira para guardar la nota en la posicion que debe ser
    public void setNota(int posicion, double nota) {
        if (nota >= 0 && nota <= 10)      // Con esto validaremos las notas
        {    
            notas[posicion] = nota;       // y aqui guardo la nota con el array
        }
    }

    
    // Este metodo "getNotas" nos servira para leer todas las notas
    public double[] getNotas() {
        return notas;                     // Con esto devolvere el array de notas
    }

    
    // Este metodo nos servira para calcular la media de todas las notas
    public double calcularMedia() {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) 
        {    // Usamos este bucle para recorrer todas las notas del array
            suma = suma + notas[i];  
        }
        return suma / notas.length;                 // Dividimos por la cantidad de notas
    }


    // Ese metodo nos servira para saber cuantas notas suspendidas tenemos
    public int contarSuspensas() {
        int suspensas = 0;
        for (int i = 0; i < notas.length; i++) {    // Usamos este bucle para reccorer todas las notas
            if (notas[i] < 5) 
            {
                suspensas++;                        // Contamos cada nota menor que 5
            }
        }
        return suspensas;                           // Con esto devolvere el total de suspensas
    }

}


public class EjercicioCalculadora_480 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int numAsignaturas;     
        int i;
        double nota;
        Alumno alumno; 
        

        // Aqui pido cuantas asignaturas tiene y verifico el numero
        System.out.print("Numero de asignaturas (1-10): ");
        numAsignaturas = teclado.nextInt();
        
        
        while ((numAsignaturas < 1) || (numAsignaturas > 10)) 
        {
            System.out.println("Numero invalido. Debe estar entre 1 y 10.");
            numAsignaturas = teclado.nextInt();
        }

        // Gracias a esto creo el objeto alumno con la cantidad de asignaturas indicas
        alumno = new Alumno(numAsignaturas);

        
        // --Con esto pedire las notas uno por uno--
        for (i = 0; i < numAsignaturas; i++) 
        {
            System.out.print("Introduce la nota de la asignatura " + (i + 1) + ": ");
            nota = teclado.nextDouble();

            // --Validamos que la nota este entre 0 y 10--
            while ((nota < 0) || (nota > 10)) 
                {
                    System.out.println("Nota invalida. Debe estar entre 0 y 10.");
                    nota = teclado.nextDouble();
                }

        // y con esto guardo la nota en el objeto alumno usando el metodo setNota
            alumno.setNota(i, nota);  
        }

        
        // --Aqui calculare la media y las notas suspensas--
        double media = alumno.calcularMedia();       // Con esto llamamos al metodo que sumara el total de notas y dividira la cantidad de asignaturas
        int suspensas = alumno.contarSuspensas();    // Con esto llamamos al metodo que contara notas menores a 5
        double[] notas = alumno.getNotas();          // Obtenemos el array de notas para poder mostrarlas

        
        // --Con esto mostraremos todas las notas--
        System.out.print("Tus notas son: ");
        for ( i = 0; i < notas.length; i++)          // Bucle para recorrer las notas del alumno 
        {
            System.out.print(notas[i]);              // Con esto mostramos la nota en la posicion i del array
            if (i < notas.length - 1) 
            {                                        // Usamos el "-1" porque el array empieza en 0
                System.out.print(", ");              // Usamos el ", " para separar las notas 
            }
        }

        System.out.println("\nMedia: " + media);    // "\n" para saltar de linea y dar mas legibilidad
        System.out.println("Asignaturas suspensas: " + suspensas);

        
        // --Con esto determinamos el resultado final--
        if (suspensas == numAsignaturas) 
            {
                System.out.println("Resultado final: SUSPENDIDO ¡Debes esforzarte mas!");
            } else if (media == 10) 
            {
                System.out.println("Resultado final: APROBADO ¡Perfecto!");
            } else if ((media >= 5) && (suspensas <= 1)) 
            {
                System.out.println("Resultado final: APROBADO");
            } else 
            {
                System.out.println("Resultado final: SUSPENDIDO");
            }

    }
}
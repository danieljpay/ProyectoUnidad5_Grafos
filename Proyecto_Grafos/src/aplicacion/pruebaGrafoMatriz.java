package aplicacion;

import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import excepciones.PilaLlenaException;
import excepciones.PilaVaciaException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.grafoMatriz.GrafoMatriz;

/**
 * @author plupy
 */
public class pruebaGrafoMatriz {
    
    public static void main(String[] args) throws NodoYaExistenteException, NodoNoExistenteException, ColaLlenaException, ColaVaciaException, PilaLlenaException, PilaVaciaException, ArcoNoExistenteExcepcion {
        //vars
        int totalVertices;
        String nom;
        String nomDos;
        int numArcos;
        int indexVertis;
        boolean encontrado;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("pruebaGrafoMatriz");
        
        //inicio
        System.out.println("Formemos un grafo");
        System.out.println("Ingresa el número de vértices que tendrá tu grafo:");
        totalVertices = entrada.nextInt();
        GrafoMatriz grafito = new GrafoMatriz(totalVertices);
        
        //num vertices
        for (int i = 1; i <= totalVertices; i++) {
            System.out.println("Ingresa el nombre del vértice " + i + ":");
            nom = entrada.next();
            grafito.nuevoVertice(nom);
        }
        
        //num arcos
        System.out.println("¿cuántos arcos quieres agregar?");
        numArcos = entrada.nextInt();
        for (int i = 0; i < numArcos; i++) {
            System.out.println("Ingresa de quién a quién irá el nuevo arco: ");
            String[] vertices = new String[2];
            for (int j = 0; j < 2; j++) {
                vertices[j] = entrada.next();
            }
            grafito.union(vertices[0], vertices[1]);
        }
        
        //impresion de matriz
        ArrayList<ArrayList<Integer>> Matrix = grafito.getMatriz();
        grafito.printMatAd(Matrix);
        
        //recorrido de anchura
        System.out.println("\nRecorrido de anchura: \n");
        grafito.recorrerAmplitud();
        
        //busqueda de vertice con recorrido de anchura
        System.out.println("\nBusquemos un vértice con recorrido de anchura:\nIngresa el nombre del vértice que desea buscar:");
        nom=entrada.next();
        encontrado = grafito.buscarAmplitud(nom);
        if (encontrado) {
            System.out.println("\nEl vértice fue encontrado :)\n");
        }
        else{
            System.out.println("\nEl vértice no fue encontrado :(\n");
        }
        
        //recorrido de profundidad
        System.out.println("\nRecorrido de profundidad: \n");
        grafito.recorrerProfundidad();
        
        //busqueda de vertice con recorrido de profundidad
        System.out.println("\nBusquemos un vértice con recorrido de profundidad:\nIngresa el nombre del vértice que desea buscar:");
        nom=entrada.next();
        encontrado = grafito.buscarProfundidad(nom);
        if (encontrado) {
            System.out.println("\nEl vértice fue encontrado :)\n");
        }
        else{
            System.out.println("\nEl vértice no fue encontrado :(\n");
        }
        
        //borrar un arco
        System.out.println("Borremos un arco\nIngresa el nombre de los vértices de los cuales eliminaremos el arco:");
        nom=entrada.next();
        nomDos=entrada.next();
        grafito.borrarArco(nom, nomDos);
        grafito.printMatAd(Matrix);
        
        //borrar un vértice
        System.out.println("Borremos un vértice\nIngresa el nombre del vértice a eliminar:");
        nom = entrada.next();
        grafito.borrarVertice(nom);
        grafito.printMatAd(Matrix);
    }
    
}

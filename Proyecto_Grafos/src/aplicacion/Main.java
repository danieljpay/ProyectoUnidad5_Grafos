package aplicacion;

import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.GrafoMatriz;

/**
 * @author plupy
 */
public class Main {
    
    public static void main(String[] args) throws NodoYaExistenteException, NodoNoExistenteException, ColaLlenaException, ColaVaciaException {
        //vars
        int totalVertices;
        String nom;
        int numArcos;
        int indexVertis;
        Scanner entrada = new Scanner(System.in);
        
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
        
        //recorrido de profundidad
        System.out.println("\nRecorrido de anchura: \n");
        grafito.recorrerAmplitud();
        
        //borrar un vértice
        System.out.println("Borremos un vértice\nIngresa el nombre del vértice a eliminar:");
        nom = entrada.next();
        grafito.borrarVertice(nom);
        grafito.printMatAd(Matrix);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.grafoAdcia.GrafoAdcia;

/**
 *
 * @author plupy
 */
public class pruebaGrafoAdcia {
    public static void main(String[] args) throws NodoYaExistenteException, NodoNoExistenteException, ColaLlenaException, ColaVaciaException, ArcoNoExistenteExcepcion, PilaLlenaException, PilaVaciaException {
        Scanner entrada = new Scanner(System.in);
        int verticesGrafo;
        int numArcos;
        String nombre = "";
        String nombreDos = "";
        boolean encontrado;
        ArrayList<String> nombresArco = new ArrayList<String>();
        System.out.println("pruebaGrafoAdcia");
                
        //se establece número de vértices
        System.out.println("Ingresa el número de vértices que tendrá el grafo: ");
        verticesGrafo = entrada.nextInt();
        System.out.println("número de vértices ingresados: " + verticesGrafo);
        
        //se crea el grafo con el número de vertices ingresados
        GrafoAdcia grafito = new GrafoAdcia();
        
        //se nombran los vértices en la lista principal
        for(int i=1; i<=verticesGrafo; i++){
            System.out.println("Ingresa el nombre del vértice " + i);
            nombre = entrada.next();
            grafito.nuevoVertice(nombre);
        }
        
        //se establece el número de arcos que desean agregarse
        System.out.println("Ingresa el número de arcos que deseas agregar: ");
        numArcos = entrada.nextInt();
        //se establecen el origen y destino del número de arcos ingresado
        for(int j=0; j<numArcos; j++){
            System.out.println("Ingresa el nombre del vértice del que partirá el arco");
            nombre = entrada.next();
            System.out.println("Ingresa el nombre del vértice destino");
            nombreDos = entrada.next();
            grafito.union(nombre, nombreDos);
        }
        
        //se imprime la lista principal con sus arcos
        System.out.println("\nLista principal:");
        grafito.imprimir();
        
        //recorrido de anchura
        System.out.println("\nRecorrido de anchura:\n");
        grafito.recorrerAmplitud();
        
        //busqueda de vertice con recorrido de anchura
        System.out.println("\n Busquemos un vértice con recorrido de anchura:\nIngresa el nombre del vértice que desea buscar:");
        nombre=entrada.next();
        encontrado = grafito.buscarAmplitud(nombre);
        if (encontrado) {
            System.out.println("\nEl vértice fue encontrado :)\n");
        }
        else{
            System.out.println("\nEl vértice no fue encontrado :(\n");
        }
        
        //recorrido de profundidad
        System.out.println("\nRecorrido de profundidad:\n");
        grafito.recorrerProfundidad();
        
        //busqueda de vertice con recorrido de profundidad
        System.out.println("\n Busquemos un vértice con recorrido de profundidad:\nIngresa el nombre del vértice que desea buscar:");
        nombre=entrada.next();
        encontrado = grafito.buscarProfundidad(nombre);
        if (encontrado) {
            System.out.println("\nEl vértice fue encontrado :)\n");
        }
        else{
            System.out.println("\nEl vértice no fue encontrado :(\n");
        }
        
        /*
        //eliminar arco
        System.out.println("Eiminemos un arco\nIngresa el nombre del arco a eliminar");
        nombre = entrada.next();
        nombreDos = entrada.next();
        grafito.borrarArco(nombre, nombreDos);
        System.out.println("\nAsí quedaría la lista principal\n");
        grafito.imprimir();
        */
        
        //eliminar vertice
        System.out.println("\nEiminemos un vértice\nIngresa el nombre del vértice a eliminar");
        nombre = entrada.next();
        grafito.borrarVertice(nombre);
        System.out.println("\nAsí quedaría la lista principal\n");
        grafito.imprimir();
    }
}

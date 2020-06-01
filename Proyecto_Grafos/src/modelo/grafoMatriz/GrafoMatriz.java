package modelo.grafoMatriz;

import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import excepciones.PilaLlenaException;
import excepciones.PilaVaciaException;
import java.util.ArrayList;
import modelo.Grafo;
import modelo.Pila;

/**
 *
 * @author Daniel J. Pérez
 */
public class GrafoMatriz extends Grafo{
    int numVerts;
    static final int maxVerts = 20;            
    ArrayList<Vertice> verts;
    ArrayList<ArrayList<Integer>> matAd;
    
    public GrafoMatriz(int mx){
        matAd = new ArrayList<ArrayList<Integer>>();
        verts = new ArrayList<Vertice>();
        for (int i = 0; i < mx; i++) {
            ArrayList<Integer> fila = new ArrayList<Integer>();
            matAd.add(fila);
            for (int j = 0; j < mx; j++) {
                matAd.get(i).add(0);
            }
        }
        numVerts = 0;       //¿va dentro del for o fuera?
    }
    
    public GrafoMatriz(){
        this(maxVerts);    
    }
    
    public int numeroDeVertices(){
        return numVerts;    
    }
    
    public ArrayList<Vertice> vertices(){
        return verts;    
    }
    
    public ArrayList<ArrayList<Integer>> getMatriz(){
        return matAd;
    }

    /*
    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }
    */
    
    int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;){
            encontrado = verts.get(i).equals(v);
            if (!encontrado){
                i++;
            } 
        }
        return (i < numVerts) ? i : -1 ;
    }
    
    public void printMatAd( ArrayList<ArrayList<Integer>> arri){
        for (int i = 0; i < arri.size(); i++) {
            String strMat = " ";
            for (int j = 0; j < arri.size(); j++) {
                strMat += arri.get(i).get(j) + " ";
            }
            System.out.println(strMat);
        }
    }

    //***************************************************métodos abstractos******************************************************
    @Override
    public void borrarArco(Object x, Object y) throws ArcoNoExistenteExcepcion, NodoNoExistenteException{
        int va, vb;
        va = numVertice((String) x);
        vb = numVertice((String) y);
        if (va < 0 || vb < 0){
            throw new NodoNoExistenteException("Nodo no existe");
        }
        if(adyacente(x, y)){
            matAd.get(va).set(vb, 0);
            matAd.get(vb).set(va, 0);
        }
        else{
            throw new ArcoNoExistenteExcepcion("Arco no existe");
        }
    }

    @Override
    public boolean adyacente(Object x, Object y) throws NodoNoExistenteException{
        int va, vb;
        va = numVertice((String) x);
        vb = numVertice((String) y);
        if (va < 0 || vb < 0){
            throw new NodoNoExistenteException("Nodo no existe");
        }
        return matAd.get(va).get(vb) == 1;
    }

    @Override
    public void nuevoVertice(Object x) throws NodoYaExistenteException{
        boolean esta = numVertice((String) x) >= 0;
        if (!esta) {
            Vertice v = new Vertice((String) x); 
            v.asigVert(numVerts);
            verts.add(v);
            numVerts++;
        }
        else{
            throw new NodoYaExistenteException("El nodo ingresado ya existe");
        }
    }

    @Override
    public void borrarVertice(Object x) throws NodoNoExistenteException{
        int select = numVertice((String) x);    //obtengo el número del vértice que eliminaré
        boolean esta = select >= 0;
        if(!esta){
            throw new NodoNoExistenteException("Nodo no existe");
        }
        verts.remove(select);
        for (int i = 0; i < matAd.size(); i++) {
            matAd.get(i).remove(select);
        }
        matAd.remove(select);
    }

    @Override
    public void union(Object x, Object y) throws NodoNoExistenteException{
        int va, vb;
        va = numVertice((String) x);
        vb = numVertice((String) y);
        if (va < 0 || vb < 0){
            throw new NodoNoExistenteException ("Nodo no existe");
        }
        matAd.get(va).set(vb, 1);
        matAd.get(vb).set(va, 1);
    }

    @Override
    public boolean buscarProfundidad(Object x) throws PilaLlenaException, PilaVaciaException{
        String verticeBuscado = (String)x;
        boolean encontrado = false;
        Pila porProcesar = new Pila(numVerts);
        ArrayList<Vertice> procesados = new ArrayList<Vertice>();
        int index=0;
        boolean procesado=false;
        //String vertisProces = "";
        Vertice verticeActual;
        
        porProcesar.push(this.verts.get(index));
        
        while (procesados.size() != this.numVerts){
            verticeActual = (Vertice) porProcesar.pop();
            /*
            System.out.println("Nodo actual: " + verticeActual.nombre);
            if (!procesados.isEmpty()) {
                vertisProces="";
                for (int p = 0; p < procesados.size(); p++) {
                    vertisProces += procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + vertisProces);
            */
            
            for(int i=0; i<this.numVerts; i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if(verts.get(i) == procesados.get(j)){
                        procesado=true;
                    }
                }
                if(matAd.get(verticeActual.numVertice).get(i)==1 && procesado==false){
                    porProcesar.push(verts.get(i));
                }
            }
            procesados.add(verticeActual);
            for (int i = 0; i < procesados.size(); i++) {
                if (verticeBuscado.compareTo(procesados.get(i).nombre) == 0) {
                    encontrado = true;
                    return encontrado;
                }
            }
            //porProcesar.pop();
            index++;
        }
        return encontrado;
    }

    @Override
    public boolean buscarAmplitud(Object x) throws ColaLlenaException, ColaVaciaException{
        String verticeBuscado = (String)x;
        boolean encontrado = false;
        ColaMatriz porProcesar = new ColaMatriz();
        ArrayList<Vertice> procesados = new ArrayList<Vertice>();
        int index=0;
        boolean procesado=false;
        //String vertisProces = "";
        
        porProcesar.insert(this.verts.get(index));
        
        while (procesados.size() != this.numVerts) {
            /*
            System.out.println("Nodo actual: " + porProcesar.front().nombre);
            if(!procesados.isEmpty()){
                vertisProces="";
                for (int p = 0; p < procesados.size(); p++) {
                    vertisProces += procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + vertisProces);
            */

            for(int i=0; i<this.numVerts; i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if(verts.get(i) == procesados.get(j)){
                        procesado=true;
                    }
                }
                if(matAd.get(porProcesar.front().numVertice).get(i)==1 && procesado==false){
                    porProcesar.insert(verts.get(i));
                }
            }
            
            procesados.add(porProcesar.front());
            porProcesar.remove();
            for (int i = 0; i < procesados.size(); i++) {
                if (verticeBuscado.compareTo(procesados.get(i).nombre) == 0) {
                    encontrado = true;
                    return encontrado;
                }
            }
            index++;
        }
        return encontrado;
    }

    @Override
    public void recorrerProfundidad() throws PilaLlenaException, PilaVaciaException{
        Pila porProcesar = new Pila(numVerts);
        ArrayList<Vertice> procesados = new ArrayList<Vertice>();
        int index=0;
        boolean procesado=false;
        String vertisProces = "";
        Vertice verticeActual;
        
        porProcesar.push(this.verts.get(index));
        
        while (procesados.size() != this.numVerts){
            verticeActual = (Vertice) porProcesar.pop();
            System.out.println("Nodo actual: " + verticeActual.nombre);
            if (!procesados.isEmpty()) {
                vertisProces="";
                for (int p = 0; p < procesados.size(); p++) {
                    vertisProces += procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + vertisProces);
            
            for(int i=0; i<this.numVerts; i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if(verts.get(i) == procesados.get(j)){
                        procesado=true;
                    }
                }
                if(matAd.get(verticeActual.numVertice).get(i)==1 && procesado==false){
                    porProcesar.push(verts.get(i));
                }
            }
            procesados.add(verticeActual);
            //porProcesar.pop();
            index++;
        }
        System.out.println("\nRecorrido de profundidad listo, todos los vértices han sido procesados :) \n");
    }

    @Override
    public void recorrerAmplitud() throws ColaLlenaException, ColaVaciaException{
        ColaMatriz porProcesar = new ColaMatriz();
        ArrayList<Vertice> procesados = new ArrayList<Vertice>();
        int index=0;
        boolean procesado=false;
        String vertisProces = "";
        
        porProcesar.insert(this.verts.get(index));
        
        while (procesados.size() != this.numVerts) {
            System.out.println("Nodo actual: " + porProcesar.front().nombre);
            if(!procesados.isEmpty()){
                vertisProces="";
                for (int p = 0; p < procesados.size(); p++) {
                    vertisProces += procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + vertisProces);


            for(int i=0; i<this.numVerts; i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if(verts.get(i) == procesados.get(j)){
                        procesado=true;
                    }
                }
                if(matAd.get(porProcesar.front().numVertice).get(i)==1 && procesado==false){
                    porProcesar.insert(verts.get(i));
                }
            }
            procesados.add(porProcesar.front());
            porProcesar.remove();
            index++;
        }
        System.out.println("\nRecorrido de anchura listo, todos los vértices han sido procesados :) \n");
    }
}

package modelo;

import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import java.util.ArrayList;

/**
 *
 * @author plupy
 */
public class GrafoMatriz extends Grafo{
    int numVerts;
    static final int maxVerts = 20;            
    Vertice [] verts;
    int [][] matAd;
    
    public GrafoMatriz(int mx){
        matAd = new int [mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++)
            for (int j = 0; i < mx; i++)   //¿es i lo que debe sumar o j?
                matAd[i][j] = 0;    
        numVerts = 0;       //¿va dentro del for o fuera?
    }
    
    public GrafoMatriz(){
        this(maxVerts);    
    }
    
    public int numeroDeVertices(){
        return numVerts;    
    }
    
    public Vertice[] vertices(){
        return verts;    
    }
    
    public int[][] getMatriz(){
        return matAd;
    }
    
    int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;){
            encontrado = verts[i].equals(v);
            if (!encontrado){
                i++;
            } 
        }
        return (i < numVerts) ? i : -1 ;
    }
    
    public void printMatAd( int mat[][], int n ){
        for (int i = 0; i < n; i++) {
            String strMat = " ";
            for (int j = 0; j < n; j++) {
                strMat += mat[i][j] + " ";
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
        if(matAd[va][vb] == 0){
            throw new ArcoNoExistenteExcepcion("Arco no existe");
        }
        else{
            matAd[va][vb]=0;
        }
    }

    @Override
    public boolean Adyacente(Object x, Object y) throws NodoNoExistenteException{
        int va, vb;
        va = numVertice((String) x);
        vb = numVertice((String) y);
        if (va < 0 || vb < 0){
            throw new NodoNoExistenteException("Nodo no existe");
        }
        return matAd[va][vb] == 1;
    }

    @Override
    public void nuevoVertice(Object x) throws NodoYaExistenteException{
        boolean esta = numVertice((String) x) >= 0;
        if (!esta) {
            Vertice v = new Vertice((String) x); 
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
        else{
            throw new NodoYaExistenteException("El nodo ingresado ya existe");
        }
    }

    @Override
    public void borrarVertice(Object x) throws NodoNoExistenteException{
        
    }

    @Override
    public void union(Object x, Object y) throws NodoNoExistenteException{
        int va, vb;
        va = numVertice((String) x);
        vb = numVertice((String) y);
        if (va < 0 || vb < 0){
            throw new NodoNoExistenteException ("Nodo no existe");
        }
        matAd[va][vb] = 1;
    }

    @Override
    public boolean buscarProfundidad(Object x) {
        return false;
    }

    @Override
    public boolean buscarAmplitud(Object x) {
        return false;
    }

    @Override
    public void recorrerProfundidad() {
        
    }

    @Override
    public void recorrerAmplitud() throws ColaLlenaException, ColaVaciaException{
        Cola porProcesar = new Cola();
        ArrayList<Vertice> procesados = new ArrayList<Vertice>();
        int index=0;
        boolean procesado=false;
        String vertisProces = "";
        
        porProcesar.insert(this.verts[index]);
        
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
                    if(verts[i] == procesados.get(j)){
                        procesado=true;
                    }
                }
                if(matAd[porProcesar.front().numVertice][i]==1 && procesado==false){
                    porProcesar.insert(verts[i]);
                }
            }
            procesados.add(porProcesar.front());
            porProcesar.remove();
            index++;
        }
        
        System.out.println("\nRecorrido de anchura listo, todos los vértices han sido procesados :)");
    }
}
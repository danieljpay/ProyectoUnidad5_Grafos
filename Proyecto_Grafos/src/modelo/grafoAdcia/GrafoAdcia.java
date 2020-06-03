package modelo.grafoAdcia;

import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import excepciones.PilaLlenaException;
import excepciones.PilaVaciaException;
import java.util.ArrayList;
import modelo.Grafo;
import modelo.Lista;
import modelo.Pila;

//NOTA: REQUIERE CODIGO DE LISTA GENERICA
public class GrafoAdcia extends Grafo{
    int numVerts;
    ArrayList<VerticeAdy> tablAdc;

    public GrafoAdcia(){
        tablAdc = new ArrayList<VerticeAdy>();
        numVerts = 0;
    }

    public int numeroDeVertices(){
        return numVerts;
    }      

    public ArrayList<VerticeAdy> vertices(){ 
        return tablAdc;
    }     

    //La operación listaAdyc()devuelve la lista de adyacencia del vértice v.
    public Lista listaAdyc(int v)throws Exception{
        if (v < 0 || v >= numVerts){ 
            throw new Exception(" Vértice fuera de rango ");
        }
        return tablAdc.get(v).lad;
    }
    
    // numVertice() busca el vértice en la tabla. 
    // Devuelve -1 si no lo encuentra:
    public int numVertice(String nm){
        VerticeAdy v = new VerticeAdy(nm);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado; ){
            encontrado = tablAdc.get(i).equals(v);
            if (!encontrado){
                i++ ;
            } 
        }
        return (i < numVerts) ? i : -1 ;
    }
    
    public void imprimir() {
        for(int i=0; i < tablAdc.size(); i++){
            System.out.println(tablAdc.get(i).nombre + tablAdc.get(i).getLad().toString(tablAdc));
        }
    }
    
    public String impresion() {
        String print = "";
        for(int i=0; i < tablAdc.size(); i++){
            print += tablAdc.get(i).nombre + tablAdc.get(i).getLad().toString(tablAdc) + "\n";
        }
        return print;
    }
    
    //****************************************************métodos abstractos****************************************************

    @Override
    public void borrarArco(Object x, Object y) throws ArcoNoExistenteExcepcion, NodoNoExistenteException {
        int va, vb;
        va = numVertice((String) x);
        vb = numVertice((String) y);
        if (va < 0 || vb < 0){
            throw new NodoNoExistenteException ("Vértice no existe");
        }
        if (tablAdc.get(va).getLad().buscarLista(new Arco(vb)) == null) {    //Si no encuentras el nodo vb dentro del nodo va
            throw new ArcoNoExistenteExcepcion("Arco no existe");       //entonces no existe el arco
        }
        else{
            Arco ab = new Arco(vb);
            Arco bc = new Arco(va);
            tablAdc.get(va).getLad().eliminar(ab); 
            tablAdc.get(vb).getLad().eliminar(bc);
        }
    }

    @Override
    public boolean adyacente(Object x, Object y) throws NodoNoExistenteException {
        int va, vb;
        va = numVertice((String)x);
        vb = numVertice((String)y);
        if (va < 0 || vb < 0){
            throw new NodoNoExistenteException ("Vértice no existe");
        }
        if (tablAdc.get(va).lad.buscarLista(new Arco(vb)) != null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void nuevoVertice(Object x) throws NodoYaExistenteException {
        boolean esta = numVertice((String) x) >= 0;
        if (!esta){
            VerticeAdy v = new VerticeAdy((String) x); 
            v.asigVert(numVerts);
            tablAdc.add(v);
            numVerts++;
        }
    }
    
    //el problema es que los arcos tienen el destino a los números antes de que el array se elimine
    @Override
    public void borrarVertice(Object x) throws NodoNoExistenteException {
        int select = numVertice((String) x);    //obtengo el número del vértice que eliminaré
        boolean esta = select >= 0;
        if(!esta){
            throw new NodoNoExistenteException("Nodo no existe");
        }
        numVerts--;
        Arco arcoPorBorrar = new Arco(select);
        for (int i = 0; i < tablAdc.size(); i++) {
            //a cada vértice se le elimina el arco x
            for (int j = 0; j < tablAdc.get(i).getLad().getListita().size(); j++) {
                if (tablAdc.get(i).getLad().getListita().get(j).getDestino() == select) {
                    tablAdc.get(i).getLad().eliminar(arcoPorBorrar);
                }
            }
            //acomoda el destino de los arcos
            //if (select != tablAdc.size()-1) {
                for (int k = 0; k < tablAdc.get(i).getLad().getListita().size(); k++) {
                    if (tablAdc.get(i).getLad().getListita().get(k).getDestino()>select) {
                        tablAdc.get(i).getLad().getListita().get(k).setDestino(tablAdc.get(i).getLad().getListita().get(k).getDestino()-1);
                    }
                }
            //}
            //acomoda el número de los vértices
            if (tablAdc.get(i).getNumVertice()>select) {
                tablAdc.get(i).asigVert(tablAdc.get(i).getNumVertice()-1);
            }
        }
        //elimina el vértice
        tablAdc.remove(select);
    }

    @Override
    public void union(Object x, Object y) throws NodoNoExistenteException {
        if (!adyacente(x, y)){
            int va = numVertice((String) x);
            int vb = numVertice((String) y);
            if (va < 0 || vb < 0){
                throw new NodoNoExistenteException("Vértice no existe");
            }
            //si el nombre es distinto entonces a ambos vértices se le crean arcos para la interconexión
            if (va != vb) {
                Arco ab = new Arco(vb);
                Arco cd = new Arco(va);
                tablAdc.get(va).lad.insertarCabezaLista(ab);
                tablAdc.get(vb).lad.insertarCabezaLista(cd);
            }
            //si es el mismo nombre, al vértice solamente se crea un arco a sí mismo
            else{
                Arco ab = new Arco(vb);
                tablAdc.get(va).lad.insertarCabezaLista(ab);
            }
        }     
    }

    @Override
    public boolean buscarProfundidad(Object x) throws PilaLlenaException, PilaVaciaException {
        String verticeBuscado = (String)x;
        boolean encontrado = false;
        ArrayList<VerticeAdy> procesados = new ArrayList<VerticeAdy>();
        Pila porProcesar = new Pila(numVerts);
        ArrayList<Arco> listaAdy = new ArrayList<Arco>();
        boolean procesado = false;
        String prosados = "";
        VerticeAdy verticeActual;
        
        porProcesar.push(this.tablAdc.get(0));
        
        while (procesados.size() != tablAdc.size()) {
            verticeActual = (VerticeAdy) porProcesar.pop();
            /*
            System.out.println("Nodo actual: " + verticeActual.nomVertice());
            prosados="";
            if(!procesados.isEmpty()){
                for (int p = 0; p < procesados.size(); p++) {
                    prosados+= procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + prosados);
            */

            listaAdy = verticeActual.getLad().getListita();
            for(int i=0; i<listaAdy.size(); i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if( tablAdc.get(listaAdy.get(i).getDestino()) == procesados.get(j) ){
                        procesado=true;
                    }
                }
                if (procesado == false) {
                    porProcesar.push(this.tablAdc.get(listaAdy.get(i).getDestino()));
                }
            }
            procesados.add(verticeActual);
            for (int i = 0; i < procesados.size(); i++) {
                if (verticeBuscado.compareTo(procesados.get(i).nomVertice()) == 0) {
                    encontrado=true;
                    return encontrado;
                }
            }
            //porProcesar.remove();
        }
        return encontrado;
    }

    @Override
    public boolean buscarAmplitud(Object x) throws ColaLlenaException, ColaVaciaException {
        String verticeBuscado = (String)x;
        boolean encontrado = false;
        ArrayList<VerticeAdy> procesados = new ArrayList<VerticeAdy>();
        ColaAdcia porProcesar = new ColaAdcia();
        ArrayList<Arco> listaAdy = new ArrayList<Arco>();
        boolean procesado = false;
        String prosados = "";
        
        porProcesar.insert(this.tablAdc.get(0));
        
        while (procesados.size() != tablAdc.size()) {
            System.out.println("Nodo actual: " + porProcesar.front().nomVertice());
            prosados="";
            if(!procesados.isEmpty()){
                for (int p = 0; p < procesados.size(); p++) {
                    prosados+= procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + prosados);
            
            listaAdy = porProcesar.front().lad.getListita();
            for(int i=0; i<listaAdy.size(); i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if( tablAdc.get(listaAdy.get(i).destino) == procesados.get(j) ){
                        procesado=true;
                    }
                }
                if (procesado == false) {
                    porProcesar.insert(this.tablAdc.get(listaAdy.get(i).destino));
                }
            }
            procesados.add(porProcesar.front());
            for (int i = 0; i < procesados.size(); i++) {
                if (verticeBuscado.compareTo(procesados.get(i).nomVertice()) == 0) {
                    encontrado=true;
                    return encontrado;
                }
            }
            porProcesar.remove();
        }
        return encontrado;
    }

    @Override
    public void recorrerProfundidad() throws PilaLlenaException, PilaVaciaException {
        ArrayList<VerticeAdy> procesados = new ArrayList<VerticeAdy>();
        Pila porProcesar = new Pila(numVerts);
        ArrayList<Arco> listaAdy = new ArrayList<Arco>();
        boolean procesado = false;
        String prosados = "";
        VerticeAdy verticeActual;
        
        porProcesar.push(this.tablAdc.get(0));
        
        while (procesados.size() != tablAdc.size()) {
            verticeActual = (VerticeAdy) porProcesar.pop();
            System.out.println("Nodo actual: " + verticeActual.nomVertice());
            prosados="";
            if(!procesados.isEmpty()){
                for (int p = 0; p < procesados.size(); p++) {
                    prosados+= procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + prosados);
            
            listaAdy = verticeActual.getLad().getListita();
            for(int i=0; i<listaAdy.size(); i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if( tablAdc.get(listaAdy.get(i).getDestino()) == procesados.get(j) ){
                        procesado=true;
                    }
                }
                if (procesado == false) {
                    porProcesar.push(this.tablAdc.get(listaAdy.get(i).getDestino()));
                }
            }
            procesados.add(verticeActual);
            //porProcesar.remove();
        }
        
        System.out.println("\nRecorrido de anchura listo, todos los vértices han sido procesados :)");
        
    }

    @Override
    public void recorrerAmplitud() throws ColaLlenaException, ColaVaciaException {
        ArrayList<VerticeAdy> procesados = new ArrayList<VerticeAdy>();
        ColaAdcia porProcesar = new ColaAdcia();
        ArrayList<Arco> listaAdy = new ArrayList<Arco>();
        boolean procesado = false;
        String prosados = "";
        
        porProcesar.insert(this.tablAdc.get(0));
        
        while (procesados.size() != tablAdc.size()) {
            System.out.println("Nodo actual: " + porProcesar.front().nomVertice());
            prosados="";
            if(!procesados.isEmpty()){
                for (int p = 0; p < procesados.size(); p++) {
                    prosados+= procesados.get(p).nombre + " ";
                }
            }
            System.out.println("Procesados: " + prosados);
            
            listaAdy = porProcesar.front().lad.getListita();
            for(int i=0; i<listaAdy.size(); i++){
                procesado=false;
                for(int j=0; j<procesados.size(); j++){
                    if( tablAdc.get(listaAdy.get(i).destino) == procesados.get(j) ){
                        procesado=true;
                    }
                }
                if (procesado == false) {
                    porProcesar.insert(this.tablAdc.get(listaAdy.get(i).destino));
                }
            }
            procesados.add(porProcesar.front());
            porProcesar.remove();
        }
        
        System.out.println("\nRecorrido de anchura listo, todos los vértices han sido procesados :)");
    }
    
 }  //fin clase






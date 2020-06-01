package modelo;

import modelo.grafoAdcia.Arco;
import modelo.grafoAdcia.VerticeAdy;
import java.util.ArrayList;

/**
 *
 * @author plupy
 */
public class Lista {
    private ArrayList<Arco> listita = new ArrayList<Arco>();

    public Lista() {
    }

    public ArrayList<Arco> getListita() {
        return listita;
    }
    
    //insertar arco 
    public void insertarCabezaLista(Arco unArco){
        this.listita.add(unArco);
    }
    
    //eliminar arco coincidente
    public void eliminar(Arco unArco){
        this.listita.remove(unArco);
    }
    
    //busqueda dentro de la lista
    public Arco buscarLista(Arco unArco){
        Arco encontrado = null;
        for(int i=0; i< this.listita.size(); i++){
            if(unArco.getDestino() == this.listita.get(i).getDestino()){
                encontrado = this.listita.get(i);
                return encontrado;
            }
        }
        return encontrado;
    }
    
    //imprimir los arcos en la lista
    public String toString(ArrayList<VerticeAdy> vertis) {
        String cadena = " ";
        for(int a=0; a<listita.size(); a++){
            cadena += " -> " + vertis.get( listita.get(a).getDestino() ).nomVertice();
        }
        return cadena;
    }
}

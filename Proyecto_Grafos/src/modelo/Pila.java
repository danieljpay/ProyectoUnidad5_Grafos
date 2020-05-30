package modelo;

import excepciones.PilaLlenaException;
import excepciones.PilaVaciaException;

/**
 * @author Daniel J. Pérez
 */
public class Pila {
    Object pila[];
    int cima;
    
    public Pila(int tamanio) {  //constructor
        this.pila = new Object[tamanio];
        this.cima = -1;
    }
    
    public void push(Object dato) throws PilaLlenaException{
        cima++;
        pila[cima] = dato;
    }
    
    public Object pop() throws PilaVaciaException{
        Object recuperado = pila[cima];
        /*pila[cima]=null;*/
        cima--;
        return recuperado;
    }
    
    public Object peek() throws PilaVaciaException{
        return pila[cima];
    }
    
    public boolean isEmpty(){
        return cima==-1;   //devuelve true o false 
    }
    
    public int size(){
        return pila.length;
    }

    public int getCima() {
        return cima;
    }
    
}

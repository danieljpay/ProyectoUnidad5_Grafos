package modelo;

import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;

/**
 * @author plupy
 */
public abstract class Grafo {
    
    public abstract void borrarArco(Object x, Object y) throws ArcoNoExistenteExcepcion, NodoNoExistenteException;
    
    public abstract boolean Adyacente(Object x, Object y) throws NodoNoExistenteException;
    
    public abstract void nuevoVertice(Object x) throws NodoYaExistenteException;
    
    public abstract void borrarVertice(Object x) throws NodoNoExistenteException;
    
    public abstract void union(Object x, Object y) throws NodoNoExistenteException;
    
    public abstract boolean buscarProfundidad(Object x);
    
    public abstract boolean buscarAmplitud(Object x);    
    
    public abstract void recorrerProfundidad();
    
    public abstract void recorrerAmplitud() throws ColaLlenaException, ColaVaciaException;
    
}

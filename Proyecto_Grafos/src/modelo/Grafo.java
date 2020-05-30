package modelo;

import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import excepciones.PilaLlenaException;
import excepciones.PilaVaciaException;

/**
 * @author Daniel J. Pérez
 */
public abstract class Grafo {
    
    public abstract void borrarArco(Object x, Object y) throws ArcoNoExistenteExcepcion, NodoNoExistenteException;
    
    public abstract boolean Adyacente(Object x, Object y) throws NodoNoExistenteException;
    
    public abstract void nuevoVertice(Object x) throws NodoYaExistenteException;
    
    public abstract void borrarVertice(Object x) throws NodoNoExistenteException;
    
    public abstract void union(Object x, Object y) throws NodoNoExistenteException;
    
    public abstract boolean buscarProfundidad(Object x) throws PilaLlenaException, PilaVaciaException;
    
    public abstract boolean buscarAmplitud(Object x) throws ColaLlenaException, ColaVaciaException;    
    
    public abstract void recorrerProfundidad() throws PilaLlenaException, PilaVaciaException;
    
    public abstract void recorrerAmplitud() throws ColaLlenaException, ColaVaciaException;
    
}

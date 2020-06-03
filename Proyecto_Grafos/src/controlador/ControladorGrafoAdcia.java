/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import excepciones.PilaLlenaException;
import excepciones.PilaVaciaException;
import modelo.grafoAdcia.GrafoAdcia;

/**
 *
 * @author plupy
 */
public class ControladorGrafoAdcia {
    private GrafoAdcia grafiti;

    public ControladorGrafoAdcia() {
        grafiti = new GrafoAdcia();
    }
    
    public void nuevoVertice(Object nombre) throws NodoYaExistenteException{
        grafiti.nuevoVertice(nombre);
    }
    
    public void eliminarVertice(Object nombre) throws NodoNoExistenteException{
        grafiti.borrarVertice(nombre);
    }
    
    public void nuevoArco(Object nombreUno, Object nombreDos) throws NodoNoExistenteException{
        grafiti.union(nombreUno, nombreDos);
    }
    
    public void borrarArco(Object nombreUno, Object nombreDos) throws ArcoNoExistenteExcepcion, NodoNoExistenteException{
        grafiti.borrarArco(nombreUno, nombreDos);
    }
    
    public boolean adyacente(Object nombreUno, Object nombreDos) throws NodoNoExistenteException{
        return grafiti.adyacente(nombreUno, nombreDos);
    }
    
    public boolean buscarProfundidad(Object nombre) throws PilaLlenaException, PilaVaciaException{
        return grafiti.buscarProfundidad(nombre);
    }
    
    public boolean buscarAmplitud(Object nombre) throws ColaLlenaException, ColaVaciaException{
        return grafiti.buscarAmplitud(nombre);
    }
    
    public String impresion(){
        return grafiti.impresion();
    }
}

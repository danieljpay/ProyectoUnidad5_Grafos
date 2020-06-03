/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import controlador.ControladorGrafoAdcia;
import controlador.ControladorGrafoMatriz;
import javax.swing.JOptionPane;
import vista.FrMenu;

/**
 *
 * @author plupy
 */
public class Launcher {
    
    public static void main(String[] args) {
        ControladorGrafoMatriz contrGrafMatr = new ControladorGrafoMatriz(Integer.parseInt(JOptionPane.showInputDialog("Primero ingresa el número total de nodos deseados")));
        ControladorGrafoAdcia contrGrafAdcia = new ControladorGrafoAdcia();
        FrMenu menuPrincipal = new FrMenu(contrGrafMatr, contrGrafAdcia);
        menuPrincipal.setVisible(true);
    }
    
}

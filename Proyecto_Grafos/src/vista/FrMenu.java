/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorGrafoAdcia;
import controlador.ControladorGrafoMatriz;
import excepciones.ArcoNoExistenteExcepcion;
import excepciones.ColaLlenaException;
import excepciones.ColaVaciaException;
import excepciones.NodoNoExistenteException;
import excepciones.NodoYaExistenteException;
import excepciones.PilaLlenaException;
import excepciones.PilaVaciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author plupy
 */
public class FrMenu extends javax.swing.JFrame {
    ControladorGrafoMatriz ctrlGM;
    ControladorGrafoAdcia ctrlGA;
    String nombrar = "restantes por nombrar";
    int numVertis;

    /**
     * Creates new form FrMenu
     */
    public FrMenu(ControladorGrafoMatriz ctrlGM, ControladorGrafoAdcia ctrlGA) {
        initComponents();
        OpcionGrafos.add(rdGrafoMatriz);
        OpcionGrafos.add(rdGrafoMatriz);
        this.ctrlGM = ctrlGM;
        this.ctrlGA = ctrlGA;
        numVertis = ctrlGM.numeroVertices();
        lbRestantesPorNombrar.setText(nombrar + " " + numVertis);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpcionGrafos = new javax.swing.ButtonGroup();
        lbTitle = new javax.swing.JLabel();
        btnAgregarVertice = new javax.swing.JButton();
        lbAgregarNodos = new javax.swing.JLabel();
        txtNombreVertice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPartidaArco = new javax.swing.JTextField();
        btnAgregarArco = new javax.swing.JButton();
        txtDestinoArco = new javax.swing.JTextField();
        lbPartidaArco = new javax.swing.JLabel();
        lbDestinoArco = new javax.swing.JLabel();
        btnEliminarVertice = new javax.swing.JButton();
        btnEliminarArco = new javax.swing.JButton();
        lbBusquedas = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdGrafoMatriz = new javax.swing.JRadioButton();
        rdGrafoAdy = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPantalla = new javax.swing.JTextArea();
        btnVisualizarGrafo = new javax.swing.JButton();
        lbNúmeroVertice = new javax.swing.JLabel();
        lbRestantesPorNombrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTitle.setText("Menú grafo");

        btnAgregarVertice.setText("Agregar vértice");
        btnAgregarVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVerticeActionPerformed(evt);
            }
        });

        lbAgregarNodos.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        lbAgregarNodos.setText("Vértices");

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel1.setText("Arcos");

        btnAgregarArco.setText("Agregar arco");
        btnAgregarArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArcoActionPerformed(evt);
            }
        });

        lbPartidaArco.setText("Ingresa de qué vértice partirá el arco:");

        lbDestinoArco.setText("Ingresa a qué vértice irá el arco:");

        btnEliminarVertice.setText("Eliminar vértice");
        btnEliminarVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVerticeActionPerformed(evt);
            }
        });

        btnEliminarArco.setText("Eliminar arco");
        btnEliminarArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArcoActionPerformed(evt);
            }
        });

        lbBusquedas.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        lbBusquedas.setText("Búsquedas");

        jButton1.setText("Buscar por profundidad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar por amplitud");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel2.setText("Grafo");

        jLabel3.setText("Escoge el tipo de grafo que deseas:");

        rdGrafoMatriz.setText("Grafo matriz");

        rdGrafoAdy.setText("Grafo lista adyacente");

        txtPantalla.setColumns(20);
        txtPantalla.setRows(5);
        jScrollPane1.setViewportView(txtPantalla);

        btnVisualizarGrafo.setText("Visualizar grafo");
        btnVisualizarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarGrafoActionPerformed(evt);
            }
        });

        lbNúmeroVertice.setText("Ingresa los nombres de los vértices (uno por uno)");

        lbRestantesPorNombrar.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(rdGrafoMatriz)
                        .addGap(46, 46, 46)
                        .addComponent(rdGrafoAdy))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbAgregarNodos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(lbTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbRestantesPorNombrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDestinoArco)
                                        .addComponent(jLabel1)
                                        .addComponent(lbPartidaArco))
                                    .addGap(188, 188, 188))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtDestinoArco)
                                    .addGap(62, 62, 62)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbNúmeroVertice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEliminarArco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregarArco))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEliminarVertice)
                                    .addGap(91, 91, 91)
                                    .addComponent(btnAgregarVertice))
                                .addComponent(txtNombreVertice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPartidaArco, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVisualizarGrafo)
                            .addComponent(lbBusquedas)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdGrafoMatriz)
                                    .addComponent(rdGrafoAdy))
                                .addGap(18, 18, 18)
                                .addComponent(lbAgregarNodos)
                                .addGap(21, 21, 21))
                            .addComponent(lbNúmeroVertice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbRestantesPorNombrar)
                        .addGap(9, 9, 9)
                        .addComponent(txtNombreVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBusquedas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarVertice)
                            .addComponent(btnEliminarVertice))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPartidaArco)
                        .addGap(12, 12, 12)
                        .addComponent(txtPartidaArco, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbDestinoArco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDestinoArco, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarArco)
                            .addComponent(btnEliminarArco)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVisualizarGrafo)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVerticeActionPerformed
        //btnNuevoVertice
        if (rdGrafoMatriz.isSelected()) {
            try {
                ctrlGM.nuevoVertice(txtNombreVertice.getText());
                txtNombreVertice.setText("");
                numVertis--;
                lbRestantesPorNombrar.setText(nombrar + " " + numVertis);
            } catch (NodoYaExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo ya existente");
            }
        }
        else if(rdGrafoAdy.isSelected()){
            try {
                ctrlGA.nuevoVertice(txtNombreVertice.getText());
                txtNombreVertice.setText("");
                numVertis--;
                lbRestantesPorNombrar.setText(nombrar + " " + numVertis);
            } catch (NodoYaExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo ya existente");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Primero selecciona qué tipo grafo usarás");
        }
    }//GEN-LAST:event_btnAgregarVerticeActionPerformed

    private void btnEliminarVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVerticeActionPerformed
        //btnEliminarVertice
        if (rdGrafoMatriz.isSelected()) {
            try {
                ctrlGM.eliminarVertice(txtNombreVertice.getText());
                txtNombreVertice.setText("");
            } catch (NodoNoExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo no existente");
            }
        }
        else if(rdGrafoAdy.isSelected()){
            try {
                ctrlGA.eliminarVertice(txtNombreVertice.getText());
                txtNombreVertice.setText("");
            } catch (NodoNoExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo no existente");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Primero selecciona qué tipo grafo usarás");
        }
    }//GEN-LAST:event_btnEliminarVerticeActionPerformed

    private void btnAgregarArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArcoActionPerformed
        //btnAgregarArco
        if (rdGrafoMatriz.isSelected()) {
            try {
                ctrlGM.nuevoArco(txtPartidaArco.getText(), txtDestinoArco.getText());
                txtPartidaArco.setText("");
                txtDestinoArco.setText("");
                btnVisualizarGrafo.doClick();
            } catch (NodoNoExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo no existente");
            }
        }
        else if(rdGrafoAdy.isSelected()){
            try {
                ctrlGA.nuevoArco(txtPartidaArco.getText(), txtDestinoArco.getText());
                txtPartidaArco.setText("");
                txtDestinoArco.setText("");
                btnVisualizarGrafo.doClick();
            } catch (NodoNoExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo no existente");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Primero selecciona qué tipo grafo usarás");
        }
    }//GEN-LAST:event_btnAgregarArcoActionPerformed

    private void btnEliminarArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArcoActionPerformed
        //btnEliminarArco
        if (rdGrafoMatriz.isSelected()) {
            try {
                ctrlGM.borrarArco(txtPartidaArco.getText(), txtDestinoArco.getText());
                txtPartidaArco.setText("");
                txtDestinoArco.setText("");
                btnVisualizarGrafo.doClick();
            } catch (ArcoNoExistenteExcepcion ex) {
                JOptionPane.showMessageDialog(this, "Arco no existente");
            } catch (NodoNoExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo no existente");
            }
        }
        else if(rdGrafoAdy.isSelected()){
            try {
                ctrlGA.borrarArco(txtPartidaArco.getText(), txtDestinoArco.getText());
                txtPartidaArco.setText("");
                txtDestinoArco.setText("");
                btnVisualizarGrafo.doClick();
            } catch (ArcoNoExistenteExcepcion ex) {
                JOptionPane.showMessageDialog(this, "Arco no existente");
            } catch (NodoNoExistenteException ex) {
                JOptionPane.showMessageDialog(this, "Nodo no existente");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Primero selecciona qué tipo grafo usarás");
        }
    }//GEN-LAST:event_btnEliminarArcoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //btnBuscarPorProfundidad
        if (rdGrafoMatriz.isSelected()) {
            try {
                if (ctrlGM.buscarProfundidad(txtBusqueda.getText())) {
                    JOptionPane.showMessageDialog(this, "Vértice encontrado :)");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Vértice no encontrado :(");
                }
                txtBusqueda.setText("");
            } catch (PilaLlenaException ex) {
                JOptionPane.showMessageDialog(this, "Pila llena");
            } catch (PilaVaciaException ex) {
                JOptionPane.showMessageDialog(this, "Pila vacía");
            }
        }
        else if(rdGrafoAdy.isSelected()){
            try {
                if (ctrlGA.buscarProfundidad(txtBusqueda.getText())) {
                    JOptionPane.showMessageDialog(this, "Vértice encontrado :)");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Vértice no encontrado :(");
                }
                txtBusqueda.setText("");
            } catch (PilaLlenaException ex) {
                JOptionPane.showMessageDialog(this, "Pila llena");
            } catch (PilaVaciaException ex) {
                JOptionPane.showMessageDialog(this, "Pila vacía");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Primero selecciona qué tipo grafo usarás");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //BtnBuscarPorAmplitud
        if (rdGrafoMatriz.isSelected()) {
            try {
                if (ctrlGM.buscarAmplitud(txtBusqueda.getText())) {
                    JOptionPane.showMessageDialog(this, "Vértice encontrado :)");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Vértice no encontrado :(");
                }
                txtBusqueda.setText("");
            } catch (ColaLlenaException ex) {
                JOptionPane.showMessageDialog(this, "Cola llena");
            } catch (ColaVaciaException ex) {
                JOptionPane.showMessageDialog(this, "Cola vacía");
            }
        }
        else if(rdGrafoAdy.isSelected()){
            try {
                if (ctrlGA.buscarAmplitud(txtBusqueda.getText())) {
                    JOptionPane.showMessageDialog(this, "Vértice encontrado :)");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Vértice no encontrado :(");
                }
                txtBusqueda.setText("");
            } catch (ColaLlenaException ex) {
                JOptionPane.showMessageDialog(this, "Cola llena");
            } catch (ColaVaciaException ex) {
                JOptionPane.showMessageDialog(this, "Cola vacía");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Primero selecciona qué tipo grafo usarás");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnVisualizarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarGrafoActionPerformed
        //btnVisualizarGrafo
        txtPantalla.setText("");
        if (rdGrafoMatriz.isSelected()) {
            txtPantalla.setText(ctrlGM.impresion());
        }
        else if(rdGrafoAdy.isSelected()){
            txtPantalla.setText(ctrlGA.impresion());
        }
        else{
            JOptionPane.showMessageDialog(this, "Primero selecciona qué tipo grafo usarás");
        }
    }//GEN-LAST:event_btnVisualizarGrafoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private ControladorGrafoMatriz ctrlGM;
            private ControladorGrafoAdcia ctrlGA;
            public void run() {
                new FrMenu(this.ctrlGM, this.ctrlGA).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup OpcionGrafos;
    private javax.swing.JButton btnAgregarArco;
    private javax.swing.JButton btnAgregarVertice;
    private javax.swing.JButton btnEliminarArco;
    private javax.swing.JButton btnEliminarVertice;
    private javax.swing.JButton btnVisualizarGrafo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAgregarNodos;
    private javax.swing.JLabel lbBusquedas;
    private javax.swing.JLabel lbDestinoArco;
    private javax.swing.JLabel lbNúmeroVertice;
    private javax.swing.JLabel lbPartidaArco;
    private javax.swing.JLabel lbRestantesPorNombrar;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JRadioButton rdGrafoAdy;
    private javax.swing.JRadioButton rdGrafoMatriz;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtDestinoArco;
    private javax.swing.JTextField txtNombreVertice;
    private javax.swing.JTextArea txtPantalla;
    private javax.swing.JTextField txtPartidaArco;
    // End of variables declaration//GEN-END:variables
}

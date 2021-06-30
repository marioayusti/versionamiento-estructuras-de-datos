/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Modelos.ArboldeVersiones;
import Modelos.ListadeObjetos;
import javax.swing.JFrame;

/**
 *
 * @author G40
 */
public class JFrame_ArbolVersiones extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_ArbolVersiones
     */
    JFrame_Editar Editar;
    JFrame_Visualizar ver;
    ArboldeVersiones arbol = new ArboldeVersiones();

    public JFrame_ArbolVersiones() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.jButton_eliminar.setEnabled(false);
    }

    public void IniciarArbolVersiones(ArboldeVersiones arbol, int actual) {
        this.arbol = arbol;
        this.arbolVisual.Actualizar(this.arbol, actual);
        this.jButton_eliminar.setEnabled(this.arbolVisual.VersionActual != 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolVisual = new Visuales.arbolVisual();
        jButton_Ver = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_UltVersiones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Versiones");

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(327670, 327670));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(25, 25));

        arbolVisual.setName(""); // NOI18N
        arbolVisual.setPreferredSize(new java.awt.Dimension(1000, 1000));
        arbolVisual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolVisualMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout arbolVisualLayout = new javax.swing.GroupLayout(arbolVisual);
        arbolVisual.setLayout(arbolVisualLayout);
        arbolVisualLayout.setHorizontalGroup(
            arbolVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        arbolVisualLayout.setVerticalGroup(
            arbolVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(arbolVisual);

        jButton_Ver.setText("Visualizar");
        jButton_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VerActionPerformed(evt);
            }
        });

        jButton_editar.setText("Modificar");
        jButton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editarActionPerformed(evt);
            }
        });

        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        jButton_UltVersiones.setText("Ultimas versiones");
        jButton_UltVersiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UltVersionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Ver)
                            .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jButton_UltVersiones)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Ver)
                        .addGap(47, 47, 47)
                        .addComponent(jButton_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(344, 344, 344))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_UltVersiones))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        this.arbolVisual.eliminar();
        this.jButton_Ver.setEnabled(false);
        this.jButton_editar.setEnabled(false);
        this.jButton_eliminar.setEnabled(false);
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_UltVersionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UltVersionesActionPerformed
        this.arbolVisual.MostrarUltimas();
        this.jButton_Ver.setEnabled(false);
        this.jButton_editar.setEnabled(false);
        this.jButton_eliminar.setEnabled(false);
    }//GEN-LAST:event_jButton_UltVersionesActionPerformed

    private void arbolVisualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolVisualMouseClicked
        if (this.arbolVisual.haySeleccion) {
            this.jButton_Ver.setEnabled(true);
            this.jButton_editar.setEnabled(true);
            this.jButton_eliminar.setEnabled(this.arbolVisual.VersionActual != 0);
        } else {
            this.jButton_Ver.setEnabled(false);
            this.jButton_editar.setEnabled(false);
            this.jButton_eliminar.setEnabled(false);
        }
    }//GEN-LAST:event_arbolVisualMouseClicked

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed
        this.Editar = new JFrame_Editar();
        this.Editar.Modificar(this.arbol, this.arbolVisual.VersionActual);
        this.Editar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_editarActionPerformed

    private void jButton_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VerActionPerformed
        this.arbol.Ubicar(this.arbolVisual.VersionActual);
        this.ver = new JFrame_Visualizar();
        this.ver.inicializar(this.arbol.temp.Lista, this.arbol.temp.getEspacioCol());
        this.ver.setVisible(true);
    }//GEN-LAST:event_jButton_VerActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_ArbolVersiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_ArbolVersiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_ArbolVersiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_ArbolVersiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_ArbolVersiones().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visuales.arbolVisual arbolVisual;
    private javax.swing.JButton jButton_UltVersiones;
    private javax.swing.JButton jButton_Ver;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

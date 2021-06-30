/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Modelos.ArboldeVersiones;
import Modelos.ListadeObjetos;
import Modelos.Version;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Popup;
import javax.swing.PopupFactory;

/**
 *
 * @author G40
 */
public class arbolVisual extends javax.swing.JPanel {

    /**
     * Creates new form arbolVisual
     */
    ArboldeVersiones arbol = new ArboldeVersiones();
    String images[] = {"SA.png", "SPR.png", "SP.png", "NS.png", "SH.png"};
    VersionV[] versionesVisuales;
    int uH = 40;
    int uV = 60;
    Rectangle selector = new Rectangle(250, 0, 20, 20);
    int VersionActual;
    boolean haySeleccion = false;

    public arbolVisual() {
        initComponents();
        this.setBounds(-250, 0, 1000, 1000);
        this.VersionActual = this.arbol.ultimaV;
        graficarArbol();
    }

    public void Actualizar(ArboldeVersiones arbol, int actual) {
        this.arbol = arbol;
        this.VersionActual = actual;
        graficarArbol();
        actualizarImagenes();
        this.repaint();
    }

    public void eliminar() {
        this.arbol.eliminar(this.VersionActual);
        this.graficarArbol();
        deseleccionar();
        this.repaint();
    }

    public void graficarArbol() {
        versionesVisuales = new VersionV[this.arbol.size(this.arbol.raiz)];
        versionesVisuales[0] = new VersionV(500, 0, 20, 20, images[this.arbol.raiz.getEstado()], 0);
        ubicarVersionesVisuales(versionesVisuales, 1, this.arbol.raiz.hija, 500, 0, max(this.arbol.raiz), (this.arbol.numHijos(0)));
    }

    public void MostrarUltimas() {
        arbol.hojas(arbol.raiz);
        int[] hojas = arbol.Hojas.retornar();
        deseleccionar();
        for (int i = 0; i < this.versionesVisuales.length; i++) {
            for (int j = 0; j < hojas.length; j++) {
                if (this.versionesVisuales[i].getNum() == hojas[j]) {
                    this.versionesVisuales[i].setImagen(images[4]);
                }
            }
        }
        repaint();
    }

    public void deseleccionar() {
        this.VersionActual = -1;
        actualizarImagenes();
        this.haySeleccion = false;
    }

    public void ubicarVersionesVisuales(VersionV[] VersionVs, int i, Version raizActual, int raizPH, int raizPV, int max, int herm) {
        raizPH -= ((max) * (herm - 1) * (20));
        raizPV += uV;
        while (raizActual != null) {
            if (raizActual.getHija() != null) {
                ubicarVersionesVisuales(VersionVs, i, raizActual.hija, raizPH, raizPV, max(raizActual), this.arbol.numHijos(raizActual.getNum()));
            }
            i = ubicarP(VersionVs);
            VersionVs[i] = new VersionV(raizPH, raizPV, 20, 20, images[raizActual.getEstado()], raizActual.getNum());
            raizActual = raizActual.getHermana();
            raizPH += max * uH;
        }
    }

    public void actualizarImagenes() {
        arbol.actualizarEstados(this.VersionActual);
        for (int i = 0; i < this.versionesVisuales.length; i++) {
            arbol.Ubicar(this.versionesVisuales[i].getNum());
            this.versionesVisuales[i].setImagen(images[arbol.temp.getEstado()]);
        }
    }

    public int ubicarP(VersionV[] VersionVs) {
        int pos = 0;
        boolean flag = false;
        for (int i = 0; i < VersionVs.length && !flag; i++) {
            if (VersionVs[i] == null) {
                flag = true;
                pos = i;
            }
        }
        return pos;
    }

    public int max(Version raiz) {
        int max = 1;
        raiz = raiz.getHija();
        while (raiz != null) {
            if (distance(raiz, 0) > max) {
                max = distance(raiz, 0);
            }
            raiz = raiz.getHermana();
        }
        return max;
    }

    public int distance(Version raiz, int a) {
        int d = 0;
        while (raiz != null) {
            if (raiz.getHija() != null) {
                d += distance(raiz.getHija(), 1);
            } else {
                d += 1;
            }
            if (a == 1) {
                raiz = raiz.getHermana();
            } else {
                raiz = null;
            }
        }
        return d;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < this.versionesVisuales.length; i++) {
            g.drawImage(this.versionesVisuales[i].getImagen().getImage(), this.versionesVisuales[i].getX(), this.versionesVisuales[i].getY(), this.versionesVisuales[i].getAncho(), this.versionesVisuales[i].getAlto(), this);
            g.drawString(this.versionesVisuales[i].getNum() + "", this.versionesVisuales[i].getX() + 5, this.versionesVisuales[i].getY());
        }
        for (int i = 0; i < this.versionesVisuales.length; i++) {
            arbol.Ubicar(this.versionesVisuales[i].getNum());
            arbol.temp = arbol.temp.hija;
            while (arbol.temp != null) {
                for (int j = 0; j < this.versionesVisuales.length; j++) {
                    if (arbol.temp.num == this.versionesVisuales[j].num) {
                        g.drawLine(this.versionesVisuales[i].getX() + 10, this.versionesVisuales[i].getY() + 20, this.versionesVisuales[j].getX() + 10, this.versionesVisuales[j].getY());
                    }
                }
                arbol.temp = arbol.temp.hermana;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        boolean flag = false;
        selector = new Rectangle(evt.getX(), evt.getY(), 20, 20);
        for (int i = 0; i < this.versionesVisuales.length && !flag; i++) {
            if (selector.intersects(new Rectangle(this.versionesVisuales[i].getX(), this.versionesVisuales[i].getY(), 20, 20))) {
                this.VersionActual = this.versionesVisuales[i].getNum();
                actualizarImagenes();
                flag = true;
                this.haySeleccion = true;
            }
        }
        if (!flag) {
            deseleccionar();
        }
        this.repaint();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

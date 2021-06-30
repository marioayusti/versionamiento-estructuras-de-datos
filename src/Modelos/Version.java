/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.Color;

/**
 *
 * @author G40
 */
public class Version {

    public ListadeObjetos Lista;
    public Color espacioCol;
    public Version hija;
    public Version hermana;
    public int num;
    public int estado;

    public Version() {
    }

    public Version(Color espacioCol) {
        this.Lista = new ListadeObjetos();
        this.espacioCol = espacioCol;
    }

    /**
     * @return the Lista
     */
    public ListadeObjetos getLista() {
        return this.Lista;
    }

    /**
     * @param Lista the Lista to set
     */
    public void setLista(ListadeObjetos Lista) {
        this.Lista = Lista;
    }

    /**
     * @return the espacioCol
     */
    public Color getEspacioCol() {
        return espacioCol;
    }

    /**
     * @param espacioCol the espacioCol to set
     */
    public void setEspacioCol(Color espacioCol) {
        this.espacioCol = espacioCol;
    }

    /**
     * @return the hija
     */
    public Version getHija() {
        return hija;
    }

    /**
     * @param hija the hija to set
     */
    public void setHija(Version hija) {
        this.hija = hija;
    }

    /**
     * @return the hermana
     */
    public Version getHermana() {
        return hermana;
    }

    /**
     * @param hermana the hermana to set
     */
    public void setHermana(Version hermana) {
        this.hermana = hermana;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import com.threed.jpct.Object3D;
import com.threed.jpct.SimpleVector;
import java.awt.Color;

/**
 *
 * @author G40
 */
public class NodoObjeto {

    public Object3D objeto;
    public int posX = 0;
    public int posY = 0;
    public int posZ = 0;
    public SimpleVector SVector = new SimpleVector(posX, posY, posZ);
    public String textura = "predeterminada";
    public NodoObjeto siguiente;
    public NodoObjeto anterior;

    public NodoObjeto(Object3D objeto, NodoObjeto siguiente, NodoObjeto anterior) {
        this.objeto = objeto;
        this.objeto.setAdditionalColor(Color.BLUE);
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoObjeto(NodoObjeto Nodo) {
        this.objeto = Nodo.getObjeto();
        this.textura = Nodo.getTextura();
        this.posX = Nodo.getPosX();
        this.posY = Nodo.getPosY();
        this.posZ = Nodo.getPosZ();
    }

    public void actSV() {
        SVector = new SimpleVector(posX, posY, posZ);
    }

    public boolean comparar(NodoObjeto objeto) {
        boolean aux = false;
        if (objeto.getObjeto().getAdditionalColor() != this.getObjeto().getAdditionalColor()) {
            aux = true;
        } else if (!(objeto.getTextura().equals(this.getTextura()))) {
            aux = true;
        } else if (objeto.getObjeto().getScale() != this.objeto.getScale()) {
            aux = true;
        } else if (objeto.getPosX() != this.getPosX() || objeto.getPosY() != this.getPosY() || objeto.getPosZ() != this.getPosZ()) {
            aux = true;
        }
        return aux;
    }

    public void Tamaño(int escala) {
        this.getObjeto().setScale(escala);
    }

    /**
     * @return the objeto
     */
    public Object3D getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Object3D objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the siguiente
     */
    public NodoObjeto getSiguiente() {

        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoObjeto siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoObjeto getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoObjeto anterior) {
        this.anterior = anterior;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        this.setSVector(new SimpleVector(posX, getPosY(), getPosZ()));
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
        this.setSVector(new SimpleVector(getPosX(), posY, getPosZ()));
    }

    public int getPosZ() {
        return posZ;
    }

    public void setPosZ(int posZ) {
        this.posZ = posZ;
        this.setSVector(new SimpleVector(getPosX(), getPosY(), posZ));
    }

    public SimpleVector getSVector() {
        return SVector;
    }

    public void setSVector(SimpleVector SVector) {
        this.SVector = SVector;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public void setColor(Color color) {
        this.objeto.setAdditionalColor(color);
    }
}

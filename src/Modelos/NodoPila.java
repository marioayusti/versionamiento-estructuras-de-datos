/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author G40
 */
public class NodoPila {
    public int numVer;
public NodoPila siguiente;
    public NodoPila() {
    }

    public NodoPila(int numVer, NodoPila siguiente) {
        this.numVer = numVer;
        this.siguiente = siguiente;
    }

    public int getNumVer() {
        return numVer;
    }

    public void setNumVer(int numVer) {
        this.numVer = numVer;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
    
}

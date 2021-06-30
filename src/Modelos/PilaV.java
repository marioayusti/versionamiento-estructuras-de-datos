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
public class PilaV {

    NodoPila cima; //(TOS (Top Of Stacks))
    NodoPila temp;

    public PilaV() {
    }

    public void reset() {
        this.cima = null;
    }

    public boolean empty() {
        return (this.cima == null);
    }

    public void push(int dato) //apilar
    {
        if (empty()) {
            this.cima = new NodoPila(dato, null);
        } else {
            this.cima = new NodoPila(dato, cima);
        }
    }

    public int peek() //muestra el elemento de la cima sin removerlo
    {
        return this.cima.getNumVer();
    }

    public int size() {
        int contador = 0;
        if (!empty()) {
            this.temp = this.cima;
            while (this.temp != null) {
                contador++;
                this.temp = this.temp.getSiguiente();
            }
        }
        return contador;
    }

    public boolean esPadre() {
        boolean esPadre = false;
        if (this.cima != null && this.cima.getSiguiente() == null) {
            esPadre = true;
        }
        return esPadre;
    }

    public int pop() //remover (desapilar)
    {
        int num = this.cima.getNumVer();
        this.cima = this.cima.getSiguiente();
        return num;
    }

    public int[] retornar() {
        int[] aux = new int[this.size()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = this.pop();
        }
        this.reset();
        return aux;
    }

    public void mostrar() {
        while (this.cima != null) {
            System.out.println(this.cima.getNumVer());
            this.cima = this.cima.getSiguiente();
        }
    }
}

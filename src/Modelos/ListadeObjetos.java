/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import com.threed.jpct.Object3D;

/**
 *
 * @author G40
 */
public class ListadeObjetos {

    public NodoObjeto cabeza;
    public NodoObjeto temp;
    public NodoObjeto ultimo;
    public NodoObjeto aux;
    public int po;

    public ListadeObjetos() {
    }

    public int IngresarObjeto(Object3D Objeto) {
        if (this.getCabeza() == null) {
            this.setCabeza(new NodoObjeto(Objeto, null, null));
            this.setUltimo(this.getCabeza());
        } else {
            this.setTemp(this.getCabeza());
            this.setPo(0);
            while (this.getTemp().getSiguiente() != null) {
                this.setPo(this.getPo() + 1);
                this.setTemp(this.getTemp().getSiguiente());
            }
            this.getTemp().setSiguiente(new NodoObjeto(Objeto, null, getTemp()));
            this.setUltimo(this.getTemp().getSiguiente());
            this.setPo(this.getPo() + 1);
        }
        return this.getPo();
    }

    public Object3D obtener(int i) {
        this.setAux(this.getCabeza());
        this.setPo(0);
        while (this.getPo() != i && this.getAux() != null) {
            this.setAux(this.getAux().getSiguiente());
            this.setPo(this.getPo() + 1);
        }
        if (this.getAux() == null) {
            return null;
        } else {
            return this.getAux().getObjeto();
        }
    }

    public void ubicarNodo(int i) {
        this.setTemp(this.getCabeza());
        this.setPo(0);
        while (this.getPo() != i && this.getTemp() != null) {
            this.setTemp(this.getTemp().getSiguiente());
            this.setPo(this.getPo() + 1);
        }
    }

    public void ubicarNodoAux(int i) {
        this.setAux(this.getCabeza());
        this.setPo(0);
        while (this.getPo() != i && this.getAux() != null) {
            this.setAux(this.getAux().getSiguiente());
            this.setPo(this.getPo() + 1);
        }
    }

    public void ubicaraUltimo() {
        while (this.cabeza != null && this.cabeza.getSiguiente() != null) {
            this.cabeza = this.cabeza.getSiguiente();
        }
        this.temp = this.cabeza;
        while (this.cabeza != null && this.cabeza.getAnterior() != null) {
            this.cabeza = this.cabeza.getAnterior();
        }
    }

    public void pasarSig() {
        if (this.getTemp().getSiguiente() != null) {
            this.setTemp(this.getTemp().getSiguiente());
        } else {
            this.setTemp(this.getCabeza());
        }
    }

    public void pasarant() {
        if (this.getTemp().getAnterior() != null) {
            this.setTemp(this.getTemp().getAnterior());
        } else {
            this.ubicaraUltimo();
        }
    }

    public int lengthlist() {
        this.setAux(this.getCabeza());
        int aux = 0;
        while (this.getAux() != null) {
            this.setAux(this.getAux().getSiguiente());
            aux++;
        }
        return (aux);
    }

    public void eliminar() {
        while (this.cabeza != this.temp) {
            this.cabeza = this.cabeza.getSiguiente();
        }
        if (this.cabeza.getSiguiente() != null) {
            this.cabeza.getSiguiente().setAnterior(this.cabeza.getAnterior());
            this.cabeza = this.cabeza.getSiguiente();
            if (this.cabeza.getAnterior() != null) {
                this.cabeza = this.cabeza.getAnterior();
                this.cabeza.setSiguiente(this.cabeza.getSiguiente().getSiguiente());
            }
        } else if (this.cabeza.getAnterior() != null) {
            this.cabeza = this.cabeza.getAnterior();
            this.cabeza.setSiguiente(null);
        } else {
            this.cabeza = null;
        }
        this.temp=this.cabeza;
        ubicaraUltimo();
    }

    public boolean estaVacia() {
        if (this.getCabeza() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comparar(ListadeObjetos listaini) {
        boolean aux = false;
        for (int i = 0; i < this.lengthlist() && !aux; i++) {
            this.ubicarNodo(i);
            listaini.ubicarNodo(i);
            aux = this.getTemp().comparar(listaini.getTemp());
        }
        return aux;
    }

    public ListadeObjetos PorValor() {
        ListadeObjetos ListaXValor = new ListadeObjetos();
        for (int i = 0; i < this.lengthlist(); i++) {
            this.ubicarNodoAux(i);
            if (ListaXValor.getCabeza() == null) {
                ListaXValor.setCabeza(new NodoObjeto(this.aux));
                ListaXValor.setUltimo(ListaXValor.getCabeza());
            } else {
                ListaXValor.setTemp(ListaXValor.getCabeza());
                while (ListaXValor.getTemp().getSiguiente() != null) {
                    ListaXValor.setTemp(ListaXValor.getTemp().getSiguiente());
                }
                ListaXValor.getTemp().setSiguiente(new NodoObjeto(this.aux));
                ListaXValor.setUltimo(ListaXValor.getTemp().getSiguiente());
            }
        }
        return ListaXValor;
    }

    public NodoObjeto getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoObjeto cabeza) {
        this.cabeza = cabeza;
    }

    public NodoObjeto getTemp() {
        return temp;
    }

    public void setTemp(NodoObjeto temp) {
        this.temp = temp;
    }

    public NodoObjeto getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoObjeto ultimo) {
        this.ultimo = ultimo;
    }

    public NodoObjeto getAux() {
        return aux;
    }

    public void setAux(NodoObjeto aux) {
        this.aux = aux;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }

}

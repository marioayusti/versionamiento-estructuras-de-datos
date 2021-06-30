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
public class ArboldeVersiones {
    public Version raiz;
    public Version temp;
    public int ultimaV = 0;
    public PilaV Camino;
    public PilaV Actualizadas;
    public PilaV Hojas;
    boolean encontrado = false;

    public ArboldeVersiones() {
        this.raiz = new Version(Color.WHITE);
        this.raiz.setNum(ultimaV);
        this.Camino = new PilaV();
        this.Actualizadas = new PilaV();
        this.Hojas = new PilaV();
    }

    public void Actualizar(int actual, Version nuevaV) {
        this.ultimaV++;
        nuevaV.setNum(this.ultimaV);
        Ubicar(actual);
        if (this.temp.getHija() != null) {
            this.temp = this.temp.getHija();
            while (this.temp.getHermana() != null) {
                this.temp = this.temp.getHermana();
            }
            this.temp.setHermana(nuevaV);
            actualizarEstados(this.temp.getHermana().getNum());
        } else {
            this.temp.setHija(nuevaV);
            actualizarEstados(this.temp.getHija().getNum());
        }
    }

    public void Ubicar(int actual) {
        int aux;
        this.temp = this.getRaiz();
        this.encontrado = false;
        camino(this.temp, actual);
        while (this.temp.getNum() != actual && !this.Camino.empty()) {
            aux = this.Camino.pop();
            while (aux != this.temp.getNum()) {
                this.temp = this.temp.getHermana();
            }
            if (!this.Camino.empty()) {
                this.temp = this.temp.getHija();
            }
        }
        this.Camino.reset();
    }

    public void UbicarPadre(int actual) {
        int aux;
        this.temp = this.getRaiz();
        this.encontrado = false;
        camino(this.temp, actual);
        while (!this.Camino.esPadre() && !this.Camino.empty()) {
            aux = this.Camino.pop();
            while (aux != this.temp.getNum()) {
                this.temp = this.temp.getHermana();
            }
            if (!this.Camino.empty() && !this.Camino.esPadre()) {
                this.temp = this.temp.getHija();
            }
        }
        this.Camino.reset();
    }

    public void camino(Version raiz, int actual) {
        while (raiz != null && !this.encontrado) {
            if (raiz.getHija() != null) {
                camino(raiz.getHija(), actual);
                if (this.encontrado) {
                    this.Camino.push(raiz.getNum());
                }
            }
            if (raiz.getNum() == actual) {
                this.encontrado = true;
                this.Camino.push(actual);
            } else {
                raiz = raiz.getHermana();
            }
        }
    }

    public void Actualizadas(Version actual) {
        while (actual != null) {
            if (actual.getHija() != null) {
                Actualizadas(actual.getHija());
            }
            this.Actualizadas.push(actual.getNum());
            actual = actual.getHermana();
        }
    }

    public void hojas(Version actual) {
        while (actual != null) {
            if (actual.getHija() == null) {
                this.Hojas.push(actual.getNum());
            } else {
                hojas(actual.getHija());
            }
            actual = actual.getHermana();
        }
    }

    public void actualizarEstados(int actual) {
        hojas(this.getRaiz());
        if (actual >= 0) {
            Ubicar(actual);
            Actualizadas(this.temp.hija);
            this.encontrado = false;
            camino(this.getRaiz(), actual);
        }
        int[] Caminos = this.Camino.retornar();
        int[] Actualizados = this.Actualizadas.retornar();
        int hoja;
        int aux;
        boolean esta = false;

        while (!this.Hojas.empty()) {
            this.temp = this.getRaiz();
            hoja = this.Hojas.pop();
            this.encontrado = false;
            camino(this.temp, hoja);
            while (!this.Camino.empty()) {
                aux = this.Camino.pop();
                while (aux != this.temp.getNum()) {
                    this.temp = this.temp.getHermana();
                }
                esta = false;
                for (int i = 0; actual >= 0 && i < Caminos.length && !esta; i++) {
                    if (this.temp.num == Caminos[i]) {
                        if (Caminos[i] == actual) {
                            this.temp.setEstado(0);
                        } else {
                            this.temp.setEstado(1);
                        }
                        esta = true;
                    }
                }
                for (int i = 0; actual >= 0 && i < Actualizados.length && !esta; i++) {
                    if (this.temp.num == Actualizados[i]) {
                        this.temp.setEstado(2);
                        esta = true;
                    }
                }
                if (!esta) {
                    this.temp.setEstado(3);
                }
                if (!this.Camino.empty()) {
                    this.temp = this.temp.getHija();
                }
            }
        }
        this.Hojas.reset();
    }

    public int eliminar(int actual) {
        if (actual > 0) {
            UbicarPadre(actual);
            int aux = this.temp.getNum();
            if (this.temp.getHija().getNum() == actual) {
                this.temp.setHija(this.temp.getHija().getHermana());
            } else {
                this.temp = this.temp.getHija();
                while (this.temp.getHermana().getNum() != actual) {
                    this.temp = this.temp.getHermana();
                }
                this.temp.setHermana(this.temp.getHermana().getHermana());
            }
            actualizarEstados(aux);
            return aux;
        } else {
            System.out.println("IMPOSIBLE ELIMINAR!!!!!!!!!");
            return 0;
        }

    }

    public int numHijos(int actual) {
        int numHijos = 0;
        Ubicar(actual);
        this.temp = this.temp.getHija();
        while (this.temp != null) {
            numHijos++;
            this.temp = this.temp.getHermana();
        }
        return numHijos;
    }

    public int size(Version raiz) {
        int num;
        if (raiz.getNum() == 0) {
            num = 1;
        } else {
            num = 0;
        }
        num += this.numHijos(raiz.getNum());
        raiz = raiz.getHija();
        while (raiz != null) {
            num += size(raiz);
            raiz = raiz.getHermana();
        }
        return num;
    }

    public Version getRaiz() {
        return raiz;
    }

    public void setRaiz(Version raiz) {
        this.raiz = raiz;
    }
}

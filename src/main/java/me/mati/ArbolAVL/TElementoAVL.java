package me.mati.ArbolAVL;

import me.mati.ArbolBB.TElementoAB;

public class TElementoAVL<T> extends TElementoAB<T> {

    public TElementoAVL(Comparable unaEtiqueta, T unosDatos) {
        super(unaEtiqueta, unosDatos);
    }

    public TElementoAVL<T> getHijoIzq() {
        if(this.hijoIzq != null){
            return ((TElementoAVL<T>) this.hijoIzq);
        }
        return null;
    }

    public TElementoAVL<T> getHijoDer() {
        if(this.hijoDer != null){
            return ((TElementoAVL<T>) this.hijoDer);
        }
        return null;
    }

    public void setHijoIzq(TElementoAVL<T> elemento) {
        this.hijoIzq = elemento;
    }

    public void setHijoDer(TElementoAVL<T> elemento) {
        this.hijoDer = elemento;
    }

    public TElementoAVL<T> rotacionLL(TElementoAVL<T> k2) {
        TElementoAVL<T> k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        return k1;
    }

    public TElementoAVL<T> rotacionRR(TElementoAVL<T> k1) {
        TElementoAVL<T> k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        return k2;
    }

    public TElementoAVL<T> rotacionLR(TElementoAVL<T> k3) {
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        return rotacionLL(k3);
    }

    public TElementoAVL<T> rotacionRL(TElementoAVL<T> k1) {
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        return rotacionRR(k1);
    }


    public TElementoAVL<T> insertar(TElementoAVL<T> elemento) {
        int comp = elemento.getEtiqueta().compareTo(getEtiqueta());

        if (comp == 0) {
            return this;
        } else if (comp < 0) {
            if (getHijoIzq() == null) {
                setHijoIzq(elemento);
            } else {
                setHijoIzq(getHijoIzq().insertar(elemento));
            }
        } else {
            if (getHijoDer() == null) {
                setHijoDer(elemento);
            } else {
                setHijoDer(getHijoDer().insertar(elemento));
            }
        }

        return balancear(this);
    }

    public TElementoAVL<T> eliminar(Comparable etiqueta){
        int comp = etiqueta.compareTo(getEtiqueta());

        if(comp < 0){
            if(getHijoIzq() != null){
                setHijoIzq(getHijoIzq().eliminar(etiqueta));
            }
        }else if(comp > 0){
            if(getHijoDer() != null){
                setHijoDer(getHijoDer().eliminar(etiqueta));
            }
        }else {
            return (TElementoAVL<T>) quitaElNodo();
        }

        return balancear(this);
    }

    private TElementoAVL<T> balancear(TElementoAVL<T> nodoActual) {
        int balance = obtenerBalance();

        if (balance <= -2) {
            if (getHijoIzq() != null) {
                if (getHijoIzq().obtenerBalance() <= -1) {
                    return rotacionLL(nodoActual);
                } else {
                    return rotacionLR(nodoActual);
                }
            }
        } else if (balance >= 2) {
            if (getHijoDer() != null) {
                if (getHijoDer().obtenerBalance() >= 1) {
                    return rotacionRR(nodoActual);
                } else {
                    return rotacionRL(nodoActual);
                }
            }
        }

        return nodoActual;
    }
}

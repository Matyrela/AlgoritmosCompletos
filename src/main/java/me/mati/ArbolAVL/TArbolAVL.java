package me.mati.ArbolAVL;

import me.mati.ArbolBB.TArbolBB;

public class TArbolAVL<T> extends TArbolBB<T> {

    private TElementoAVL<T> raiz;

    public TArbolAVL() {
        setRaiz(null);
    }

    @Override
    public TElementoAVL<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TElementoAVL<T> raiz) {
        this.raiz = raiz;
    }

    public boolean insertar(TElementoAVL<T> unElemento) {
        if (getRaiz() == null) {
            setRaiz(unElemento);
            return true;
        }

        TElementoAVL<T> temp = getRaiz().insertar(unElemento);

        if (temp != getRaiz()) {
            setRaiz(temp);
        }

        return true;
    }


    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(getRaiz() != null){
            setRaiz(getRaiz().eliminar(unaEtiqueta));
        }
    }
}
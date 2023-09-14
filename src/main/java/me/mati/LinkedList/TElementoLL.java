package me.mati.LinkedList;

import me.mati.ArbolBB.TElementoAB;
import me.mati.Interfaces.IElementoLL;

public class TElementoLL<T> implements IElementoLL<T> {

    public TElementoLL(Comparable etiqueta, T datos){
        this.etiqueta = etiqueta;
        this.datos = datos;
    }

    private Comparable etiqueta;
    private T datos;
    private IElementoLL<T> siguiente;

    @Override
    public T getDato() {
        return datos;
    }

    public void setDato(T datos) {
        this.datos = datos;
    }

    public boolean equals(IElementoLL unNodo) {
        return getDato().equals(unNodo.getDato());
    }

    @Override
    public IElementoLL getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(IElementoLL nodo) {
        siguiente = nodo;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public void imprimirEtiqueta() {

    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        if(etiqueta == null) return;
        this.etiqueta = etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
}

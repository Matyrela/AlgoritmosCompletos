package me.mati.LinkedList;

import me.mati.Interfaces.IElementoLL;
import me.mati.Interfaces.ILinkedList;

public class TLinkedList<T> implements ILinkedList<T> {

    private IElementoLL<T> cabeza;
    private int cantElementos;

    @Override
    public void insertar(IElementoLL<T> nodo) {
        if(nodo == null) return;

        cantElementos++;

        if(cabeza == null) {
            cabeza = nodo;
            return;
        }
        IElementoLL<T> aux = cabeza;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nodo);
    }

    public void insertar(Comparable etiqueta, T datos) {
        if(etiqueta == null) return;

        IElementoLL<T> nuevo = new TElementoLL<>(etiqueta, datos);
        insertar(nuevo);
    }

    @Override
    public IElementoLL buscar(Comparable clave) {
        if(cabeza == null) return null;
        if(clave == null) return null;

        IElementoLL<T> aux = cabeza;
        while (aux != null) {
            if(aux.getEtiqueta().compareTo(clave) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if(cabeza == null) return false;
        if(clave == null) return false;

        if(cabeza.getEtiqueta().compareTo(clave) == 0) {
            cabeza = cabeza.getSiguiente();
            cantElementos--;
            return true;
        }

        IElementoLL<T> aux = cabeza;
        for (int i = 0; i < cantElementos - 1; i++){
            if(aux.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                cantElementos--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        IElementoLL<T> aux = cabeza;
        while (aux != null) {
            sb.append(aux.getEtiqueta() + " -> ");
            aux = aux.getSiguiente();
        }
        return sb.toString().substring(0, sb.length() - 4);
    }

    @Override
    public String imprimir(String separador) {
        if(separador == null) return imprimir();

        StringBuilder sb = new StringBuilder();
        IElementoLL<T> aux = cabeza;
        while (aux != null) {
            sb.append(aux.getEtiqueta() + separador);
            aux = aux.getSiguiente();
        }
        return sb.toString().substring(0, sb.length() - separador.length());
    }

    @Override
    public int cantElementos() {
        return cantElementos;
    }

    @Override
    public boolean esVacia() {
        return (cantElementos == 0);
    }

    @Override
    public void setPrimero(IElementoLL unNodo) {
        if(unNodo == null) return;

        if(cabeza == null) {
            cabeza = unNodo;
        }else {
            unNodo.setSiguiente(cabeza);
            cabeza = unNodo;
        }
    }

    @Override
    public String toString() {
        return imprimir();
    }
}

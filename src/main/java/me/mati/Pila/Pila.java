package me.mati.Pila;

import me.mati.Interfaces.IElementoLL;

public class Pila<T>{

    private Nodo<T> primero;

    public Pila() {
        primero = null;
    }


    public void push(Nodo<T> nodo) {
        if (esVacia()) {
            primero = nodo;
        } else {
            nodo.setSiguiente(primero);
            primero = nodo;
        }
    }

    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public void pop() {
        Nodo aux = primero;
        primero = primero.getSiguiente();
        aux.setSiguiente(null);
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> aux = primero;
        while (aux != null) {
            sb.append(aux.getEtiqueta() + ", ");
            aux = aux.getSiguiente();
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String imprimir(String separador) {
        if(separador == null) return imprimir();
        StringBuilder sb = new StringBuilder();
        Nodo<T> aux = primero;
        while (aux != null) {
            sb.append(aux.getEtiqueta() + separador);
            aux = aux.getSiguiente();
        }
        return sb.toString().substring(0, sb.length() - separador.length());
    }


    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }


    public boolean esVacia() {
        if (primero == null){
            return true;
        } else {
            return false;
        }

    }


    public void setPrimero(Nodo<T> unNodo) {
        if(unNodo == null) return;

        if(primero == null) {
            primero = unNodo;
        }else {
            unNodo.setSiguiente(primero);
            primero = unNodo;
        }
    }


    // implementar los metodos indicados en la interfaz
}


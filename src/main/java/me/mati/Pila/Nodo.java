package me.mati.Pila;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Nodo<T>{

    private final Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;

    }


    public Comparable getEtiqueta() {
        return this.etiqueta;
    }


    public void imprimir() {
        System.out.println(dato.toString());
    }


    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

    /**
     *
     * @param unNodo
     * @return
     */

    public boolean equals(Nodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }


    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }


    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

}


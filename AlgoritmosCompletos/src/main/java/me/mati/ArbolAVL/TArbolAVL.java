package me.mati.ArbolAVL;

import me.mati.ArbolBB.*;

public class TArbolAVL<T> {

    protected TElementoAVL<T> raiz;

    public TArbolAVL() {
        raiz = null;
    }

    public TElementoAVL getRaiz() {
        return raiz;
    }

    public boolean insertar(TElementoAVL unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        }

        TElementoAVL temp = raiz.insertar(unElemento); // Llama a insertar en el nodo raíz

        if (temp != raiz) {
            raiz = temp;
        }

        return true;
    }


    public TElementoAVL<T> buscar(Comparable unaEtiqueta) {
        if(raiz != null){
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    public String preOrden() {
        if(raiz != null){
            String resultado = raiz.preOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    public String inOrden() {
        if(raiz != null){
            String resultado = raiz.inOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    public String postOrden() {
        if(raiz != null){
            String resultado = raiz.postOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    public void eliminar(Comparable unaEtiqueta) {
        if(raiz != null){
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    public int buscarNivel(Comparable unaEtiqueta) {
        if(raiz != null){
            return raiz.buscarNivel(unaEtiqueta);
        }
        return 0;
    }

    public int obtenerAltura(){
        if(raiz != null){
            return raiz.obtenerAltura();
        }
        return 0;
    }

    public int obtenerTamaño(){
        if(raiz != null){
            return raiz.obtenerTamaño();
        }
        return 0;
    }

    public int obtenerCantidadHojas(){
        if(raiz != null){
            return raiz.obtenerCantidadHojas();
        }
        return 0;
    }
}
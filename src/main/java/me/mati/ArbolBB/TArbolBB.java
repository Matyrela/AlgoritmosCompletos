package me.mati.ArbolBB;

import me.mati.Interfaces.IArbolBB;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public TArbolBB() {
        setRaiz(null);
    }

    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (getRaiz() == null) {
            setRaiz(unElemento);
            return true;
        }
        return getRaiz().insertar(unElemento);
    }

    public int insertarConNivel(TElementoAB<T> unElemento) {
        if (getRaiz() == null) {
            setRaiz(unElemento);
            return 0;
        }
        int cont = 0;
        return getRaiz().insertarConNivel(cont, unElemento);
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if(getRaiz() != null){
            return getRaiz().buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrden() {
        if(getRaiz() != null){
            String resultado = getRaiz().preOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    @Override
    public String inOrden() {
        if(getRaiz() != null){
            String resultado = getRaiz().inOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    @Override
    public String postOrden() {
        if(getRaiz() != null){
            String resultado = getRaiz().postOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(getRaiz() != null){
            setRaiz(getRaiz().eliminar(unaEtiqueta));
        }
    }

    public int buscarNivel(Comparable unaEtiqueta) {
        if(getRaiz() != null){
            return getRaiz().buscarNivel(unaEtiqueta);
        }
        return 0;
    }

    public int obtenerAltura(){
        if(getRaiz() != null){
            return getRaiz().obtenerAltura();
        }
        return 0;
    }

    public int obtenerTamaño(){
        if(getRaiz() != null){
            return getRaiz().obtenerTamaño();
        }
        return 0;
    }

    public int obtenerCantidadHojas(){
        if(getRaiz() != null){
            return getRaiz().obtenerCantidadHojas();
        }
        return 0;
    }
}

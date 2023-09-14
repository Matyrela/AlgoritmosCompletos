package me.mati.ArbolBB;

public class TArbolBB<T> implements IArbolBB<T> {

    protected TElementoAB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    public TElementoAB getRaiz() {
        return raiz;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        }
        return raiz.insertar(unElemento);
    }

    public int insertarConNivel(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return 0;
        }
        int cont = 0;
        return raiz.insertarConNivel(cont, unElemento);
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if(raiz != null){
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrden() {
        if(raiz != null){
            String resultado = raiz.preOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    @Override
    public String inOrden() {
        if(raiz != null){
            String resultado = raiz.inOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    @Override
    public String postOrden() {
        if(raiz != null){
            String resultado = raiz.postOrden();
            return resultado.substring(0, resultado.length() - 4);
        }else {
            return "";
        }
    }

    @Override
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

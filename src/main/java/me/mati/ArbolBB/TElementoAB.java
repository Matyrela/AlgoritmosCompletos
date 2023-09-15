package me.mati.ArbolBB;

import me.mati.Interfaces.IElementoAB;

public class TElementoAB<T> implements IElementoAB<T> {

    protected Comparable etiqueta;
    protected TElementoAB hijoIzq;
    protected TElementoAB hijoDer;
    protected T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public int obtenerBalance(){
        int alturaIzq = 0;
        int alturaDer = 0;

        if(getHijoIzq() != null){
            alturaIzq = getHijoIzq().obtenerAltura();
        }

        if(getHijoDer() != null){
            alturaDer = getHijoDer().obtenerAltura();
        }

        return alturaDer - alturaIzq;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        if(elemento != null){
            this.hijoIzq = elemento;
        }
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        if(elemento != null){
            this.hijoDer = elemento;
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        int comp = unaEtiqueta.compareTo(getEtiqueta());

        if(comp == 0){
            return this;
        }else if(comp < 0 && getHijoIzq() != null) {
            return getHijoIzq().buscar(unaEtiqueta);
        }else if(comp > 0 && getHijoDer() != null) {
            return getHijoDer().buscar(unaEtiqueta);
        }else {
            return null;
        }
    }

    public int buscarNivel(Comparable unaEtiqueta) {
        int nivel = 0;
        int comp = unaEtiqueta.compareTo(getEtiqueta());

        if(comp == 0){
            return nivel;
        }else if(comp < 0 && getHijoIzq() != null) {
            nivel++;
            return nivel + getHijoIzq().buscarNivel(unaEtiqueta);
        }else if(comp > 0 && getHijoDer() != null) {
            nivel++;
            return nivel + getHijoDer().buscarNivel(unaEtiqueta);
        }else {
            return -1;
        }
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        int comp = elemento.getEtiqueta().compareTo(getEtiqueta());
        if(comp == 0){
            return false;
        }else if (comp < 0){
            if(getHijoIzq() == null){
                setHijoIzq(elemento);
                return true;
            }else {
                return getHijoIzq().insertar(elemento);
            }
        }else {
            if(getHijoDer() == null){
                setHijoDer(elemento);
                return true;
            }else {
                return getHijoDer().insertar(elemento);
            }
        }
    }

    public int insertarConNivel(int contador, TElementoAB<T> elemento) {
        contador += 1;
        if (elemento.etiqueta.compareTo(etiqueta) == 0) {
            return contador;
        }
        if (elemento.etiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return contador;
            } else {
                return hijoIzq.insertarConNivel(contador, elemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
                return contador;
            } else {
                return hijoDer.insertarConNivel(contador, elemento);
            }
        }
    }
    @Override
    public String preOrden() {
        String preOrden = "";
        //PreOrden Interactuo con el elemento padre al principio
        preOrden += etiqueta + " -> ";

        if (hijoIzq != null) {
            preOrden += hijoIzq.preOrden();
        }

        if (hijoDer != null) {
            preOrden += hijoDer.preOrden();
        }
        return preOrden;
    }

    @Override
    public String inOrden() {
        String inOrden = "";
        if (hijoIzq != null) {
            inOrden += hijoIzq.inOrden();
        }

        //InOrden Interactuo con el elemento padre en el medio
        inOrden += etiqueta + " -> ";

        if (hijoDer != null) {
            inOrden += hijoDer.inOrden();
        }
        return inOrden;
    }

    @Override
    public String postOrden(){
        String postOrden = "";
        if (hijoIzq != null) {
            postOrden += hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            postOrden += hijoDer.postOrden();
        }
        //PostOrden Interactuo con el elemento padre al final
        postOrden += etiqueta + " -> ";
        return postOrden;
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        int comp = unaEtiqueta.compareTo(getEtiqueta());

        if(comp < 0){
            if(getHijoIzq() != null){
                setHijoIzq(getHijoIzq().eliminar(unaEtiqueta));
            }
        }else if(comp > 0){
            if(getHijoDer() != null){
                setHijoDer(getHijoDer().eliminar(unaEtiqueta));
            }
        }else {
            return quitaElNodo();
        }
        return this;
    }

    protected TElementoAB quitaElNodo() {
        if(getHijoIzq() == null){
            return getHijoDer();
        }
        if(getHijoDer() == null){
            return getHijoIzq();
        }

        TElementoAB<T> elHijo = getHijoIzq();
        TElementoAB<T> elPadre = this;
        while (elHijo.getHijoDer() != null){
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this){
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(getHijoIzq());
        }

        elHijo.setHijoDer(getHijoDer());
        return elHijo;
    }

    public int obtenerAltura() {
        int AlturaDer = 0;
        int AlturaIzq = 0;

        if (hijoDer != null) {
            AlturaDer = hijoDer.obtenerAltura();
        }

        if (hijoIzq != null) {
            AlturaIzq = hijoIzq.obtenerAltura();
        }

        return 1 + Math.max(AlturaDer, AlturaIzq);
    }

    public int obtenerTamaño() {
        int tamaño = 1;

        if (hijoDer != null)
        {
            tamaño += hijoDer.obtenerTamaño();
        }

        if (hijoIzq != null)
        {
            tamaño += hijoIzq.obtenerTamaño();
        }

        return tamaño;
    }

    public int obtenerCantidadHojas() {
        int cantidadHojas = 0;

        if (hijoDer != null)
        {
            cantidadHojas += hijoDer.obtenerCantidadHojas();
        }

        if (hijoIzq != null)
        {
            cantidadHojas += hijoIzq.obtenerCantidadHojas();
        }

        if (hijoDer == null && hijoIzq == null)
        {
            cantidadHojas++;
        }

        return cantidadHojas;
    }
}

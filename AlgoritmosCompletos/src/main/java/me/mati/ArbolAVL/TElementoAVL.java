package me.mati.ArbolAVL;

import jdk.jshell.spi.ExecutionControl;

public class TElementoAVL<T> {

    private Comparable etiqueta;
    private TElementoAVL hijoIzq;
    private TElementoAVL hijoDer;
    private T datos;

    public TElementoAVL(Comparable unaEtiqueta, T unosDatos) {
        this.etiqueta = unaEtiqueta;
        this.datos = unosDatos;
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


    public Comparable getEtiqueta() {
        return this.etiqueta;
    }


    public TElementoAVL<T> getHijoIzq() {
        if(this.hijoIzq != null){
            return this.hijoIzq;
        }
        return null;
    }


    public TElementoAVL<T> getHijoDer() {
        if(this.hijoDer != null){
            return this.hijoDer;
        }
        return null;
    }


    public void setHijoIzq(TElementoAVL<T> elemento) {
        this.hijoIzq = elemento;
    }

    public void setHijoDer(TElementoAVL<T> elemento) {
        this.hijoDer = elemento;
    }


    public TElementoAVL<T> buscar(Comparable unaEtiqueta) {

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


    public T getDatos() {
        return null;
    }


    public TElementoAVL eliminar(Comparable unaEtiqueta) {
        return null;
    }

    private TElementoAVL quitaElNodo(TElementoAVL asd) {
        if(getHijoIzq() == null){
            return getHijoDer();
        }
        if(getHijoDer() == null){
            return getHijoIzq();
        }

        TElementoAVL elHijo = getHijoIzq();
        TElementoAVL elPadre = this;
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

    public TElementoAVL rotacionLL(TElementoAVL k2) {
        TElementoAVL k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        return k1;
    }

    public TElementoAVL rotacionRR(TElementoAVL k1) {
        TElementoAVL k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        return k2;
    }

    public TElementoAVL rotacionLR(TElementoAVL k3) {
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        return rotacionLL(k3);
    }

    public TElementoAVL rotacionRL(TElementoAVL k1) {
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        return rotacionRR(k1);
    }


    public TElementoAVL insertar(TElementoAVL elemento) {
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
        return balancear();
    }

    private TElementoAVL balancear() {
        int balance = obtenerBalance();
        if (balance <= -2) {
            if (getHijoIzq() != null) {
                if (getHijoIzq().obtenerBalance() <= -1) {
                    System.out.println("Rotacion LL");
                    return rotacionLL(this);
                } else {
                    System.out.println("Rotacion LR");
                    return rotacionLR(this);
                }
            }
        } else if (balance >= 2) {
            if (getHijoDer() != null) {
                if (getHijoDer().obtenerBalance() >= 1) {
                    System.out.println("Rotacion RR");
                    return rotacionRR(this);
                } else {
                    System.out.println("Rotacion RL");
                    return rotacionRL(this);
                }
            }
        }

        return this;
    }
}
